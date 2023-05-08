public class Main {

    public static void main(String[] args) {

        boolean win = false;
        Welcome welcome = new Welcome();
        welcome.welcome();
        Players player1 = new Players(welcome.name1);
        Players player2 = new Players(welcome.name2);
        welcome.confirmation();

        Board board = new Board();
        board.makeBoard();

        board.startGame(player1.name, player2.name);
    }
}