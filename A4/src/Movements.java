/**
 * @file: Movements.java
 * @Author: Rizwan Ahsan, ahsanm7
 * @Date: April 16, 2021
 * @Description: Movements module handles the input received and changes board accordingly
 */

package src;

public class Movements {

    /**
     * @brief moves all number in board to the left and merges equal numbers together
     * @param board the board to do the movement
     */
    public static void moveLeft(BoardT board) {
        board.shiftCells();
        board.mergeCells();
        board.shiftCells();
    }

    /**
     * @brief moves all number in board to the right and merges equal numbers together
     * @param board the board to do the movement
     */
    public static void moveRight(BoardT board) {
        board.inverse();
        moveLeft(board);
        board.inverse();
    }

    /**
     * @brief moves all number in board upwards and merges equal numbers together
     * @param board the board to do the movement
     */
    public static void moveUp(BoardT board) {
        board.transpose();
        moveLeft(board);
        board.transpose();
    }

    /**
     * @brief moves all number in board downwards and merges equal numbers together
     * @param board the board to do the movement
     */
    public static void moveDown(BoardT board) {
        board.transpose();
        moveRight(board);
        board.transpose();
    }
}
