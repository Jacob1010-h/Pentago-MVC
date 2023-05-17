package game;

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
        this.miniBoards[miniBoardIndex - 1].rotateClockwise();
    }

    /**
     * The rotateCounterClockwise function rotates the miniBoard at the given index counterclockwise.
     *
     * @param miniBoardIndex Specify which miniboard to rotate
     */
    public void rotateCounterClockwise(int miniBoardIndex) {
        this.miniBoards[miniBoardIndex - 1].rotateCounterClockwise();
    }


    /**
     * The boardHelperInit function initializes the miniBoards array with new MiniBoard objects.
     */
    public void boardHelperInit() {
        for (int i = 0; i < Constants.MINI_BOARD_AMOUNT; i++) {
            this.miniBoards[i] = new MiniBoard(new BoardCell[Constants.MINI_BOARD_SIZE][Constants.MINI_BOARD_SIZE]);
        }
    }
    public void makeMove(Player player, int row, int col) {
        int miniBoardIndex = getMiniBoardIndex(row, col);
        System.out.println(miniBoardIndex);
        if (miniBoardIndex == 1 || miniBoardIndex == 3) {
            col -= 3;
        }
        if (miniBoardIndex == 2 || miniBoardIndex == 3) {
            row -= 3;
        }
        this.miniBoards[miniBoardIndex].makeMove(row, col, player);
    }

    public int getMiniBoardIndex(int row, int col) {
        return ((row/3) * 2 + (col / 3));
    }


}
