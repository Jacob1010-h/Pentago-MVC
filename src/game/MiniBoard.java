package game;

public class MiniBoard {
    private BoardCell[][] miniBoard;

    public MiniBoard(BoardCell[][] miniBoard) {
        this.miniBoard = miniBoard;
//		initMiniBoard();
        initMiniBoard();
    }

    public MiniBoard() {
    }


    /**
     * The getMiniBoard function returns the miniBoard array.
     *
     * @return BoardCell[][] - the miniBoard array
     */
    public BoardCell[][] getMiniBoard() {
        return miniBoard;
    }

    /**
     * The initMiniBoard function initializes the miniBoard array with empty BoardCell objects.
     */
    public void initMiniBoard() {
        for (int i = 0; i < Constants.MINI_BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.MINI_BOARD_SIZE; j++) {
                this.miniBoard[i][j] = new BoardCell(Constants.EMPTY);
            }
        }
    }

    /**
     * The initMiniBoardRand function initializes the miniBoard array with random values.
     */
    public void initMiniBoardRand() {
        for (int i = 0; i < Constants.MINI_BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.MINI_BOARD_SIZE; j++) {
                this.miniBoard[i][j] = new BoardCell((int) (Math.random() * 3 - 1));
            }
        }
    }

    /**
     * The getCell function returns the BoardCell object at a given row and column.
     *
     * @param row Specify the row of the cell to be returned
     * @param col Specify the column of the cell to be returned
     *
     */
    public BoardCell getCell(int row, int col) {
        return this.miniBoard[row][col];
    }

    /**
     * The setCell function sets the cell at a given row and column to a new value.
     *
     * @param row Determine the row of the cell that is being set
     * @param col Set the column of the cell
     * @param cell Set the cell at the specified row and column
     *
     */
    public void setCell(int row, int col, BoardCell cell) {
        this.miniBoard[row][col] = cell;
    }

    /**
     * The getCellValue function returns the value of a cell in the miniBoard.
     *
     * @param row Specify which row the cell is in
     * @param col Get the column of the cell
     * @return The value of the cell at the given row and column
     */
    public int getCellValue(int row, int col) {
        return this.miniBoard[row][col].getValue();
    }

    /**
     * The rotateClockwise function rotates the miniBoard clockwise by 90 degrees.
     * It does this by creating a temporary board, copying the values of miniBoard to it, and then rotating those values and applying them to miniBoard.
     */
    public void rotateClockwise() {
        // create temp board
        BoardCell[][] temp = new BoardCell[Constants.MINI_BOARD_SIZE][Constants.MINI_BOARD_SIZE];
        // copy the miniBoard to the temp board
        for (int i = 0; i < Constants.MINI_BOARD_SIZE; i++) {
            System.arraycopy(this.miniBoard[i], 0, temp[i], 0, Constants.MINI_BOARD_SIZE);
        }
        // Rotate the values and apply them to miniBoard
        for (int row = 0; row < Constants.MINI_BOARD_SIZE; row++) {
            for (int col = 0; col < Constants.MINI_BOARD_SIZE; col++) {
                this.miniBoard[row][col] = temp[Constants.MINI_BOARD_SIZE - col - 1][row];
            }
        }


    }

    /**
     * The rotateCounterClockwise function rotates the miniBoard counter-clockwise.
     * It does this by creating a temporary board, copying the values of miniBoard to it, and then rotating those values and applying them to miniBoard.
     */
    public void rotateCounterClockwise() {
        // create temp board
        BoardCell[][] temp = new BoardCell[Constants.MINI_BOARD_SIZE][Constants.MINI_BOARD_SIZE];
        // copy the miniBoard to the temp board
        for (int i = 0; i < Constants.MINI_BOARD_SIZE; i++) {
            System.arraycopy(this.miniBoard[i], 0, temp[i], 0, Constants.MINI_BOARD_SIZE);
        }
        // Rotate the values and apply them to miniBoard
        for (int row = 0; row < Constants.MINI_BOARD_SIZE; row++) {
            for (int col = 0; col < Constants.MINI_BOARD_SIZE; col++) {
                this.miniBoard[row][col] = temp[col][Constants.MINI_BOARD_SIZE - row - 1];
            }
        }
    }

    public void makeMove(int row, int col, Player player) {
        this.miniBoard[row][col].setValue(player.getColor());
    }

    public void printBoard() {
        for (int i = 0; i < Constants.MINI_BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.MINI_BOARD_SIZE; j++) {
                System.out.print(this.miniBoard[i][j].getValue() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
