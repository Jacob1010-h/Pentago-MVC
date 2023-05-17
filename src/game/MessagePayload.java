package game;

/**
 * This is the message payload class.  Instantiate this class when sending
 * field / value message data for the up/down buttons
 *
 * @author Roger Jaffe
 * @version 1.0
 */
public class MessagePayload {

    private final String message;
    private final Position position;
    private final Player player;
    private final MiniBoardHelper miniBoardHelper;
    private final Board board;

    private final int rotateSection;
    private final boolean rotateClockwise;

    /**
     * Class constructor
     * @param message The message to send
     * @param position The position to send
     * @param player The player to send
     */
    public MessagePayload(String message, Position position, Player player, MiniBoardHelper miniBoardHelper) {
        this.message = message;
        this.board = null;
        this.position = position;
        this.player = player;
        this.miniBoardHelper = miniBoardHelper;
        this.rotateSection = -1;
        this.rotateClockwise = false;
    }

    public MessagePayload(String message, Position position, Player player) {
        this.message = message;
        this.board = null;
        this.position = position;
        this.player = player;
        this.miniBoardHelper = null;
        this.rotateSection = -1;
        this.rotateClockwise = false;
    }

    public MessagePayload(String message, MiniBoardHelper miniBoardHelper) {
        this.message = message;
        this.board = null;
        this.position = null;
        this.player = null;
        this.miniBoardHelper = miniBoardHelper;
        this.rotateSection = -1;
        this.rotateClockwise = false;
    }
    public MessagePayload(String message) {
        this.message = message;
        this.board = null;
        this.position = null;
        this.player = null;
        this.miniBoardHelper = null;
        this.rotateSection = -1;
        this.rotateClockwise = false;
    }
    public MessagePayload(String message, Board board) {
        this.message = message;
        this.board = board;
        this.position = null;
        this.player = null;
        this.miniBoardHelper = null;
        this.rotateSection = -1;
        this.rotateClockwise = false;
    }

    public MessagePayload(String message, Player player) {
        this.message = message;
        this.board = null;
        this.position = null;
        this.player = player;
        this.miniBoardHelper = null;
        this.rotateSection = -1;
        this.rotateClockwise = false;
    }

    public MessagePayload(String message, Position position) {
        this.message = message;
        this.board = null;
        this.position = position;
        this.player = null;
        this.miniBoardHelper = null;
        this.rotateSection = -1;
        this.rotateClockwise = false;
    }

    public MessagePayload(String message, int rotateSection, boolean rotateClockwise) {
        this.message = message;
        this.board = null;
        this.position = null;
        this.player = null;
        this.miniBoardHelper = null;
        this.rotateSection = rotateSection;
        this.rotateClockwise = rotateClockwise;
    }

    /**
     * The function creates a new MessagePayload object with a given printOut string and null metadata.
     *
     * @param printOut The parameter "printOut" is a string that represents the message content that will
     * be included in the MessagePayload object being created.
     * @return A new instance of the class `MessagePayload` with the `printOut` parameter passed as an
     * argument and `null` as the second argument.
     */
    public static MessagePayload createMessagePayload(String printOut) {
        return new MessagePayload(printOut);
    }

    public static MessagePayload createMessagePayload(String printOut, MiniBoardHelper miniBoardHelper) {
        return new MessagePayload(printOut, miniBoardHelper);
    }

    public static MessagePayload createMessagePayload(String printOut, Board board){
        return new MessagePayload(printOut, board);
    }

    /**
     * This function creates a new MessagePayload object with the given printOut and position parameters.
     *
     * @param printOut printOut is a string parameter that represents the message or text that needs to
     * be sent as a payload.
     * @param position The "position" parameter is an object of the "Position" class, which represents a
     * position in a two-dimensional space. It may contain information such as the x and y coordinates of
     * the position. This parameter is used to specify the location where the message payload should be
     * displayed or attached to.
     * @return A new instance of the class `MessagePayload` with the specified `printOut` and `position`
     * values.
     */
    public static MessagePayload createMessagePayload(String printOut, Position position, Player player, MiniBoardHelper miniBoardHelper) {
        return new MessagePayload(printOut, position, player, miniBoardHelper);
    }

    public static MessagePayload createMessagePayload(String printOut, Position position, Player player) {
        return new MessagePayload(printOut, position, player);
    }

    public static MessagePayload createMessagePayload(String printOut, int section, boolean clockwise) {
        return new MessagePayload(printOut, section, clockwise);
    }

    public static MessagePayload createMessagePayload(String printOut, Player player) {
        return new MessagePayload(printOut, player);
    }
    public static MessagePayload createMessagePayload(String printOut, Position position) {
        return new MessagePayload(printOut, position);
    }

    /**
     * The function returns the message stored in the object.
     *
     * @return The `getMessage()` method is returning the value of the `message` instance variable of the
     * current object.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * This function returns the position of an object.
     *
     * @return The method `getPosition()` is returning the `position` object.
     */
    public Position getPosition() {
        return this.position;
    }

    public Player getPlayer() {
        return this.player;
    }

    public MiniBoardHelper getMiniBoardHelper() {
        return this.miniBoardHelper;
    }

    public int getRotateSection() {
        return this.rotateSection;
    }

    public boolean getRotateClockwise() {
        return this.rotateClockwise;
    }
}