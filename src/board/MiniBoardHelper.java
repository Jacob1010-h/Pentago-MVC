package board;

import game.Constants;

public class MiniBoardHelper {
    private MiniBoard[] miniBoards;

    public MiniBoardHelper(MiniBoard[] miniBoardHelper){
        this.miniBoards = miniBoardHelper;
        boardHelperInit();
    }

    public MiniBoard[] getMiniBoards(){
        return miniBoards;
    }

    /**
     * The rotateClockwise function rotates the miniBoard at the given index clockwise.
     *
     * @param miniBoardIndex Determine which miniboard to rotate
     */
    public void rotateClockwise(int miniBoardIndex) {
        this.miniBoards[miniBoardIndex].rotateClockwise();
    }

    /**
     * The rotateCounterClockwise function rotates the miniBoard at the given index counterclockwise.
     *
     * @param miniBoardIndex Specify which miniboard to rotate
     */
    public void rotateCounterClockwise(int miniBoardIndex) {
        this.miniBoards[miniBoardIndex].rotateCounterClockwise();
    }


    /**
     * The boardHelperInit function initializes the miniBoards array with new MiniBoard objects.
     */
    public void boardHelperInit() {
        for (int i = 0; i < Constants.MINI_BOARD_AMOUNT; i++) {
            this.miniBoards[i] = new MiniBoard(new BoardCell[Constants.MINI_BOARD_SIZE][Constants.MINI_BOARD_SIZE]);
        }
    }

}
