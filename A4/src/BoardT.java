/**
 * @file: BoardT.java
 * @Author: Rizwan Ahsan, ahsanm7
 * @Date: April 16, 2021
 * @Description: module that stores the state and status of the game
 */

package src;

public class BoardT {

    private int[][] board;
    private boolean isOver;
    private boolean isWon;
    private boolean changed;

    /**
     * @brief constructor
     * @details generates a board with given size and adds two number on board
     * @param size integer to represent the size of the board
     * @throws IllegalArgumentException - if size of board is less than 4
     */
    public BoardT(int size) {
        if(size < 4) {
            throw new IllegalArgumentException("Board must be greater than 3");
        }
        this.board = new int[size][size];
        this.isOver = false;
        this.changed = false;
    }

    /**
     * @brief adds 2 or 4 on a random position in board
     * @details 2 has 90% probability and 4 has 10% probability to be new number
     */
    public void addNewNumber() {
        int row = (int) (Math.random() * board.length);
        int col = (int) (Math.random() * board.length);

        while(board[row][col] != 0) {
            row = (int) (Math.random() * board.length);
            col = (int) (Math.random() * board.length);
        }

        if(Math.random() > 0.1) {
            board[row][col] = 2;
        } else {
            board[row][col] = 4;
        }
    }

    /**
     * @brief updates the status of the game
     * @details checks if the game is complete or not and updates accordingly
     */
    public void updateStatus() {
        for (int[] ints : board) {
            for (int j = 0; j < board.length; j++) {
                if (ints[j] == 2048) {
                    isOver = true;
                    isWon = true;
                    return;
                }
                if (ints[j] == 0) return;
            }
        }

        for(int i = 0; i < board.length - 1; i++) {
            for(int j = 0; j < board.length - 1; j++) {
                if((board[i][j] == board[i + 1][j]) || (board[i][j] == board[i][j + 1]))
                    return;
            }
        }

        for(int i = 0; i < board.length - 1; i++) {
            if(board[i][board.length - 1] == board[i + 1][board.length - 1]) return;
        }

        for(int j = 0; j < board.length - 1; j++) {
            if(board[board.length - 1][j] == board[board.length - 1][j + 1]) return;
        }

        isOver = true;
        isWon = false;
    }

    /**
     * @brief transposes the game board
     * @details interchanges the rows and columns of the board
     */
    public void transpose() {
        int[][] result = new int[board.length][board.length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                result[i][j] = board[j][i];
            }
        }

        for(int i = 0; i < board.length; i++) {
            System.arraycopy(result[i], 0, board[i], 0, board.length);
        }
    }

    /**
     * @brief inverses the board matrix
     */
    public void inverse() {
        int[][] result = new int[board.length][board.length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                result[i][j] = board[i][board.length - 1 - j];
            }
        }

        for(int i = 0; i < board.length; i++) {
            System.arraycopy(result[i], 0, board[i], 0, board.length);
        }
    }

    /**
     * @brief shifts all numbers in the board to their left most index
     */
    public void shiftCells() {
        int[][] result = new int[board.length][board.length];
        for(int i = 0; i < board.length; i++) {
            int position = 0;
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] != 0) {
                    result[i][position] = board[i][j];
                    if(j != position) changed = true;
                    position++;
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            System.arraycopy(result[i], 0, board[i], 0, board.length);
        }
    }

    /**
     * @brief merges two adjacent cells together
     * @details the adjacent cells having same number merges into their double value
     */
    public void mergeCells() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length - 1; j++) {
                if((board[i][j] == board[i][j + 1]) && board[i][j] != 0) {
                    board[i][j] = board[i][j] * 2;
                    board[i][j + 1] = 0;
                    this.changed = true;
                }
            }
        }
    }

    /**
     * @brief sets the changed state variable to false
     */
    public void resetChanged() {
        changed = false;
    }

    /**
     * @brief getter to get board state variable
     * @return returns the board
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * @brief getter to get isOver state variable
     * @return returns the game over status of game
     */
    public boolean getIsOver() {
        return isOver;
    }

    /**
     * @brief getter to get isWon state variable
     * @return returns the win/loss status of game
     */
    public boolean getIsWon() {
        return isWon;
    }

    /**
     * @brief getter to get changed state variable
     * @return returns the changed status of the board
     */
    public boolean getIsChanged() {
        return changed;
    }
}