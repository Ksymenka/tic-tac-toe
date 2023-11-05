import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private static boolean askForNextGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue? (y/n)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            return true;
        } else if (answer.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Please enter valid answer !");
            return askForNextGame();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the game of tic tac toe ! Please enter the name of the first player: ");
        String playerOneName = scanner.nextLine();
        System.out.println("Great ! Now enter second player name: ");
        String playerTwoName = scanner.nextLine();

        Player playerOne = new Player(playerOneName, 'X');
        Player playerTwo = new Player(playerTwoName, 'O');

        boolean continueGame = true;
        boolean sizeIsValid = false;
        int size = 0;

        do {
            System.out.println("How big your board should be? (enter a number higher than 2) ");
            try {
                size = scanner.nextInt();
                if (size > 2) {
                    sizeIsValid = true;
                } else {
                    throw new IllegalArgumentException("Size shouldn't be lover than 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number !");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        } while (!sizeIsValid);

        GameBoard board = new GameBoard(size);

        while (continueGame) {
            board.printBoard();
            board.makeMove(playerOne);
            if (board.checkWin()) {
                System.out.println("Congratulations ! " + playerOne.getName() + " has won !");
                board.printBoard();
                playerOne.incrementPoints();
                continueGame = askForNextGame();
            }
            if (board.checkFull()) {
                continueGame = askForNextGame();
            }

            board.printBoard();
            board.makeMove(playerTwo);

            if (board.checkFull()) {
                continueGame = askForNextGame();
            }

            if (board.checkWin()) {
                System.out.println("\nCongratulations ! " + playerTwo.getName() + " has won !");
                board.printBoard();
                playerTwo.incrementPoints();
                continueGame = askForNextGame();
            }
        }
    }


}
