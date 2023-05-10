package game;

import java.util.Arrays;

public class Test {

    static Board board = new Board(new BoardCell[Constants.BOARD_SIZE][Constants.BOARD_SIZE]);
    static MiniBoard[] miniBoards = new MiniBoard[Constants.MINI_BOARD_AMOUNT];
    static MiniBoardHelper miniBoardHelper = new MiniBoardHelper(miniBoards);
    public static void main(String[] args) {
        MiniBoard[] miniBoards1 = miniBoardHelper.getMiniBoards();
        Arrays.stream(miniBoards1).forEach(i -> {System.out.println("Board "+i+":"); i.printBoard(); });
        System.out.println();


        board.copyBoard(miniBoardHelper);
        board.printBoard();
    }
}
