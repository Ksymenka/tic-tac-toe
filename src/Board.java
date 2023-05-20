import java.util.Scanner;
import java.util.Arrays;
public class Board {
    String player1Name, player2Name;

    char[][] board = new char[3][3];
    char symbol;

    void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
            System.out.println();
        }
    }

    void drawBoard() {
        System.out.print("  0 1 2\n");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.printf(String.valueOf(board[i][j]) + " ");
            }
            System.out.println();
        }
    }

    boolean valueOutOfRange(int value) {
        if (value > 2) {
            System.out.println("Value out of range! Please try again.");
            return true;
        }
        return false;
    }

    void checkIfTaken(int row, int column, char symbol) {
        if (board[row][column] == '_') {
            board[row][column] = symbol;
        } else {
            System.out.println("Sorry! This spot is already taken. Please choose another one!");
            if (symbol == 'X') {
                player1Move();
            } else player2Move();
        }

    }

    int chooseRow() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select number of *row* you want to choose:");
        int row = scanner.nextInt();
        if (valueOutOfRange(row)) {
            return chooseRow();
        }
        return row;
    }

    int chooseColumn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select number of *column* you want to choose:");
        int column = scanner.nextInt();
        if (valueOutOfRange(column)) {
            return chooseColumn();
        }
        return column;
    }

    void player1Move() {
        int row, column;
        drawBoard();
        row = chooseRow();
        column = chooseColumn();
        checkIfTaken(row, column, 'X');
    }

    void player2Move() {
        int row, column;
        drawBoard();
        row = chooseRow();
        column = chooseColumn();
        checkIfTaken(row, column, 'O');
    }

    void startGame(String player1Name, String player2Name) {
        resetBoard();
        while (true) {
            this.player1Name = player1Name;
            this.player2Name = player2Name;
            System.out.println(player1Name + "'s turn!");
            player1Move();
            if (checkWin()) {
                winMessage();
                break;
            } else if (checkDraw()) {
                System.out.println("Game has ended with a draw! No points for anyone.");
                break;
            }

            System.out.println(player2Name + "'s turn!");
            player2Move();
            checkWin();
            if (checkWin()) {
                winMessage();
                break;
            } else if (checkDraw()) {
                System.out.println("Game has ended with a draw! No points for anyone.");
                break;
            }

        }
        restartGame();

    }

    boolean checkWin() {
        char[] Row = new char[3];
        char[] Column = new char[3];
        char[] Slant1 = new char[3];
        char[] Slant2 = new char[3];
        while (true) {
            //row
            for (int column = 0; column < 3; column++) {
                for (int row = 0; row < 3; row++) {
                    Row[row] = board[column][row];
                    if (checkMatch(Row)) {
                        System.out.println(Row);
                        return true;
                    }
                }
                resetArray(Row);
            }

            //column
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    Column[column] = board[column][row];
                    if (checkMatch(Column)) {
                        System.out.println(Column);
                        return true;
                    }
                }
                resetArray(Column);
            }

            //first slant
            for (int i = 0; i < 3; i++) {
                Slant1[i] = board[i][i];
                if (checkMatch(Slant1)) {
                    return true;
                }
            }

            //second slant
            for (int j = 2, i = 0; j > -1; j--, i++) {
                Slant2[i] = board[i][j];
                if (checkMatch(Slant2)) {
                    return true;
                }
            }
            break;
        }

        return false;
    }

    void winMessage() {
        if (this.symbol == 'X') {
            ++Player.pointsPlayer1;
            drawBoard();
            System.out.println(player1Name + " has won! He has " + Player.pointsPlayer1 + " points at the moment.");
        } else if (this.symbol == 'O') {
            ++Player.pointsPlayer2;
            drawBoard();
            System.out.println(player2Name + " has won! He has " + Player.pointsPlayer2 + " points at the moment." );
        }
    }

    boolean checkMatch(char[] symbol) {
        for (int i = 0; i < 3; i++) {
            if (symbol[i] != symbol[1] || symbol[i] == '_') return false;
        }
        this.symbol = symbol[1];
        return true;
    }

    boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    //no draw
                    return false;
                }
            }
        }
        return true;
    }

    void restartGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play again?\n(type \"y\" or \"n\")");
        while (true) {
            char answer = scanner.next(".").charAt(0);
            if (answer == 'y') {
                startGame(player1Name, player2Name);
                break;
            } else if (answer == 'n') {
                System.out.println("Thank you for playing!\nThe score is:\n"
                        + Player.pointsPlayer1 + " for " + player1Name
                        + "\n" + Player.pointsPlayer2 + " for " + player2Name);
                break;
            } else {
                System.out.println("Invalid symbol");
                restartGame();
            }
        }
    }

    void resetArray(char[] array) {
        for (int i = 0; i < 3; i++) {
            array[i] = '_';
        }
    }


}
