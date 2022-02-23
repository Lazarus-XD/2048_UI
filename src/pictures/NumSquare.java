package src.pictures;

import javax.swing.*;
import java.awt.*;

public class NumSquare extends JComponent {
    int scale = 100;
    int border = scale / 20;
    int font_size = (int) (scale * 0.4);
    Font font = new Font("Consolas", Font.PLAIN, font_size);
    private int value;

    public NumSquare(int value) {
        this.value = value;
        this.setFont(font);
        this.setPreferredSize(new Dimension(scale, scale));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D c2D = (Graphics2D) g;
        c2D.fillRect(0, 0, getSize().width, getSize().height);


        Color color;
        if (value == 0) {
            color = Color.CYAN;
        }
        else {
            int len = Integer.numberOfTrailingZeros(value);
            color = Color.getHSBColor(len / 11.0f, 0.8f, 0.5f);
        }
        g.setColor(color);
    }
}
