package game;

public class MiniBoardHelper {
    private MiniBoard[] miniBoards;

    public MiniBoardHelper(MiniBoard[] miniBoardHelper){
        this.miniBoards = miniBoardHelper;
    }

    public MiniBoard[] getMiniBoards(){
        return miniBoards;
    }

    public void rotateClockwise(int miniBoardIndex) {
        this.miniBoards[miniBoardIndex].rotateClockwise();
    }
    public void rotateCounterClockwise(int miniBoardIndex) {
        this.miniBoards[miniBoardIndex].rotateCounterClockwise();
    }
    // populates the boardHelper array with miniBoards :)
    public void boardHelperInit() {
        for (int i = 0; i < Constants.MINI_BOARD_AMOUNT; i++) {
            this.miniBoards[i] = new MiniBoard(new BoardCell[Constants.MINI_BOARD_SIZE][Constants.MINI_BOARD_SIZE]);
        }
    }

}
