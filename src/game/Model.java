package game;

import com.mrjaffesclass.apcs.messenger.MessageHandler;
import com.mrjaffesclass.apcs.messenger.Messenger;

public class Model implements MessageHandler {
    private final Messenger mvcMessaging;

    private boolean whoseMove;
    private boolean gameOver;
    private Board board = new Board(new BoardCell[Constants.BOARD_SIZE][Constants.BOARD_SIZE]);

    public Model(Messenger mvcMessaging) {
        this.mvcMessaging = mvcMessaging;
        this.init();
    }

    public void init() {
        this.newGame();
        this.mvcMessaging.subscribe("playerMove", this);
        this.mvcMessaging.subscribe("newGame", this);
        this.mvcMessaging.subscribe("whoseMove", this);
    }

    private void newGame() {
        this.whoseMove = false; // Black
        this.gameOver = false;
        this.board = new Board(new BoardCell[Constants.BOARD_SIZE][Constants.BOARD_SIZE]);
    }



    @Override
    public void messageHandler(String messageString, Object messageObject) {
        if (messageObject != null) {
            System.out.println("MSG: received by model: " + messageString + " | " + messageObject.toString());
        } else {
            System.out.println("MSG: received by model: " + messageString + " | No data sent");
        }

        switch (messageString) {
            case "playerMove" -> {
                Position position = (Position) messageObject;
                assert position != null;
                int x = position.getX();
                int y = position.getY();
                // if the move is valid
                if (this.board.isValid(x, y)) {
                    // make the move
                    this.whoseMove = this.board.makeMove(x, y, this.whoseMove);

                    // check if the game is over
                    this.gameOver = this.board.isWinner(this.whoseMove);
                    mvcMessaging.notify("whoseMove", this.whoseMove);


                }
            }
        }
    }

}
