/**
 * @file: Tile.java
 * @Author: Rizwan Ahsan, ahsanm7
 * @Date: February 23, 2022
 * @Description: Tile module handles the tiles generated on the GUI
 */

package src;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static final int WIDTH = 80;
    public static final int HEIGHT = 80;
    public static final int SLIDE_SPEED = 20;
    public static final int ARC_WIDTH = 25;
    public static final int ARC_HEIGHT = 25;

    private int value;
    private final BufferedImage tileImage;
    private int x, y;


    /**
     * @brief constructor
     * @details generates the individual tiles on the board
     * @param value integer to represent the value of the tile
     * @param x integer to represent the x-axis of the tile
     * @param y integer to represent the y-axis of the tile
     */
    public Tile(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
        tileImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        drawImage();
    }

    /**
     * @brief draws the tiles on the game board
     */
    private void drawImage() {
        Graphics2D g = (Graphics2D) tileImage.getGraphics();
        Color background;
        Color text;
        switch (value) {
            case 2 -> {
                background = new Color(236, 226, 197);
                text = new Color(0x000000);
            }
            case 4 -> {
                background = new Color(255, 198, 88);
                text = new Color(0x000000);
            }
            case 8 -> {
                background = new Color(0xf79d3d);
                text = new Color(0xffffff);
            }
            case 16 -> {
                background = new Color(0xf28007);
                text = new Color(0xffffff);
            }
            case 32 -> {
                background = new Color(0xf55e3b);
                text = new Color(0xffffff);
            }
            case 64 -> {
                background = new Color(0xff1212);
                text = new Color(0xffffff);
            }
            case 128 -> {
                background = new Color(0xe9de84);
                text = new Color(0xffffff);
            }
            case 256 -> {
                background = new Color(0xf6e873);
                text = new Color(0xffffff);
            }
            case 512 -> {
                background = new Color(0xf5e455);
                text = new Color(0xffffff);
            }
            case 1024 -> {
                background = new Color(0xf7e12c);
                text = new Color(0xffffff);
            }
            case 2048 -> {
                background = new Color(0xffe400);
                text = new Color(0xffffff);
            }
            default -> {
                background = Color.BLACK;
                text = Color.WHITE;
            }
        }

        g.setColor(new Color(0,0,0,0));
        g.fillRect(0,0, WIDTH, HEIGHT);

        g.setColor(background);
        g.fillRoundRect(0,0,WIDTH,HEIGHT,ARC_WIDTH,ARC_HEIGHT);

        g.setColor(text);

        Font font;
        if(value <= 64) {
            font = GameController.main.deriveFont(36f);
        } else {
          font = GameController.main;
        }
        g.setFont(font);

        int drawX = WIDTH / 2 - DrawUtils.getMessageWidth("" + value, font, g) / 2;
        int drawY = HEIGHT / 2 + DrawUtils.getMessageHeight("" + value, font, g) / 2;

        g.drawString("" + value, drawX, drawY);
        g.dispose();
    }

    /**
     * @brief updates the screen when one or more tiles are moved
     */
    public void update() {

    }

    /**
     * @brief renders the tiles on the screen
     * @param g Graphics2D object
     */
    public void render(Graphics2D g) {
        g.drawImage(tileImage,x,y,null);
    }

    /**
     * @brief Getter to get the value of the tile
     * @return return the value of the tile
     */
    public int getValue() {
        return value;
    }

    /**
     * @brief Setter to set the value of the tile
     * @param value integer value for the updated tile number
     */
    public void setValue(int value) {
        this.value = value;
        drawImage();
    }

    /**
     * @brief Getter to get the x-axis value of the tile
     * @return return the value of the x-axis
     */
    public int getX() {
        return x;
    }

    /**
     * @brief Getter to get the y-axis value of the tile
     * @return return the value of the y-axis
     */
    public int getY() {
        return y;
    }

    /**
     * @brief Setter to set the x-axis value of the tile
     * @param x int value of x-axis
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @brief Setter to set the y-axis value of the tile
     * @param y int value of y-axis
     */
    public void setY(int y) {
        this.y = y;
    }
}
