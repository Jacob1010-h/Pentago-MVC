package game;

public class MiniBoard {
	private BoardCell[][] miniBoard;

	public MiniBoard(BoardCell[][] miniBoard){
		this.miniBoard = miniBoard;
//		initMiniBoard();
		initMiniBoardRand();
	}


	public BoardCell[][] getMiniBoard(){
		return miniBoard;
	}

	public void initMiniBoard(){
		for(int i = 0; i < Constants.MINI_BOARD_SIZE; i++){
			for(int j = 0; j < Constants.MINI_BOARD_SIZE; j++){
				this.miniBoard[i][j] = new BoardCell(Constants.EMPTY);
			}
		}
	}

	public void initMiniBoardRand(){
		for(int i = 0; i < Constants.MINI_BOARD_SIZE; i++){
			for(int j = 0; j < Constants.MINI_BOARD_SIZE; j++){
				this.miniBoard[i][j] = new BoardCell((int) (Math.random() * 3 - 1));
			}
		}
	}

	public BoardCell getCell(int row, int col) {
		return this.miniBoard[row][col];
	}

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


}
