package game;

import com.mrjaffesclass.apcs.messenger.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JFrame implements MessageHandler {

    BoardCell[][] cells;

    private final Messenger mvcMessaging;
    public GamePanel(Messenger mvcMessaging) {
        this.mvcMessaging = mvcMessaging;
        this.init();
    }

    public void init() {
        this.setTitle("Pentagowo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setBackground(Color.GREEN);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        createBoard();
    }

    @Override
    public void messageHandler(String s, Object o) {

    }

    public void createBoard() {
        JPanel pentagoBoard = new JPanel();
        pentagoBoard.setLayout(new GridBagLayout());
        pentagoBoard.setPreferredSize(new Dimension(500,500));
        pentagoBoard.setBackground(Color.GRAY);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        cells = new BoardCell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new BoardCell();
                if ((i + j) % 2 == 0) {
                    cells[i][j].setBackground(Color.LIGHT_GRAY);
                } else {
                    cells[i][j].setBackground(Color.DARK_GRAY);
                }
                cells[i][j].setOpaque(true);
                c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 0.5;
                c.gridx = i;
                c.gridy = j;

                pentagoBoard.add(cells[i][j], c);
            }
        }
        this.add(pentagoBoard);
        this.pack();
        this.setVisible(true);
    }
}