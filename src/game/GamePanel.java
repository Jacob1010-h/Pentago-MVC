package game;

import com.mrjaffesclass.apcs.messenger.*;

import javax.swing.*;

public class GamePanel extends JFrame implements MessageHandler {

    private final Messenger mvcMessaging;
    public GamePanel(Messenger mvcMessaging) {
        this.mvcMessaging = mvcMessaging;
        this.init();
    }

    public void init() {
        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void messageHandler(String s, Object o) {

    }
}