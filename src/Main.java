package src;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        JFrame window = new JFrame("2048");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        game.start();

//        BoardT b = new BoardT(4);
//        Tile[][] t = b.getBoard();
//        System.out.println(Arrays.deepToString(t));

//        BoardT b = new BoardT(4);
//        UserInterface ui = UserInterface.getInstance();
//        GameController g = GameController.getInstance(b, ui);
//        g.playGame();
    }
}
