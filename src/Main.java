public class Main {

    public static void main(String[] args) {

        boolean win = false;
        Welcome welcome = new Welcome();
        welcome.welcome();
        Player player1 = new Player(welcome.name1);
        Player player2 = new Player(welcome.name2);
        welcome.confirmation();

        Board board = new Board();
        board.resetBoard();

        board.startGame(player1.name, player2.name);
    }
}