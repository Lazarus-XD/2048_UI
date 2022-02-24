/**
 * @file: KeyBoard.java
 * @Author: Rizwan Ahsan, ahsanm7
 * @Date: February 23, 2022
 * @Description: KeyBoard module handles all the keyboard inputs
 */

package src;

import java.awt.event.KeyEvent;

public class KeyBoard {

    public static boolean[] pressed = new boolean[256];
    public static boolean[] prev = new boolean[256];

    private KeyBoard() {}

    public static void update() {
        for(int i = 0; i < 4; i++) {
            if(i == 0) prev[KeyEvent.VK_LEFT] = pressed[KeyEvent.VK_LEFT];
            if(i == 1) prev[KeyEvent.VK_RIGHT] = pressed[KeyEvent.VK_RIGHT];
            if(i == 2) prev[KeyEvent.VK_UP] = pressed[KeyEvent.VK_UP];
            if(i == 3) prev[KeyEvent.VK_DOWN] = pressed[KeyEvent.VK_DOWN];
        }
    }
    public static void keyPressed(KeyEvent e) {
        pressed[e.getKeyCode()] = true;
    }

    public static void keyReleased(KeyEvent e) {
        pressed[e.getKeyCode()] = false;
    }

    public static boolean typed(int keyEvent) {
        return !pressed[keyEvent] && prev[keyEvent];
    }
}