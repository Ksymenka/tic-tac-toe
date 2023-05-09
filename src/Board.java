import java.util.Scanner;

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
        while (true) {
            this.player1Name = player1Name;
            this.player2Name = player2Name;
            System.out.println(player1Name + "'s turn!");
            player1Move();
            if (checkWin()) {
                break;
            }
            System.out.println(player2Name + "'s turn!");
            player2Move();
            checkWin();
            if (checkWin()) {
                break;
            }
        }
    }

    boolean checkWin() {
        System.out.println(checkRow());
        if (checkRow()) {
            winMessage(this.symbol);
            return true;
        }

        return false;
    }

    void winMessage(char symbol) {
        if (symbol == 'X') {
            ++Player.pointsPlayer1;
            drawBoard();
            System.out.println(player1Name + " has won!");
        } else if (symbol == 'O') {
            ++Player.pointsPlayer2;
            drawBoard();
            System.out.println(player2Name + " has won!");
        }


    }

    //tu musi być błąd!!
    boolean checkRow() { //sprawdza rząd
        boolean firstRow = false;
        boolean allMatch = false;
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != '_') {
                firstRow = true;
                if (firstRow) {
                    char symbol = board[row][0];
                    for (int column = 1; column < 3; column++) {
                        if (board[row][column] != symbol) {
                            allMatch = false;
                            break;
                        } else {
                            allMatch = true;
                        }
                    }
                }
            }
        }
        return allMatch;
    }


    boolean checkColumn() { //sprawdza kolumnę
    return false;
    }

    boolean checkSlant() { //sprawdza kąt
    return false;
    }

    char checkSymbol(int row, int column) { //zwraca symbol z danej pozycji
        char symbol = board[row][column];
        return symbol;
    }


    boolean takenField(char symbol) { //jezeli pole ma przypisaną wartość X lub O zwróć true
        if (symbol == 'X' || symbol == 'O') {
            return true;
        }
        return false;
    }

    char searchForSymbol() {
        char symbol;
        int row, column;
        for (column  = 0; column < 3; column++) {
            symbol = checkSymbol(0,column);
            if (symbol == 'X' || symbol == 'O') {
                return symbol;
            } else {
                for (row = 1; row < 3; row++) {
                    if (symbol == 'X' || symbol == 'O') {
                        symbol = checkSymbol(row, column);
                        return symbol;
                    }
                }
            }
        }
        return '_';
    }

}
