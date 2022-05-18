import javax.crypto.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Utility class to create random puzzles, encrypt and save them to a file.
 * @author Laurence Rawlings (991368)
 */
public class PuzzleCreator {
    public static final int NUMBER_OF_PUZZLES = 4096;
    public static final String ENCRYPTION_ALGORITHM = "DES";

    private ArrayList<Puzzle> puzzles;

    public PuzzleCreator() {

    }

    /**
     * Generates a list of puzzles with random keys and unique numbers ad saves them to the object instance.
     * @return The list of generated puzzles.
     */
    public ArrayList<Puzzle> createPuzzles() {
        puzzles = new ArrayList<>();

        for (int i = 1; i <= NUMBER_OF_PUZZLES; i++) {
            try {
                puzzles.add(new Puzzle(i, CryptoLib.createKey(createRandomKey())));
            } catch (InvalidKeySpecException | NoSuchAlgorithmException | InvalidKeyException e) {
                e.printStackTrace();
            }
        }

        return puzzles;
    }

    /**
     * Generates a random byte array that can be used a SecretKeys for puzzles.
     * @return The random key in byte array form.
     */
    public byte[] createRandomKey() {
        Random r = new Random();
        byte[] key = new byte[Puzzle.PUZZLE_KEY_BYTES];
        byte[] randomBytes = new byte[Puzzle.PUZZLE_NUMBER_BYTES];

        r.nextBytes(randomBytes);
        System.arraycopy(randomBytes, 0, key, 0, Puzzle.PUZZLE_NUMBER_BYTES);

        return key;
    }

    /**
     * Encrypt a puzzle using the specified key.
     * @param key The key in byte array for to use for the encryption.
     * @param puzzle The puzzle to encrypt.
     * @return The encrypted bytes or null if the encryption fails.
     */
    public byte[] encryptPuzzle(byte[] key, Puzzle puzzle) {
        try {
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            SecretKey secretKey = CryptoLib.createKey(key);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            return cipher.doFinal(puzzle.getPuzzleAsBytes());
        } catch (InvalidKeySpecException | NoSuchAlgorithmException | InvalidKeyException |
                NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Uses the list of puzzles and encrypts each one, then saves them to a file.
     * @param fileName Name of the file to save the puzzles to.
     */
    public void encryptPuzzlesToFile(String fileName) {
        // Shuffle the list of puzzles for better security in the puzzle file.
        Collections.shuffle(puzzles);

        try (FileOutputStream stream = new FileOutputStream(fileName)) {
            for (Puzzle puzzle : puzzles) {
                stream.write(encryptPuzzle(createRandomKey(), puzzle));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for the the puzzle with the specified number and gets its SecretKey.
     * @param puzzleNumber Number of the puzzle to get the key for.
     * @return The key of the specified puzzle or null if a puzzle with that number was not found.
     */
    public SecretKey findKey(int puzzleNumber) {
        for (Puzzle puzzle : puzzles) {
            if (puzzle.getPuzzleNumber() == puzzleNumber) {
                return puzzle.getKey();
            }
        }

        return null;
    }
}
