public class Main {

    public static void main(String[] args) {

        Welcome welcome = new Welcome();
        welcome.welcome();
        Players player1 = new Players(welcome.name1);
        Players player2 = new Players(welcome.name2);
        welcome.confirmation();

        Board board = new Board();
        board.makeBoard();
        do {
            board.chooseMove(player1.name, player2.name);
        }while (board.checkWin());
    }
}