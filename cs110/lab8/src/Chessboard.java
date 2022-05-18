public class Chessboard {

    String[][] board;
    final int CHAR_CONV = 97;

    public Chessboard(){
        board = new String[8][8];
    }


    public String getPiece(char rowLetter, int column){
        column--;
        int row = (int)rowLetter - CHAR_CONV;

        return board[row][column];
    }

    public void setPiece(String piece, char rowLetter, int column){
        column--;
        int row = (int)rowLetter - CHAR_CONV;

        board[row][column] = piece;
    }
}
