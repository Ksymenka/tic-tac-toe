public class Player {
    private String name;
    private char charcter;
    private int points;


    public Player(String name, char charcter) {
        this.name = name;
        this.charcter = charcter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getCharcter() {
        return charcter;
    }

    public void setCharcter(char charcter) {
        this.charcter = charcter;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
