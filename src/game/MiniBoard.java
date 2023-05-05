package game;

public class MiniBoard {
	private BoardCell[][] miniBoard = new BoardCell[Constants.MINI_BOARD_SIZE][Constants.MINI_BOARD_SIZE];
	private Rotation rotation = new Rotation();

	public MiniBoard(BoardCell[][] miniBoard, Rotation rotation){
		this.miniBoard = miniBoard;
		this.rotation = rotation;
	}


	public BoardCell[][] getMiniBoard(){
		return miniBoard;
	}

	public void populateMiniBoard(){
		for(int i = 0; i < Constants.MINI_BOARD_SIZE; i++){
			for(int j = 0; j < Constants.MINI_BOARD_SIZE; j++){
				this.miniBoard[i][j] = new BoardCell(Constants.EMPTY);
			}
		}
	}

	public BoardCell getCell(int row, int col) {
		return this.miniBoard[row][col];
	}
	public void rotateClockwise() {
		BoardCell[][] temp = new BoardCell[Constants.MINI_BOARD_SIZE][Constants.MINI_BOARD_SIZE];

		for (int i = 0; i < Constants.MINI_BOARD_SIZE; i++) {
			System.arraycopy(this.miniBoard[i], 0, temp[i], 0, Constants.MINI_BOARD_SIZE);
		}

		if (this.rotation.getRotation() == 270) {
			this.rotation.setRotation(0);
		}
		else {
			this.rotation.setRotation(this.rotation.getRotation() + 90);
		}

		for (int row = 0; row < Constants.MINI_BOARD_SIZE; row++) {
			for (int col = 0; col < Constants.MINI_BOARD_SIZE; col++) {
				this.miniBoard[row][col] = temp[Constants.MINI_BOARD_SIZE - col - 1][row];
			}
		}


	}

	public void rotateCounterClockwise() {
		BoardCell[][] temp = new BoardCell[Constants.MINI_BOARD_SIZE][Constants.MINI_BOARD_SIZE];
		if (this.rotation.getRotation() == 0) {
			this.rotation.setRotation(270);
		}
		else {
			this.rotation.setRotation(this.rotation.getRotation() - 90);
		}

	}


}
