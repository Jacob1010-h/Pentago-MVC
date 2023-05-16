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
        JPanel pentagoBoard = new JPanel();
        pentagoBoard.setLayout(new GridLayout(8,8));
        pentagoBoard.setPreferredSize(new Dimension(800,800));

        cells = new BoardCell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new BoardCell();
                // check if the cell is on the outer edge of the board
                if (i == 0 || i == 7 || j == 0 || j == 7) {
                    cells[i][j].setBackground(Color.decode("#dad9b5"));
                }
                else {
                    cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    if ((i + j) % 2 == 0) {
                        cells[i][j].setBackground(Color.decode("#6b4526"));
                    } else {
                        cells[i][j].setBackground(Color.decode("#e49e77"));
                    }
                }
                cells[i][j].setPreferredSize(new Dimension(100,100));
                cells[i][j].setOpaque(true);
                cells[i][j].setVisible(true);
                pentagoBoard.add(cells[i][j]);


            }
        }
        // pentagoBoard.setOpaque(true);
        pentagoBoard.setVisible(true);
        this.add(pentagoBoard);
        // draw a line through the center of the board, horizontal and vertical
        // this.add(new JSeparator(SwingConstants.HORIZONTAL), BorderLayout.CENTER);
        // this.add(new JSeparator(SwingConstants.VERTICAL), BorderLayout.CENTER);
        this.setVisible(true);
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