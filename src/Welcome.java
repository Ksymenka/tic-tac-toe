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
        System.out.println("Just to be sure. First player's name is " + name1 + " and second player's name is " + name2 + " am I right?\n"
        + "(type \"yes\" or \"no\")");
        String respond = scan.nextLine();
        if (respond == "yes") {
            System.out.println("Great! So let us play!");
        } else if (respond == "no") {
            System.out.println("Whoops! Let's correct the mistakes we made.\n\n");
            welcome();
            confirmation();
        } else {
            System.out.println("Sorry! Inccorect respond! Let's try that again, shall we?");
            confirmation();
        }
    }

}
