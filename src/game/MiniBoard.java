package game;

public class MiniBoard {
	private BoardCell[][] miniBoard = new BoardCell[Constants.MINI_BOARD_SIZE][Constants.MINI_BOARD_SIZE];
	private Rotation direction = new Rotation();

	public MiniBoard(Rotation direction){

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
}
