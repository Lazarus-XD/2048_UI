/**
 * @file: GameController.java
 * @Author: Rizwan Ahsan, ahsanm7
 * @Date: February 23, 2022
 * @Description: controller module that handles inputs and links model and view module
 */

package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GameController extends JPanel implements KeyListener, Runnable {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 500;
    public static final Font main = new Font("MV Boli", Font.PLAIN, 28);
    private Thread game;
    private boolean running;
    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    private UserInterface board;

    public GameController() {
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);

        board = new UserInterface(WIDTH/2 - UserInterface.BOARD_WIDTH/2, HEIGHT - UserInterface.BOARD_HEIGHT - 10);
    }

    private void update() {
        board.update();
        KeyBoard.update();
    }

    private void render() {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0,WIDTH,HEIGHT);

        //render the board
        board.render(g);
        g.dispose();

        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.drawImage(image,0,0,null);
        g2d.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyBoard.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        KeyBoard.keyReleased(e);
    }

    @Override
    public void run() {
        int fps = 0;
        int updates = 0;
        long fpsTimer = System.currentTimeMillis();
        double nsPerUpdate = 1000000000.0 / 60;

        //last update in nanoseconds
        double then = System.nanoTime();
        double unprocessed = 0;

        //update queue
        while(running) {

            boolean shouldRender = false;
            double now = System.nanoTime();
            unprocessed += (now - then) / nsPerUpdate;
            then = now;

            while (unprocessed >= 1) {
                updates++;
                update();
                unprocessed--;
                shouldRender = true;
            }

            //render
            if (shouldRender) {
                fps++;
                render();
                shouldRender = false;
            } else {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //FPS Timer
        if(System.currentTimeMillis() - fpsTimer > 1000) {
            System.out.printf("%d fps %d updates", fps, updates);
            System.out.println();
            fps = 0;
            updates = 0;
            fpsTimer += 1000;
        }
    }

    public synchronized void start() {
        if(running) return;
        running = true;
        game = new Thread(this, "game");
        game.start();
    }

    public synchronized void stop() {
        if(!running) return;
        running = false;
        System.exit(0);
    }
}
