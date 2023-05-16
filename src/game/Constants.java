package game;

public class Constants {
	// Board Constants
	public static final int BOARD_SIZE = 6;
	public static final int MINI_BOARD_SIZE = 3;
	public static final int MAX_MOVE_COUNT = 45;

	public static final int MINI_BOARD_AMOUNT = 4;

	public static final int WINDOW_HEIGHT = 800;
	public static final int WINDOW_WIDTH = 800;

	// Player Colors
	public static final int EMPTY = 0;
	public static final int BLACK = -1;
	public static final int WHITE = 1;

	// out of obunds thing ong

	// 100, 701, 737, 136 for 800 size
	public static final int X_LEFT = WINDOW_HEIGHT / 8;
	public static final int X_RIGHT = WINDOW_HEIGHT / MINI_BOARD_AMOUNT;
	public static final int Y_BOTTOM = WINDOW_WIDTH;
	public static final int Y_TOP= 136;
}
