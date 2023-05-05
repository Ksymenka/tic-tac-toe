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
        board[row][column] = "X ";
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
        board[row][column] = "Y ";
    }

    void chooseMove(String player1Name, String player2Name) {
        Welcome welcome = new Welcome();
        System.out.println(player1Name + "'s turn!");
        drawBoard();
        player1Move();
        drawBoard();
        System.out.println(player2Name + "'s turn!");
        player2Move();
        drawBoard();
    }
    void backToZero(int i, int j) {
        i = 0;
        j = 0;
    }
    boolean chechIfXWon(int i, int j) {
        if (board[i][j] == "X " && board[i++][j] == "X " && board[i + 2][j] == "X ") {
            return true;
        }
        return false;
    }

    boolean winning(String player1Name, String player2Name) {
        int i = 0, j = 0;
        while (true) {
            //3 in a row
            if (board[i][j] == "X " || board[i][j++] == "X " || board[i][j + 2] == "X ") {
                i++;
                if (chechIfXWon(i,j)) {
                    System.out.println(player1Name + " has won!");
                    Players.pointsPlayer1++;
                } else {

                }
                return false;
            } else if (board[i][j] == "X ") {
                backToZero(i,j);
                j++;
                System.out.println(player1Name + " has won!");
                Players.pointsPlayer1++;
            } else if ()

        }
        return false;
    }
}

}
