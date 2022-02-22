package src;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI() {
        this.setTitle("2048");
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel gamePanel = new JPanel();
        

        JLabel l1 = new JLabel("2048");
        l1.setForeground(new Color(171,150,87));
        l1.setFont(new Font("Calibri", Font.BOLD, 40));
        l1.setBounds(10,10,150,60);
        l1.setOpaque(true);
        l1.setBackground(new Color(247,233,191));
        l1.setLayout(null);
        this.add(l1);

        ImageIcon image = new ImageIcon("/pictures/icon.jpeg");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(247,233,191));
        this.setLayout(null);
        this.setVisible(true);
    }
}
