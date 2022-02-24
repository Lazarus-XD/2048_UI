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

    private final BoardT boardT;

    private final Tile[][] board;
    private final BufferedImage gameBoard;
    private final BufferedImage finalBoard;
    private final int x;
    private final int y;

    //score variables
    private int highScore = 0;
    private final Font scoreFont;

    //Saving files
    private String saveDataPath;
    private final String fileName = "SaveFile";

    private static final int SPACING = 10;
    public static int BOARD_WIDTH = (COLS + 1) * SPACING + COLS * Tile.WIDTH;
    public static int BOARD_HEIGHT = (ROWS + 1) * SPACING + ROWS * Tile.HEIGHT;


    /**
     * @brief constructor
     * @details generates a board with given size and adds two number on board
     * @param x integer to represent the x-axis value of the board
     * @param y integer to represent the y-axis value of board
     */
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

    /**
     * @brief Creates the save data for the high score value
     */
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

    /**
     * @brief loads the high score value on the GUI
     */
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

    /**
     * @brief sets the new high score value on the save data file
     */
    private void setHighScore() {
        FileWriter output;

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

    /**
     * @brief generates the playing board image
     */
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

    /**
     * @brief initializes the board with two numbers
     * @details the board is generated with either a 2 or 4 randomly on the board
     */
    private void start() {
        int startingTiles = 2;
        for(int i = 0; i < startingTiles; i++) {
            boardT.addNewNumber();
        }
    }

    /**
     * @brief Finds the proper x-axis value on the game board
     * @return returns the int value of the x-axis for the tile in the GUI
     */
    public int getTileX(int col) {
        return SPACING + col * Tile.WIDTH + col * SPACING;
    }

    /**
     * @brief Finds the proper y-axis value on the game board
     * @return returns the int value of the y-axis for the tile in the GUI
     */
    public int getTileY(int row) {
        return SPACING + row * Tile.HEIGHT + row * SPACING;
    }

    /**
     * @brief renders the board on the GUI
     */
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

    /**
     * @brief updates the board after every move
     */
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

    /**
     * @brief Changes the position of the updated tiles after a move is played
     * @param current represents the tile to be reset
     * @param row represents the row value of the tile
     * @param col represents the column value of the tile
     */
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

    /**
     * @brief Checks after every turn if the game is complete, updates the high score
     */
    private void turnCheck() {
        if(!boardT.getIsOver() && boardT.getIsChanged()) boardT.addNewNumber();
        boardT.resetChanged();
        boardT.updateStatus();
        if(boardT.getIsOver()) {
            setHighScore();
        }
    }

    /**
     * @brief Registers key events and moves the tile accordingly
     */
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
