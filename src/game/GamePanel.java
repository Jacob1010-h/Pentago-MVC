package game;

import com.mrjaffesclass.apcs.messenger.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JFrame implements MessageHandler, MouseListener {

    BoardCell[][] cells;

    private boolean isRotate = false;
    private final Messenger mvcMessaging;

    public GamePanel(Messenger mvcMessaging) {
        this.mvcMessaging = mvcMessaging;
        this.init();
    }

    public void init() {
        this.mvcMessaging.subscribe("setIcon", this);
        this.mvcMessaging.subscribe("gameOver", this);
        this.setTitle("Pentagohno");
        this.mvcMessaging.subscribe("invalidMove", this);
        this.setTitle("Pentagowo");
        // set this icon image to the pentago logo
        this.setIconImage(new ImageIcon("src\\game\\images\\icon2.png").getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setResizable(false);
        this.setBackground(Color.GREEN);
        // this.setLocationRelativeTo(null);
        createBoard();
        this.pack();
        this.setVisible(true);
        this.addMouseListener(this);
    }

    @Override
    public void messageHandler(String messageString, Object messagePayload) {
        MessagePayload payload = (MessagePayload) messagePayload;
        String message = payload.getMessage();
        Position position = payload.getPosition();
        Player player = payload.getPlayer();
        Board board = payload.getBoard();

        if (message != null) {
            System.out.println("MSG: received by model: " + message + " | " + messagePayload.toString());
        } else {
            System.out.println("MSG: received by model: " + message + " | No data sent");
        }
        switch (payload.getMessage()) {
//            case "gameOverUpdate" -> this.gameOver = this.board.isWinner() != null;
            case "setIcon" -> {
                updateBoard(board, player.getColor() == Constants.WHITE ? Color.WHITE : Color.BLACK);
            }
            case "gameOver" -> {
                gameOver(payload.getWinner());
                updateBoard(payload.getBoard(), player.getColor() == Constants.WHITE ? Color.WHITE : Color.BLACK);
                isRotate = false;
                handleIcons();
            }
            case "invalidMove" -> {
                this.isRotate = false;
                handleIcons();
            }
        }

    }

    public void createBoard() {
        int size = 10;  // size of the board, including the outer edge
        JPanel pentagoBoard = new JPanel();
        pentagoBoard.setLayout(new GridLayout(size,size));
            pentagoBoard.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));

        cells = new BoardCell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new BoardCell();
                // check if the cell is on the outside of the board
                if (i < 2 || i > 7 || j < 2 || j > 7) {
                    cells[i][j].setIcon(new ImageIcon("src/game/images/felt.png"));
                }
                else {
                    handleBorders(i, j, Color.WHITE);
                    if ((i > 4 && j < 5) || (i < 5 && j > 4)) {
                        cells[i][j].setIcon(new ImageIcon("src/game/images/blankSquare.png"));
                    } else {
                        cells[i][j].setIcon(new ImageIcon("src/game/images/blankSquare.png"));
                    }
                }
                // cells[i][j].setText( i + ", " + j); cells[i][j].setIcon(null);
                cells[i][j].setPreferredSize(new Dimension(80, 80));
                cells[i][j].setOpaque(true);
                cells[i][j].setVisible(true);
                pentagoBoard.add(cells[i][j]);
            }
        }
        pentagoBoard.setVisible(true);
        this.add(pentagoBoard);
        this.setVisible(true);
    }

    public void updateBoard(Board board, Color color) {
        for (int i = 2; i < 8; i++) {
            for (int j = 2; j < 8; j++) {
                setCell(i, j, board.getBoard()[i - 2][j - 2].getValue());
                handleBorders(i, j, color);
            }
        }
    }
    
    private void handleBorders(int i, int j, Color color) {
        int top = 1;
        int left = 1;
        int bottom = 1;
        int right = 1;
        int increment = 3;
        // check if the cell is on the outer edge of the board
        if (i == 2 || i == 7 || j == 2 || j == 7) {
            // only add a border to the outer edge of the board,
            // using createMatteBorder to only add borders
            // to the walls that touch the outer edge of the board
            top = i == 2 ? increment : top;
            left = j == 2 ? increment : left;
            bottom = i == 7 ? increment : bottom;
            right = j == 7 ? increment : right;
        }
        // check if the cell crosses with the middle of the board
        if (i == 4 || i == 5 || j == 4 || j == 5) {
            // only add a border to the middle of the board,
            // using createMatteBorder to only add borders
            // to the walls that touch the middle of the board
            // top, left, bottom, right
            top = i == 5 ? increment : top;
            left = j == 5 ? increment : left;
            bottom = i == 4 ? increment : bottom;
            right = j == 4 ? increment : right;
        }
        cells[i][j].setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, color));
    }

    public void handleClick(int x, int y) {
        int row;
        int col;
        int cellSize = Constants.WINDOW_HEIGHT / 10;
        if (isRotate) {
//            System.out.println("rotate");
            row = (y - Constants.BLANK_TOP_SPACE) / cellSize;
            col = x / cellSize;
            System.out.println("row: " + row + " Col: " + col);
            if (validRotate(row, col)) {
                isRotate = false;
                handleIcons();
                mvcMessaging.notify("rotate", MessagePayload.createMessagePayload("rotate", getRotateSection(new Position(row, col)), getRotateClockwise(new Position(row, col))));
            }
            return;
        }
        if (outOfBounds(x, y) && !isRotate) {
            System.out.println("yo ass is out of bounds");
            return;
        }
        x -= Constants.X_LEFT;
        y -= (Constants.Y_TOP);
        row = y / cellSize;
        col = x / cellSize;
        System.out.println("row: " + row + "col: " + col);
        isRotate = true;
        handleIcons();
        mvcMessaging.notify("makeMove", MessagePayload.createMessagePayload("makeMove", new Position(row, col)));

    }

    public void gameOver(int winner) {
        Player player = new Player(winner);
        JOptionPane.showMessageDialog(null, player.toString() + " WINS!!!");
    }

    public boolean validRotate(int row, int col) {
        return ((row == 1 && col >= 2 && col <= 4) || (row >= 2 && row <= 4 && col == 1) ||
                (row == 1 && col >= 5 && col <= 7) || (row >= 2 && row <= 4 && col == 8) ||
                (row == 8 && col >= 5 && col <= 7) || (row >= 5 && row <= 7 && col == 1) ||
                (row == 8 && col >= 2 && col <= 4) || (row >= 5 && row <= 7 && col == 8));
    }

    private boolean getRotateClockwise(Position pos) {
        int row = pos.getRow();
        int col = pos.getCol();
        return (row == 1 && (col >= 2 && col <= 4) || 
                (row >= 2 && row <= 4) && col == 8 ||
                (row >= 5 && row <= 7) && col == 1 ||
                row == 8 && (col >= 5 && col <= 7));
    }

    private int getRotateSection(Position pos) {
        int row = pos.getRow();
        int col = pos.getCol();

        if (row == 1 && (col >= 2 && col <= 4) || (row >= 2 && row <= 4) && col == 1) {
            return 1;
        }
        if (row == 1 && (col >= 5 && col <= 7) || (row >= 2 && row <= 4) && col == 8) {
            return 2;
        }
        if (row == 8 && (col >= 2 && col <= 4) || (row >= 5 && row <= 7) && col == 1) {
            return 3;
        }
        if (row == 8 && (col >= 5 && col <= 7) || (row >= 5 && row <= 7) && col == 8) {
            return 4;
        }
        throw new IllegalArgumentException("Invalid cell coordinates: (" + row + ", " + col + ")");
    }

    private void handleIcons() {
        if (isRotate) {
            cells[1][3].setIcon(new ImageIcon("src/game/images/rightDown.png"));
            cells[3][1].setIcon(new ImageIcon("src/game/images/downRight.png"));
            cells[1][6].setIcon(new ImageIcon("src/game/images/leftDown.png"));
            cells[3][8].setIcon(new ImageIcon("src/game/images/downLeft.png"));
            cells[6][1].setIcon(new ImageIcon("src/game/images/upRight.png"));
            cells[8][3].setIcon(new ImageIcon("src/game/images/rightUp.png"));
            cells[8][6].setIcon(new ImageIcon("src/game/images/leftUp.png"));
            cells[6][8].setIcon(new ImageIcon("src/game/images/upLeft.png"));
        }
        else {
            cells[1][3].setIcon(new ImageIcon("src/game/images/felt.png"));
            cells[3][1].setIcon(new ImageIcon("src/game/images/felt.png"));
            cells[1][6].setIcon(new ImageIcon("src/game/images/felt.png"));
            cells[3][8].setIcon(new ImageIcon("src/game/images/felt.png"));
            cells[6][1].setIcon(new ImageIcon("src/game/images/felt.png"));
            cells[8][3].setIcon(new ImageIcon("src/game/images/felt.png"));
            cells[8][6].setIcon(new ImageIcon("src/game/images/felt.png"));
            cells[6][8].setIcon(new ImageIcon("src/game/images/felt.png"));
        }
    }


    private void setCell(int row, int col, int color) {
        switch (color) {
            case Constants.WHITE -> {
                cells[row][col].setIcon(new ImageIcon("src/game/images/whiteMarble.png"));
                cells[row][col].setValue(color);
            }
            case Constants.BLACK -> {
                cells[row][col].setIcon(new ImageIcon("src/game/images/blackMarble.png"));
                cells[row][col].setValue(color);
            }
            default -> {
                cells[row][col].setIcon(new ImageIcon("src/game/images/blankSquare.png"));
                cells[row][col].setValue(color);
            }
        }
    }

    public boolean outOfBounds(int x, int y) {
        return (x >= Constants.X_RIGHT || x <= Constants.X_LEFT || y <= Constants.Y_TOP || y >= Constants.Y_BOTTOM);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        System.out.println("x: " + x + " y: " + y);
        handleClick(x, y);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    
    }
}