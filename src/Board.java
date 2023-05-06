import java.util.Scanner;

public class Board {
    String player1Name, player2Name;
    int n = 3;
    char[][] board = new char[n][n];

    void makeBoard() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                board[i][j] = '_';
            }
            System.out.println();
        }
    }

    void drawBoard() {
        System.out.print("  0 1 2\n");
        for (int i = 0; i < this.n; i++) {

            System.out.print(i + " ");
            for (int j = 0; j < this.n; j++) {
                System.out.printf(String.valueOf(board[i][j]) + " ");
            }
            System.out.println();
        }
    }

    void player1Move() {
        Scanner scanner = new Scanner(System.in);
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
        board[row][column] = 'X';
    }

    void player2Move() {
        Scanner scanner = new Scanner(System.in);
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
        board[row][column] = 'O';
    }

    void chooseMove(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        System.out.println(player1Name + "'s turn!");
        drawBoard();
        player1Move();
        drawBoard();
        System.out.println(player2Name + "'s turn!");
        player2Move();
        drawBoard();
    }



}

