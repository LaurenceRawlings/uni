public class Main {

    public static void main(String[] args) {

        Chessboard myChessBoard = new Chessboard();
        myChessBoard.setPiece("White King", 'a', 4);
        System.out.println(myChessBoard.getPiece('a', 4));
    }
}
