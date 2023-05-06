package game;

public class Board {
    private BoardCell[][] board;

    public Board(BoardCell[][] board){
        this.board = board;
        initBoard();
    }

    public BoardCell[][] getBoard(){
        return board;
    }

    public void initBoard(){
        for(int i = 0; i < Constants.BOARD_SIZE; i++){
            for(int j = 0; j < Constants.BOARD_SIZE; j++){
                this.board[i][j] = new BoardCell(Constants.EMPTY);
            }
        }
    }

    /**
     * The getCell function returns the BoardCell object at a given row and column.
     *
     * @param row Specify the row of the cell that is being returned
     * @param col Specify the column of the cell that is being returned
     */
    public BoardCell getCell(int row, int col) {
        return this.board[row][col];
    }

    /**
     * The setCell function sets the value of a cell in the board.
     *
     * @param row the row of the cell
     * @param col the column of the cell
     * @param value the value of a cell
     *
     */
    public void setCell(int row, int col, int value) {
        this.board[row][col].setValue(value);
    }


    // create a copy board method that copies a mini board to a quadrant of the board

    /**
     * The copyBoard function takes a MiniBoard[] object as arguments.
     * The function iterates through each mini-board in the array, and then iterates through each cell in that mini-board.
     * It then sets the value of that cell on this board to be equal to the value of that same cell on the mini-boards.
     *
     * @param miniBoardHelper - the MiniBoardHelper object that contains the MiniBoard[] object that we want to copy to this board.
     *
     */
    public void copyBoard(MiniBoardHelper miniBoardHelper) {
        MiniBoard[] miniBoards = miniBoardHelper.getMiniBoards();

        for (int i = 0; i < Constants.BOARD_SIZE; i += Constants.MINI_BOARD_SIZE) {
            for (int j = 0, miniBoardIndex = 0; j < Constants.BOARD_SIZE; j += Constants.MINI_BOARD_SIZE) {
                for (int k = 0; k < Constants.MINI_BOARD_SIZE; k++) {
                    for (int l = 0; l < Constants.MINI_BOARD_SIZE; l++) {
                        this.setCell(i + k, j + l, miniBoards[miniBoardIndex].getCellValue(k, l));
                    }
                }
                miniBoardIndex++;
            }
        }
    }

}
