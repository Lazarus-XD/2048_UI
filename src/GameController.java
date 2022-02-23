///**
// * @file: GameController.java
// * @Author: Rizwan Ahsan, ahsanm7
// * @Date: April 16, 2021
// * @Description: controller module that handles inputs and links model and view module
// */
//
//package src;
//
//import java.util.Scanner;
//
//public class GameController {
//
//    private BoardT board;
//    private UserInterface view;
//    private static GameController controller = null;
//
//    private Scanner keyPress = new Scanner(System.in);
//
//    /**
//     * @brief constructor
//     * @param board - model module (BoardT)
//     * @param view - view module (UserInterface)
//     */
//    private GameController(BoardT board, UserInterface view) {
//        this.board = board;
//        this.view = view;
//    }
//
//    /**
//     * @brief public static method for obtaining a single instance
//     * @param board - model module (BoardT)
//     * @param view - view module (UserInterface)
//     * @return the single GameController object
//     */
//    public static GameController getInstance(BoardT board, UserInterface view) {
//        if (controller == null)
//            controller = new GameController(board, view);
//
//        return controller;
//    }
//
//    /**
//     * @brief updates the view module to display a welcome message
//     */
//    public void displayWelcomeMessage() {
//        view.printWelcomeMessage();
//        view.printCommands();
//    }
//
//    /**
//     * @brief updates the view module to display the board
//     */
//    public void displayBoard() {
//        view.printBoard(board.getBoard());
//    }
//
//    /**
//     * @brief updates the view module to display the game ending message
//     */
//    public void displayEnding() {
//        if(board.getIsWon()) view.printWinMessage();
//        else view.printLossMessage();
//    }
//
//    /**
//     * @brief gets the input from the user
//     * @return the input
//     */
//    public String readInput(){
//        String input = "";
//        input = keyPress.nextLine();
//        return input;
//    }
//
//    /**
//     * @brief runs the game
//     */
//    public void playGame() {
//        String input = "";
//        board.addNewNumber();
//        board.addNewNumber();
//        displayWelcomeMessage();
//        displayBoard();
//        do {
//            while (true) {
//                System.out.print("Press the command: ");
//                input = readInput();
//                if (input.equals("w")) {
//                    Movements.moveUp(board);
//                    break;
//                }
//                if (input.equals("s")) {
//                    Movements.moveDown(board);
//                    break;
//                }
//                if (input.equals("a")) {
//                    Movements.moveLeft(board);
//                    break;
//                }
//                if (input.equals("d")) {
//                    Movements.moveRight(board);
//                    break;
//                } else {
//                    System.out.println("Wrong command pressed!");
//                }
//
//            }
//            if(!board.getIsOver() && board.getIsChanged()) board.addNewNumber();
//            displayBoard();
//            board.resetChanged();
//            board.updateStatus();
//        } while (!board.getIsOver());
//
//        displayEnding();
//    }
//}