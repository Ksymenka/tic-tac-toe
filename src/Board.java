public class Board {
    int [][] size = new int[3][3];

    public static void drawBoard() {
        for (int i = 0; i < 2; i++) {
            System.out.println("_|_|_");
        }
        System.out.printf("| |");
    }

}
