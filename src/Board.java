import java.util.Scanner;

public class Board {
    int n = 3;
    String[][] board = new String[n][n];
    void makeBoard() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                board[i][j] = "_ ";
            }
            System.out.println();
        }
    }
    void drawBoard() {
        System.out.print("  0 1 2\n");
        for (int i = 0; i < this.n; i++) {

            System.out.print(i + " ");
            for (int j = 0; j < this.n; j++) {
                System.out.printf(board[i][j]);
            }
            System.out.println();
        }
    }

    void chooseMove(String player1Name, String player2Name) {
        Scanner scanner = new Scanner(System.in);
        Welcome welcome = new Welcome();
        System.out.println(player1Name + "'s turn!");
        drawBoard();
        int row, column;
        System.out.println("Please select number of *row* you want to choose:");
        row = scanner.nextInt();
        if (row > 2) {
            System.out.println("Value out of range!");

        }
        System.out.println("Please select number of *column* you want to choose:");
        column = scanner.nextInt();
        if (column > 2) {
            System.out.println("Value out of range!");
        }
        board[row][column] = "X ";
        drawBoard();
    }


}
