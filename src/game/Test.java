package game;

import java.util.Arrays;

public class Test {

    static Board board = new Board(new BoardCell[Constants.BOARD_SIZE][Constants.BOARD_SIZE]);
    static MiniBoard[] miniBoards = new MiniBoard[Constants.MINI_BOARD_AMOUNT];
    static MiniBoardHelper miniBoardHelper = new MiniBoardHelper(miniBoards);
    public static void main(String[] args) {
        for (int i = 0; i < Constants.MINI_BOARD_AMOUNT; i++) {
            int finalI = i;
            Arrays.stream(miniBoardHelper.getMiniBoards()[i].getMiniBoard()).forEach(row -> Arrays.fill(row, new BoardCell(finalI % 2 == 0 ? Constants.BLACK : Constants.WHITE)));
        }

        board.copyBoard(miniBoardHelper);
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                System.out.print(board.getCell(i, j).getValue() + " ");
            }
            System.out.println();
        }
    }
}
