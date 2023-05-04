import java.util.Scanner;

public class Welcome {

    String name1, name2;

    Scanner scan = new Scanner(System.in);

    //welcome message
    public void welcome() {
        System.out.println("Hello first player! Please type in your name: ");
        this.name1 = scan.nextLine();
        System.out.println("Hello second player! Please type in your name: ");
        this.name2 = scan.nextLine();
    }

    //confirmation of set values
    public void confirmation() {
        System.out.println("Just to be sure. First player's name is \"" + name1 + "\" and second player's name is \"" + name2 + "\" am I right?\n"
        + "(type \"y\" or \"n\")");
        String respond = scan.nextLine();
        System.out.println(respond);
        switch (respond) {
            case "y":
                System.out.println("Great! So let us play!");
                break;
            case "n":
                System.out.println("Whoopsie! Let's correct our mistakes.\n");
                welcome();
                confirmation();
                break;
            default:
                System.out.println("Sorry! Wrong answers. Input must me \"y\" or \"n\"!");
                confirmation();
        }
    }

}
