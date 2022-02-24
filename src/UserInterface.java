/**
 * @file: UserInterface.java
 * @Author: Rizwan Ahsan, ahsanm7
 * @Date: April 16, 2021
 * @Description: module to handle all the interface elements
 */

package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;

public class UserInterface {

    //change rows and cols to increase game size
    public static final int ROWS = 4;
    public static final int COLS = 4;

    private BoardT boardT;

    private final int startingTiles = 2;
    private Tile[][] board;
    private BufferedImage gameBoard;
    private BufferedImage finalBoard;
    private int x, y;

    //score variables
    private int highScore = 0;
    private Font scoreFont;

    //Saving files
    private String saveDataPath;
    private String fileName = "SaveFile";

    private static int SPACING = 10;
    public static int BOARD_WIDTH = (COLS + 1) * SPACING + COLS * Tile.WIDTH;
    public static int BOARD_HEIGHT = (ROWS + 1) * SPACING + ROWS * Tile.HEIGHT;

    public UserInterface(int x, int y) {
        try {
            saveDataPath = UserInterface.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        scoreFont = GameController.main.deriveFont(24f);
        this.x = x;
        this.y = y;
        boardT = new BoardT(ROWS);
        board = boardT.getBoard();
        gameBoard = new BufferedImage(BOARD_WIDTH, BOARD_HEIGHT, BufferedImage.TYPE_INT_RGB);
        finalBoard = new BufferedImage(BOARD_WIDTH, BOARD_HEIGHT, BufferedImage.TYPE_INT_RGB);

        loadHighScore();
        createBoardImage();
        start();
    }

    private void createSaveData() {
        try {
            File file = new File(saveDataPath, fileName);
            FileWriter output = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write("" + 0);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadHighScore() {
        try {
            File file = new File(saveDataPath, fileName);
            if(!file.isFile()) {
                createSaveData();
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            highScore = Integer.parseInt(reader.readLine());
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setHighScore() {
        FileWriter output = null;

        try {
            File file = new File(saveDataPath, fileName);
            output = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(output);

            writer.write("" + highScore);
            writer.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void createBoardImage() {
        Graphics2D g = (Graphics2D) gameBoard.getGraphics();
        g.setColor(Color.darkGray);
        g.fillRect(0,0,BOARD_WIDTH,BOARD_HEIGHT);
        g.setColor(Color.lightGray);

        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                int x = SPACING + SPACING * col + Tile.WIDTH * col;
                int y = SPACING + SPACING * row + Tile.HEIGHT * row;
                g.fillRoundRect(x,y,Tile.WIDTH,Tile.HEIGHT,Tile.ARC_WIDTH,Tile.ARC_HEIGHT);
            }
        }
    }

    private void start() {
        for(int i = 0; i < startingTiles; i++) {
            boardT.addNewNumber();
        }
    }

    public int getTileX(int col) {
        return SPACING + col * Tile.WIDTH + col * SPACING;
    }

    public int getTileY(int row) {
        return SPACING + row * Tile.HEIGHT + row * SPACING;
    }

    public void render(Graphics2D g) {
        Graphics2D g2d = (Graphics2D) finalBoard.getGraphics();
        g2d.drawImage(gameBoard,0,0,null);

        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                Tile current = board[row][col];
                if(current == null) continue;
                current.render(g2d);
            }
        }

        g.drawImage(finalBoard,x,y,null);
        g2d.dispose();

        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.BOLD, 65));
        g.drawString("2048", 20, 75);

        g.setColor(Color.WHITE);
        g.setFont(scoreFont);
        g.drawString("Current: " + boardT.getScore(), GameController.WIDTH - DrawUtils.getMessageWidth("Best:" + highScore, scoreFont, g) - 65, 40);
        g.setColor(Color.WHITE);
        g.drawString("Best: " + highScore, GameController.WIDTH - DrawUtils.getMessageWidth("Best:" + highScore, scoreFont, g) - 60, 80);
    }

    public void update() {
        checkKeys();

        if(boardT.getScore() >= highScore) {
            highScore = boardT.getScore();
        }

        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                Tile current = board[row][col];
                if(current == null) continue;
                current.update();
                resetPosition(current, row, col);
            }
        }
    }

    private void resetPosition(Tile current, int row, int col) {
        if(current == null) return;

        int x = getTileX(col);
        int y = getTileY(row);

        int distX = current.getX() - x;
        int distY = current.getY() - y;

        if(Math.abs(distX) < Tile.SLIDE_SPEED) {
            current.setX(current.getX() - distX);
        }

        if(Math.abs(distY) < Tile.SLIDE_SPEED) {
            current.setY(current.getY() - distY);
        }

        if(distX < 0) {
            current.setX(current.getX() + Tile.SLIDE_SPEED);
        }

        if(distY < 0) {
            current.setY(current.getY() + Tile.SLIDE_SPEED);
        }

        if(distX > 0) {
            current.setX(current.getX() - Tile.SLIDE_SPEED);
        }

        if(distY > 0) {
            current.setY(current.getY() - Tile.SLIDE_SPEED);
        }
    }

    private void turnCheck() {
        if(!boardT.getIsOver() && boardT.getIsChanged()) boardT.addNewNumber();
        boardT.resetChanged();
        boardT.updateStatus();
        if(boardT.getIsOver()) {
            setHighScore();
        }
    }

    private void checkKeys() {
        if(KeyBoard.typed(KeyEvent.VK_LEFT)) {
            Movements.moveLeft(boardT);
            turnCheck();
        }
        if(KeyBoard.typed(KeyEvent.VK_RIGHT)) {
            Movements.moveRight(boardT);
            turnCheck();
        }
        if(KeyBoard.typed(KeyEvent.VK_UP)) {
            Movements.moveUp(boardT);
            turnCheck();
        }
        if(KeyBoard.typed(KeyEvent.VK_DOWN)) {
            Movements.moveDown(boardT);
            turnCheck();
        }
    }

}
