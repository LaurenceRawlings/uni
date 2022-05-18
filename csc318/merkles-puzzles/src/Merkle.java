import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Runnable class to test communication using the Merkle protocol.
 * @author Laurence Rawlings
 */
public class Merkle {
    public static void main(String[] args) {
        final String FILE = "puzzles.bin";
        final String MESSAGE = "Testing Merkles Puzzles!";

        Random r = new Random();

        PuzzleCreator creator = new PuzzleCreator();

        creator.createPuzzles();
        creator.encryptPuzzlesToFile(FILE);

        PuzzleCracker cracker = new PuzzleCracker(FILE);
        Puzzle puzzle = cracker.crack(r.nextInt(PuzzleCreator.NUMBER_OF_PUZZLES));
        SecretKey key = creator.findKey(puzzle.getPuzzleNumber());

        try {
            Cipher cipher = Cipher.getInstance(PuzzleCreator.ENCRYPTION_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);

            cracker.decryptMessage(cipher.doFinal(MESSAGE.getBytes()));
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException |
                BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}
