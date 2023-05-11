package game;

import java.util.Arrays;

public class Test {

    static Board board = new Board(new BoardCell[Constants.BOARD_SIZE][Constants.BOARD_SIZE]);
    static MiniBoard[] miniBoards = new MiniBoard[Constants.MINI_BOARD_AMOUNT];
    static MiniBoardHelper miniBoardHelper = new MiniBoardHelper(miniBoards);

    static Player white = new Player(Constants.WHITE);
    public static void main(String[] args) {
        MiniBoard[] miniBoards1 = miniBoardHelper.getMiniBoards();
        Arrays.stream(miniBoards1).forEach(i -> {System.out.println("Board "+i+":"); i.printBoard(); });
        System.out.println();


        board.copyBoard(miniBoardHelper);
        board.printBoard();
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                miniBoardHelper.makeMove(white, i, j);
            }
        }
        board.copyBoard(miniBoardHelper);
        board.printBoard();

    }
}
