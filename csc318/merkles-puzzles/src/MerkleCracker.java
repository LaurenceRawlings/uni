import javax.crypto.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

/**
 * Extension class that can be run to crack all puzzles that are encrypted in a file.
 * @author Laurence Rawlings
 */
public class MerkleCracker {
    private final String fileName;
    private Cipher cipher;

    public MerkleCracker(String fileName) {
        this.fileName = fileName;

        try {
            cipher = Cipher.getInstance("DES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MerkleCracker cracker = new MerkleCracker("puzzles.bin");
        cracker.crackAllPuzzles();
    }

    /**
     * Cracks all the puzzles in the file and add the decrypted puzzles to a list.
     * @return The list of decrypted puzzles.
     */
    public ArrayList<Puzzle> crackAllPuzzles() {
        ArrayList<byte[]> encryptedPuzzles = new ArrayList<>();
        ArrayList<Puzzle> decryptedPuzzles = new ArrayList<>();

        try {
            byte[] file = Files.readAllBytes(Paths.get(fileName));

            for (int i = 0; i < 4096; i++) {
                byte[] puzzle = new byte[32];
                System.arraycopy(file, i * 32, puzzle, 0, 32);
                encryptedPuzzles.add(puzzle);
            }

            int i = 1;
            for (byte[] encryptedPuzzle : encryptedPuzzles) {
                System.out.printf("[INFO] Cracking puzzle %d...%n", i++);
                Puzzle p = crackPuzzle(encryptedPuzzle);

                if (p != null) {
                    decryptedPuzzles.add(p);
                    System.out.printf("[DONE] Puzzle {%n");
                    System.out.printf("%s%n}%n%n", p.toString());
                } else {
                    System.out.printf("[FAIL] Key not found!%n%n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return decryptedPuzzles;
    }

    /**
     * Brute forces a byte array using all possible keys to and uses the result to create a puzzle object.
     * @param encryptedPuzzle The encrypted puzzle bytes.
     * @return The decrypted puzzle object or null if all keys were exhausted.
     */
    private Puzzle crackPuzzle(byte[] encryptedPuzzle) {
        for (int i = 0; i < 65536; i++) {
            byte[] key = new byte[8];
            System.arraycopy(CryptoLib.smallIntToByteArray(i), 0, key, 0, 2);
            byte[] padding = new byte[16];
            byte[] decryptedBytes = decrypt(encryptedPuzzle, key);

            if (decryptedBytes != null) {
                System.arraycopy(decryptedBytes, 0, padding, 0, 16);

                if (CryptoLib.byteArrayToSmallInt(padding) == 0) {
                    byte[] puzzleNumber = new byte[2];
                    byte[] puzzleKey = new byte[8];

                    System.arraycopy(decryptedBytes, 16, puzzleNumber, 0, 2);
                    System.arraycopy(decryptedBytes, 18, puzzleKey, 0, 8);

                    try {
                        return new Puzzle(CryptoLib.byteArrayToSmallInt(puzzleNumber), CryptoLib.createKey(puzzleKey));
                    } catch (InvalidKeySpecException | NoSuchAlgorithmException | InvalidKeyException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return null;
    }

    /**
     * Decrypts a byte array using the provided key byte array.
     * @param bytes The bytes to attempt decryption.
     * @param key The key in byte array form to use as the SecretKey for decryption.
     * @return The decrypted byte array or null if the decryption failed.
     */
    private byte[] decrypt(byte[] bytes, byte[] key) {
        try {
            SecretKey secretKey = CryptoLib.createKey(key);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(bytes);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException ignored) {
        }

        return null;
    }
}
