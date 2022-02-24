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

    /**
     * @brief updates the array prev with the pressed values
     */
    public static void update() {
        for(int i = 0; i < 4; i++) {
            if(i == 0) prev[KeyEvent.VK_LEFT] = pressed[KeyEvent.VK_LEFT];
            if(i == 1) prev[KeyEvent.VK_RIGHT] = pressed[KeyEvent.VK_RIGHT];
            if(i == 2) prev[KeyEvent.VK_UP] = pressed[KeyEvent.VK_UP];
            if(i == 3) prev[KeyEvent.VK_DOWN] = pressed[KeyEvent.VK_DOWN];
        }
    }

    /**
     * @brief Sets the key pressed value to true on the pressed array
     * @param e KeyEvent to represent the value of key pressed
     */
    public static void keyPressed(KeyEvent e) {
        pressed[e.getKeyCode()] = true;
    }

    /**
     * @brief Sets the key released value to false on the pressed array
     * @param e KeyEvent to represent the value of key released
     */
    public static void keyReleased(KeyEvent e) {
        pressed[e.getKeyCode()] = false;
    }

    /**
     * @brief Checks if the keyEvent was pressed and removed to allow for single output
     * @param keyEvent integer to represent the value of the keyEvent
     * @return returns a boolean value
     */
    public static boolean typed(int keyEvent) {
        return !pressed[keyEvent] && prev[keyEvent];
    }
}
