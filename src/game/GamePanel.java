package game;

import com.mrjaffesclass.apcs.messenger.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JFrame implements MessageHandler, MouseListener {

    BoardCell[][] cells;

    private final Messenger mvcMessaging;
    public GamePanel(Messenger mvcMessaging) {
        this.mvcMessaging = mvcMessaging;
        this.init();
    }

    public void init() {
        this.setTitle("Pentagowo");
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
    public void messageHandler(String s, Object o) {

    }

    public void createBoard() {
        int size = 10;  // size of the board, including the outer edge
        JPanel pentagoBoard = new JPanel();
        pentagoBoard.setLayout(new GridLayout(size,size));
        pentagoBoard.setPreferredSize(new Dimension(800,800));

        cells = new BoardCell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new BoardCell();
                // check if the cell is on the outside of the board
                if (i < 2 || i > 7 || j < 2 || j > 7) {
                    cells[i][j].setBackground(Color.decode("#dad9b5"));
                }
                else {
                    handleBorders(i, j);
                    if ((i > 4 && j < 5) || (i < 5 && j > 4)) {
                        cells[i][j].setBackground(Color.decode("#6b4526"));
                    } else {
                        cells[i][j].setBackground(Color.decode("#e49e77"));
                    }
                }
                cells[i][j].setText(i + ", " + j);
                cells[i][j].setPreferredSize(new Dimension(100,100));
                cells[i][j].setOpaque(true);
                cells[i][j].setVisible(true);
                pentagoBoard.add(cells[i][j]);
            }
        }
        // cells[1][3].setIcon(new ImageIcon("src/game/images/downLeft.png"));
        // cells[8][3].setIcon(new ImageIcon("src/game/images/leftUp.png"));
        // cells[8][6].setIcon(new ImageIcon("src/game/images/rightUp.png"));
        // cells[3][8].setIcon(new ImageIcon("src/game/images/upLeft.png"));
        // cells[3][1].setIcon(new ImageIcon("src/game/images/upRight.png"));
        // cells[6][1].setIcon(new ImageIcon("src/game/images/rightDown.png"));
        // cells[1][6].setIcon(new ImageIcon("src/game/images/downRight.png"));
        // pentagoBoard.setOpaque(true);
        pentagoBoard.setVisible(true);
        this.add(pentagoBoard);
        // draw a line through the center of the board, horizontal and vertical
        // this.add(new JSeparator(SwingConstants.HORIZONTAL), BorderLayout.CENTER);
        // this.add(new JSeparator(SwingConstants.VERTICAL), BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void handleBorders(int i, int j) {
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
        cells[i][j].setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.WHITE));
    }

    public void handleClick(int x, int y) {
        if (outOfBounds(x, y)) {
            System.out.println("yo ass is out of bounds");
            return;
        }

    }

    public boolean outOfBounds(int x, int y) {
        return x >= Constants.X_RIGHT || x <= Constants.X_LEFT || y <= Constants.Y_TOP || y >= Constants.Y_BOTTOM;
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