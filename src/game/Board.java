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

    public BoardCell getCell(int row, int col) {
        return this.board[row][col];
    }

    public void setCell(int row, int col, int value) {
        this.board[row][col].setValue(value);
    }

    public void populateBoard(MiniBoardHelper miniBoardHelper) {
        MiniBoard[] miniBoards = miniBoardHelper.getMiniBoards();

        // combine all miniBoards into one big board (board)
        int miniBoardIndex = 0;
        for (int i = 0; i < Constants.BOARD_SIZE; i += Constants.MINI_BOARD_SIZE) {
            for (int j = 0; j < Constants.BOARD_SIZE; j += Constants.MINI_BOARD_SIZE) {
                for (int k = 0; k < Constants.MINI_BOARD_SIZE; k++) {
                    for (int l = 0; l < Constants.MINI_BOARD_SIZE; l++) {
                        this.board[i + k][j + l].setValue(miniBoards[miniBoardIndex].getCell(k, l).getValue());
                    }
                }
                miniBoardIndex++;
            }
        }
    }

}
