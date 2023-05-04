import java.io.PrintStream;

public class Board {
    int n = 3;
    String[][] board = new String[n][n];
    public void drawBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = "_";
                System.out.printf(board[i][j]);
            }
            System.out.println();
        }
    }

}
