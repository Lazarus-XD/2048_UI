package src;

import java.util.Scanner;

public class GameController {

    private BoardT board;
    private UserInterface view;
    private static GameController controller = null;

    private Scanner keyPress = new Scanner(System.in);

    private GameController(BoardT board, UserInterface view) {
        this.board = board;
        this.view = view;
    }

    public static GameController getInstance(BoardT board, UserInterface view) {
        if (controller == null)
            controller = new GameController(board, view);

        return controller;
    }

    public void displayWelcomeMessage() {
        view.printWelcomeMessage();
        view.printCommands();
    }

    public void displayBoard() {
        view.printBoard(board.getBoard());
    }

    public void displayEnding() {
        if(board.getIsWon()) view.printWinMessage();
        else view.printLossMessage();
    }

    public String readInput(){
        String input = "";
        input = keyPress.nextLine();
        return input;
    }

    public void playGame() {
        String input = "";
        displayWelcomeMessage();
        displayBoard();
        do {
            while (true) {
                System.out.print("Press the command: ");
                input = readInput();
                if (input.equals("w")) {
                    Movements.moveUp(board);
                    break;
                }
                if (input.equals("s")) {
                    Movements.moveDown(board);
                    break;
                }
                if (input.equals("a")) {
                    Movements.moveLeft(board);
                    break;
                }
                if (input.equals("d")) {
                    Movements.moveRight(board);
                    break;
                } else {
                    System.out.println("Wrong command pressed!");
                }

            }
            board.addNewNumber();
            displayBoard();
            board.updateStatus();
        } while (!board.getIsOver());

        displayEnding();
    }
}