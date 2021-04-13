package src;

import src.BoardT;

public class Movements {

    public static void moveLeft(BoardT board) {
        board.shiftCells();
        board.mergeCells();
        board.shiftCells();
    }

    public static void moveRight(BoardT board) {
        board.reverse();
        moveLeft(board);
        board.reverse();
    }

    public static void moveUp(BoardT board) {
        board.transpose();
        moveLeft(board);
        board.transpose();
    }

    public static void moveDown(BoardT board) {
        board.transpose();
        moveRight(board);
        board.transpose();
    }
}
