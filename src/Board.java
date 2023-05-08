import java.util.Scanner;

public class Board {
    String player1Name, player2Name;

    char[][] board = new char[3][3];

    void makeBoard() {
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

    boolean checkWin() {
        char symbol;
        if (checkRow()) {
            symbol = checkSymbol(0,0);
            win(symbol);
            return true;
        } else if (checkColumn()) {
            symbol= checkSymbol(0,0);
            win(symbol);
            return true;
        } else if (checkSlant()) {
            symbol = checkSymbol(1,1);
            win(symbol);
            return true;
        }
        return false;
    }

    void win(char symbol) {
        if (symbol == 'X') {
            ++Players.pointsPlayer1;
            System.out.println(player1Name + " has won!");
        } else if (symbol == 'O') {
            ++Players.pointsPlayer2;
            System.out.println(player2Name + " has won!");
        }


    }

    boolean checkRow() { //sprawdza rząd
        char symbol = checkSymbol(0, 0);
        if (defaultField(symbol)) {
            for (int column = 0; column <=2; column++) {
                if (board[column][0] == symbol) {
                    return true;
                }else {
                    for (int row = 1; row <=2; row++) {
                        if (board[row][column] == symbol) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    boolean checkColumn() { //sprawdza kolumnę
        char symbol = checkSymbol(0,0);
        if (defaultField(symbol)) {
            for (int row = 0; row <=2; row++) {
                if (board[row][0] == symbol) {
                    return true;
                }else {
                    for (int column = 1; column <=2; column++) {
                        if (board[row][column] == symbol) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    boolean checkSlant() { //sprawdza kąt
        char symbol = checkSymbol(1, 1);
        if (defaultField(symbol)){
            for (int row = 0; row <= 2; row++) {
                for (int column = 0; column <= 2; column++) {
                    if (board[row][column] == symbol) {
                        return true; //jeżeli skos od pierwszego pola jest wypełniony znakami zwróć true
                    }
                }
            }
            for (int row = 2; row < 0; row--) {
                for (int column = 0; column <= 2; column++) {
                    if (board[row][column] == symbol) {
                        return true; //jeśli skos od dołu jet wypełniony znakami zwróć true
                    }
                }
            }
        }
        return false;
    }

    char checkSymbol(int row, int column) { //tylko sprawdza jaki symbol jest na danej pozycji!!
        char symbol = board[row][column];
        if (symbol == '_') {
            return '_';
        } else if (symbol == 'X') {
            return 'X';

        } else if (symbol == 'O') {
            return 'O';
        }
        return 0;
    }

    boolean defaultField(char symbol) { //jezeli pole ma przypisaną wartość X lub O zwróć true
        if (symbol == 'X' || symbol == 'O') {
            return true;
        }
        return false;
    }


}

