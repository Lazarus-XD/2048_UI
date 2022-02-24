/**
 * @file: BoardT.java
 * @Author: Rizwan Ahsan, ahsanm7
 * @Date: April 16, 2021
 * @Description: module that stores the state and status of the game
 */

package src;

public class BoardT {

    private Tile[][] board;
    private boolean isOver;
    private boolean isWon;
    private boolean isChanged;
    private static int SPACING = 10;
    private int score = 0;

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
        this.board = new Tile[size][size];
        this.isOver = false;
        this.isChanged = false;
    }

    /**
     * @brief adds 2 or 4 on a random position in board
     * @details 2 has 90% probability and 4 has 10% probability to be new number
     */
    public void addNewNumber() {
        int row = (int) (Math.random() * board.length);
        int col = (int) (Math.random() * board.length);

        while(board[row][col] != null) {
            row = (int) (Math.random() * board.length);
            col = (int) (Math.random() * board.length);
        }


        if(Math.random() > 0.1) {
            board[row][col] = new Tile(2, getTileX(col), getTileY(row));
        } else {
            board[row][col] = new Tile(4, getTileX(col), getTileY(row));
        }
    }

    public int getTileX(int col) {
        return SPACING + col * Tile.WIDTH + col * SPACING;
    }

    public int getTileY(int row) {
        return SPACING + row * Tile.HEIGHT + row * SPACING;
    }

    /**
     * @brief updates the status of the game
     * @details checks if the game is complete or not and updates accordingly
     */
    public void updateStatus() {
        for (Tile[] ints : board) {
            for (int j = 0; j < board.length; j++) {
                if(ints[j] == null) return;

                if (ints[j].getValue() == 2048) {
                    isOver = true;
                    isWon = true;
                    return;
                }
            }
        }

        for(int i = 0; i < board.length - 1; i++) {
            for(int j = 0; j < board.length - 1; j++) {
                if(board[i][j] == null || board[i+1][j] == null || board[i][j+1] == null) continue;
                if((board[i][j].getValue() == board[i + 1][j].getValue()) || (board[i][j].getValue() == board[i][j + 1].getValue()))
                    return;
            }
        }

        for(int i = 0; i < board.length - 1; i++) {
            if(board[i][board.length - 1] == null || board[i+1][board.length - 1] == null) continue;
            if(board[i][board.length - 1].getValue() == board[i + 1][board.length - 1].getValue()) return;
        }

        for(int j = 0; j < board.length - 1; j++) {
            if(board[board.length - 1][j] == null || board[board.length - 1][j+1] == null) continue;
            if(board[board.length - 1][j].getValue() == board[board.length - 1][j + 1].getValue()) return;
        }

        isOver = true;
        isWon = false;
    }

    /**
     * @brief transposes the game board
     * @details interchanges the rows and columns of the board
     */
    public void transpose() {
        Tile[][] result = new Tile[board.length][board.length];
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
        Tile[][] result = new Tile[board.length][board.length];
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
        Tile[][] result = new Tile[board.length][board.length];
        for(int i = 0; i < board.length; i++) {
            int position = 0;
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] != null) {
                    result[i][position] = board[i][j];
                    if(j != position) isChanged = true;
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

                if(board[i][j] == null || board[i][j + 1] == null) continue;

                if((board[i][j].getValue() == board[i][j + 1].getValue()) && board[i][j].getValue() != 0) {
                    board[i][j].setValue(board[i][j].getValue() * 2);
                    board[i][j + 1] = null;
                    this.isChanged = true;
                    score += board[i][j].getValue();
                }
            }
        }
    }

    /**
     * @brief sets the isChanged state variable to false
     */
    public void resetChanged() {
        isChanged = false;
    }

    /**
     * @brief getter to get board state variable
     * @return returns the board
     */
    public Tile[][] getBoard() {
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
     * @brief getter to get isChanged state variable
     * @return returns the isChanged status of the board
     */
    public boolean getIsChanged() {
        return isChanged;
    }

    public int getScore() {
        return score;
    }
}