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
        this.setSize(800, 800);
        this.setResizable(false);
        this.setBackground(Color.GREEN);
        // this.setLocationRelativeTo(null);
        createBoard();
        this.pack();
        this.setVisible(true);
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

    /* rotation
    public static void rot_animation(int x) {
        int[] angle = {-90, 90, -90, 90, 90, -90, 90, -90};
        if (!end & rotateflag) {

            //sound of rotation
            Ac.play();

            //animation of rotation
            RotateTransition rotate;
            if (x == 0 | x == 1) {
                rotate = new RotateTransition(javafx.util.Duration.seconds(1.2), p1);
            } else if (x == 2 | x == 3) {
                rotate = new RotateTransition(javafx.util.Duration.seconds(1.2), p2);
            } else if (x == 4 | x == 5) {
                rotate = new RotateTransition(javafx.util.Duration.seconds(1.2), p3);
            } else if (x == 6 | x == 7) {
                rotate = new RotateTransition(javafx.util.Duration.seconds(1.2), p4);
            } else {
                return;
            }
            rotate.setByAngle(angle[x]);
            rotate.play();

            rot(x);
            cir(x);

            if (checkwin(1)) {
                //sound of winning
                Awin.play();
                end = true;
                return;
            } else if (checkwin(2)) {
                //sound of winning
                Alose.play();
                end = true;
                return;
            }

            rotation = true;
            rotateflag = false;
            //change background color to show turn
            if (BlackTurn) {
                root.setStyle("-fx-background-color: black");
            } else {
                root.setStyle("-fx-background-color: white");
            }

            text.setText("Processing...");
        }
    } */
}