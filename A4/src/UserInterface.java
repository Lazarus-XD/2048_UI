/**
 * @file: UserInterface.java
 * @Author: Rizwan Ahsan, ahsanm7
 * @Date: April 16, 2021
 * @Description: module to handle all the interface elements
 */

package src;

public class UserInterface {

    private static UserInterface view = null;

    /**
     * @brief constructor
     */
    private UserInterface() {}

    /**
     * @brief public static method for obtaining a single instance
     * @return an UserInterface object
     */
    public static UserInterface getInstance(){
        if (view == null)
            return view = new UserInterface();
        return view;
    }

    /**
     * @brief display a welcome message
     */
    public void printWelcomeMessage() {
        System.out.println(" -------------------------------------------------");
        System.out.println("|                 Welcome to 2048                 |");
        System.out.println(" -------------------------------------------------");
    }

    /**
     * @brief display the game commands
     */
    public void printCommands() {
        System.out.println("Commands to play the game:");
        System.out.println("w: Move all tiles up");
        System.out.println("s: Move all tiles down");
        System.out.println("a: Move all tiles left");
        System.out.println("d: Move all tiles right");
    }

    /**
     * @brief display the game lost message
     */
    public void printLossMessage() {
        System.out.println(" -------------------------------------------------");
        System.out.println("|                   You lost :(                   |");
        System.out.println("|             Thank You For Playing !!!           |");
        System.out.println(" -------------------------------------------------");
    }

    /**
     * @brief display the game won message
     */
    public void printWinMessage() {
        System.out.println(" -------------------------------------------------");
        System.out.println("|                   You won :)                    |");
        System.out.println("|             Thank You For Playing !!!           |");
        System.out.println(" -------------------------------------------------");
    }

    /**
     * @brief display the game board
     * @param board the board to be displayed
     */
    public void printBoard(int[][] board) {
        for (int[] ints : board) {
            for (int j = 0; j < board.length; j++) {
                if (ints[j] == 0) {
                    System.out.print("|__");
                } else {
                    System.out.print("|" + ints[j]);
                }
            }
            System.out.println("|");
        }
    }
}