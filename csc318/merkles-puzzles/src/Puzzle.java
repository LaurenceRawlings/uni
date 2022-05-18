import javax.crypto.SecretKey;

/**
 * Class to model a single puzzle.
 * @author Laurence Rawlings (991368)
 */
public class Puzzle {
    public static final int PUZZLE_PADDING_BYTES = 16;
    public static final int PUZZLE_NUMBER_BYTES = 2;
    public static final int PUZZLE_KEY_BYTES = 8;

    private final int puzzleNumber;
    private final SecretKey key;

    public Puzzle(int puzzleNumber, SecretKey puzzleKey) {
        this.puzzleNumber = puzzleNumber;
        this.key = puzzleKey;
    }

    public int getPuzzleNumber() {
        return puzzleNumber;
    }

    public SecretKey getKey() {
        return key;
    }

    /**
     * Combines the puzzle number and key into a byte array with the padding.
     * @return The puzzle as a byte array in the required form.
     */
    public byte[] getPuzzleAsBytes() {
        byte[] puzzleBytes = new byte[PUZZLE_PADDING_BYTES + PUZZLE_NUMBER_BYTES + PUZZLE_KEY_BYTES];
        byte[] puzzleNumber = CryptoLib.smallIntToByteArray(this.puzzleNumber);
        byte[] puzzleKey = key.getEncoded();

        System.arraycopy(puzzleNumber, 0, puzzleBytes, PUZZLE_PADDING_BYTES, PUZZLE_NUMBER_BYTES);
        System.arraycopy(puzzleKey, 0, puzzleBytes, PUZZLE_PADDING_BYTES + PUZZLE_NUMBER_BYTES,
                PUZZLE_KEY_BYTES);

        return puzzleBytes;
    }

    @Override
    public String toString() {
        return String.format("Number: %d%nKey: 0x%s",
                puzzleNumber, CryptoLib.getHexStringRepresentation(key.getEncoded()));
    }
}
