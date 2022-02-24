package src;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        GameController gameController = new GameController();

        JFrame window = new JFrame("2048");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(gameController);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gameController.start();
    }
}
