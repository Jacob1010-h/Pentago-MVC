package game;

public class test {
    private static BoardCell[][] squares = new BoardCell[Constants.MINI_BOARD_SIZE][Constants.MINI_BOARD_SIZE];
    private static Rotation rotation = new Rotation();
    public static void main(String[] args) {
        // test the rotate clockwise method
        MiniBoard mb = new MiniBoard(squares, rotation);
        mb.populateMiniBoard();
        // populate the board with random values
        for (int i = 0; i < Constants.MINI_BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.MINI_BOARD_SIZE; j++) {
                mb.getCell(i, j).setValue((int) (Math.random() * 3) - 1);
            }
        }
        mb.getCell(1, 1).setValue(0);
        // print the board before rotation
        System.out.println("Before rotation:");
        for (int i = 0; i < Constants.MINI_BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.MINI_BOARD_SIZE; j++) {
                System.out.print(mb.getCell(i, j).getValue() + " ");
            }
            System.out.println();
        }
        // rotate the board
        mb.rotateClockwise();
        // print the board after rotation
        System.out.println("After rotation:");
        for (int i = 0; i < Constants.MINI_BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.MINI_BOARD_SIZE; j++) {
                System.out.print(mb.getCell(i, j).getValue() + " ");
            }
            System.out.println();
        }

    }
}


