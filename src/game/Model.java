package game;

import com.mrjaffesclass.apcs.messenger.MessageHandler;
import com.mrjaffesclass.apcs.messenger.Messenger;

public class Model implements MessageHandler {
    private final Messenger mvcMessaging;

    private boolean gameOver;
    private Board board = new Board(new BoardCell[Constants.BOARD_SIZE][Constants.BOARD_SIZE]);
    private MiniBoardHelper miniBoardHelper = new MiniBoardHelper(new MiniBoard[Constants.MINI_BOARD_AMOUNT]);
    private Player player = new Player(Constants.WHITE);
    public Model(Messenger mvcMessaging) {
        this.mvcMessaging = mvcMessaging;
        this.init();

    }

    public void init() {
        this.newGame();
        this.mvcMessaging.subscribe("boardUpdate", this);
        this.mvcMessaging.subscribe("whoseMoveUpdate", this);
        this.mvcMessaging.subscribe("gameOverUpdate", this);
        this.mvcMessaging.subscribe("makeMove", this);
        this.mvcMessaging.subscribe("playerMove", this);
        System.out.println("model init");

    }

    private void newGame() {
        this.player.setColor(Constants.WHITE);
        this.gameOver = false;
        this.board = new Board(new BoardCell[Constants.BOARD_SIZE][Constants.BOARD_SIZE]);
        this.miniBoardHelper = new MiniBoardHelper(new MiniBoard[Constants.MINI_BOARD_AMOUNT]);
        this.board.copyBoard(this.miniBoardHelper);
    }


    @Override
    public void messageHandler(String messageString, Object messagePayload) {

        MessagePayload payload = (MessagePayload) messagePayload;
        String message = payload.getMessage();
        Position position = payload.getPosition();


        if (message != null) {
            System.out.println("MSG: received by model: " + message + " | " + messagePayload.toString());
        } else {
            System.out.println("MSG: received by model: " + message + " | No data sent");
        }
        switch (payload.getMessage()) {
//            case "gameOverUpdate" -> this.gameOver = this.board.isWinner() != null;
            case "makeMove" -> {
                miniBoardHelper.makeMove(player, position.getRow(), position.getCol()); // requires miniBoardHelper, player, and position
                board.copyBoard(miniBoardHelper); // requires miniBoardHelper
                // board.printBoard();
                this.mvcMessaging.notify("setIcon", MessagePayload.createMessagePayload("setIcon", position, player));
                player.switchPlayer();
            }
            case "playerMove" -> {
                if (!this.gameOver) {
                    // this copy is for redundancy
                    this.mvcMessaging.notify("boardUpdate", MessagePayload.createMessagePayload("boardUpdate", miniBoardHelper));

                    // make the move and copy the boards to the current board
                    this.mvcMessaging.notify("makeMove", MessagePayload.createMessagePayload("makeMove", position, player, miniBoardHelper));
                    this.mvcMessaging.notify("boardUpdate", MessagePayload.createMessagePayload("boardUpdate", miniBoardHelper));

                    // change the player
                    this.mvcMessaging.notify("whoseMoveUpdate", MessagePayload.createMessagePayload("whoseMoveUpdate"));
                    // check if the game is over
                    this.mvcMessaging.notify("gameOverUpdate", MessagePayload.createMessagePayload("gameOverUpdate"));
                }
            }
            case "rotate" -> {
                
            }
        }
    }

}
