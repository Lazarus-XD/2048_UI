package src;

import src.pictures.NumSquare;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
//        GUI frame = new GUI();

//        Frame frame = new JFrame();
//        JPanel panel = new JPanel();
//        panel.add(new NumSquare(16));
//        frame.add(panel);
//        frame.pack();
//        frame.setVisible(true);

        Game game = new Game();

        JFrame window = new JFrame("2048");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        game.start();
    }
}
