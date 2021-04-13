package src;

public class BoardT {

    private int[][] board;
    private boolean isOver;
    private boolean isWon;

    public BoardT(int size) {
        this.board = new int[size][size];
        this.isOver = false;
        addNewNumber();
        addNewNumber();
    }

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

    public void reverse() {
        int[][] result = new int[board.length][board.length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                result[i][j] = board[i][3 - j];
            }
        }

        for(int i = 0; i < board.length; i++) {
            System.arraycopy(result[i], 0, board[i], 0, board.length);
        }
    }

    public void shiftCells() {
        int[][] result = new int[board.length][board.length];
        for(int i = 0; i < board.length; i++) {
            int position = 0;
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] != 0) {
                    result[i][position] = board[i][j];
                    position++;
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            System.arraycopy(result[i], 0, board[i], 0, board.length);
        }
    }

    public void mergeCells() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length - 1; j++) {
                if((board[i][j] == board[i][j + 1]) && board[i][j] != 0) {
                    board[i][j] = board[i][j] * 2;
                    board[i][j + 1] = 0;
                }
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean getIsOver() {
        return isOver;
    }

    public boolean getIsWon() {
        return isWon;
    }
}