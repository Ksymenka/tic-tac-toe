import java.util.Scanner;

public class Board {
    String player1Name, player2Name;
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

    void backToZero(int i, int j) {
        i = 0;
        j = 0;
    }

    boolean chechIfXWon(int i, int j) {
        if (board[i][j] == "X " && board[i++][j] == "X " && board[i + 2][j] == "X ") {
            return true;
        } else if (board[i][j] == "X " && board[i][j++] == "X " && board[i][j + 2] == "X ") {
            return true;
        }
        return false;
    }

    boolean chechIfYWon(int i, int j) {
        if (board[i][j] == "Y " && board[i++][j] == "Y " && board[i + 2][j] == "Y ") {
            return true;
        } else if (board[i][j] == "Y " && board[i][j++] == "Y " && board[i][j + 2] == "Y ") {
            return true;
        }
        return false;
    }

    void player1Won() {
        System.out.println(player1Name + " has won!");
        Players.pointsPlayer1++;
    }

    void player2Won() {
        System.out.println(player2Name + " has won!");
        Players.pointsPlayer2++;
    }


    boolean winning(String player1Name, String player2Name) {
        int i = 0, j = 0;
        while (true) {
            //3 in a row
            if (board[i][0] == "X " || board[i][1] == "X " || board[i][2] == "X ") {
                i++;
                if (chechIfXWon(i, j)) {
                    player1Won();
                } else {
                    return false;
                }
            } else if (board[0][j] == "X " || board[1][j] == "X " || board[2][j] == "X ") {
                j++;
                if (chechIfXWon(i, j)) {
                    player1Won();
                } else {
                    return false;
                }
            } else if (board[0][j] == "Y " || board[1][j] == "Y " || board[2][j] == "Y ") {
                j++;
                if (chechIfYWon(i, j)) {
                    player2Won();
                } else {
                    return false;
                }
            } else if (board[i][0] == "Y " || board[i][1] == "Y " || board[i][2] == "Y ") {
                i++;
                if (chechIfYWon(i, j)) {
                    player2Won();
                } else {
                    return false;
                }
            }
        }
    }
}

