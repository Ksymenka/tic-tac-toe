public class Player {
    private String  name;
    private char character;
    private int points;


    public Player(String name, char character) {
        this.name = name;
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getPoints() {
        return points;
    }

    public void incrementPoints() {
        this.points++;
    }
}
