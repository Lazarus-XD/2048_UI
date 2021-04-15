package src;

public class UserInterface {

    private static UserInterface view = null;

    private UserInterface() {}

    public static UserInterface getInstance(){
        if (view == null)
            return view = new UserInterface();
        return view;
    }


    public void printWelcomeMessage() {
        System.out.println(" -------------------------------------------------");
        System.out.println("|                 Welcome to 2048                 |");
        System.out.println(" -------------------------------------------------");
    }

    public void printCommands() {
        System.out.println("Commands to play the game:");
        System.out.println("w: Move all tiles up");
        System.out.println("s: Move all tiles down");
        System.out.println("a: Move all tiles left");
        System.out.println("d: Move all tiles right");
    }

    public void printLossMessage() {
        System.out.println(" -------------------------------------------------");
        System.out.println("|                   You lost :(                   |");
        System.out.println("|             Thank You For Playing !!!           |");
        System.out.println(" -------------------------------------------------");
    }

    public void printWinMessage() {
        System.out.println(" -------------------------------------------------");
        System.out.println("|                   You won :)                    |");
        System.out.println("|             Thank You For Playing !!!           |");
        System.out.println(" -------------------------------------------------");
    }

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