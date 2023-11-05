import java.util.InputMismatchException;
import java.util.Scanner;

public class GameBoard {
    private int size;
    private final char[][] board;
    static int boardNumber = 0;
    final private char emptyCharacter = '_';


    public GameBoard (int size) {
        this.size = size;
        board = new char[size][size];

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                board[row][column] = emptyCharacter;
            }
        }
        boardNumber++;
    }

    public void printBoard () {
        for (char[] row : board) {
            for (char column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    public boolean checkCoordinates(int row, int column) {
        return row <= 0 || row > size || column <= 0 || column > size;
    }

    public boolean checkIfEmpty(int row, int column) {
        return board[--row][--column] == emptyCharacter;
    }

    public void makeMove (Player player) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter the number of row: ");
                int row = scanner.nextInt();

                System.out.println("Enter the number of column");
                int column = scanner.nextInt();

                if (checkCoordinates(row, column)) {
                    throw new IllegalArgumentException("Number is out of range !");
                }
                if (checkIfEmpty(row, column)) {
                    board[--row][--column] = player.getCharacter();
                    break;
                } else {
                    throw new IllegalArgumentException(("This spot is already taken !"));
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Ivalid input, please try again: ");
            }
        }
    }


    @org.jetbrains.annotations.Contract(pure = true)
    public static boolean areAllEqual(char[] board) {
        for (char symbol : board) {
            if (symbol == '_') {
                return false;
            }
        }

        if (board.length == 0) {
            return true;
        }
        char firstElement = board[0];
        for (char element : board) {
            if (element != firstElement) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWin () {


        char[] row = new char[size];
        char[] column = new char[size];
        char[] firstSlant = new char[size];
        char[] secondSlant = new char[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                row[j] = board[i][j];
            }
            if (areAllEqual(row)) {
                return true;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                column[j] = board[j][i];
            }
            if (areAllEqual(column)) {
                return true;
            }
        }

        for (int i = 0; i < size; i++) {
            firstSlant[i] = board[i][i++];
            if (areAllEqual(firstSlant)) {
                return true;
            }
        }

        for (int i = 0; i < size; i++) {
            secondSlant[i] = board[i][size - 1 - i];
            if (areAllEqual(secondSlant)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkFull() {
        StringBuilder symbols = new StringBuilder();
        for (char[] row : board) {
            for (char column : row) {
                symbols.append(column);
            }
        }
        String board = symbols.toString();

        if (board.contains("_")) {
            return false;
        } else {
            System.out.println("The game has ended with a draw !");
            return true;
        }
    }

}

