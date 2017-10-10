package johanhjalmarsson.com.Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Player p = new Player();
    static Game game = new Game();
    static Menu m = new Menu();
    static Scanner sc = new Scanner(System.in);

    static Shop shop1 = new Shop();

    public static void main(String[] args) {


            System.out.println("********************************");
            System.out.println("* Welcome to this amazing game *");
            System.out.println("********************************");
            System.out.println("Please enter your name: ");
            p.setName(sc.nextLine());

            initialize(p);
            new Main().menu();
            displayMenu();


    }

    /**
     * adds menu options using the MenuOption interface to Menu m.
     */
    public void menu() {
        m.add("Go adventuring!!", this::goAdventuring );
        m.add("Display information about your character", this::displayCharacter );
        m.add("Visit shop", this::goShopping);
        m.add ("Exit game...", this::exitGame);
    }

    /**
     * Displays Menu m and lets the user choose a menu option with Scanner.
     */
    public static void displayMenu() {
        while (true) {
            m.display();
            int i = m.choice();
            m.execute1(i);
        }
    }

    /**
     * Initialize the game by adding Player p to game,shop1 and launches menu() for shop1
     * @param p
     */
    public static void initialize(Player p) {
        game.setPlayer(p);
        shop1.setPlayer(p);
        shop1.menu();

    }

    /**
     * Creates (amountOfMonsters) random Monsters and adds them to Game game.
     * Uses the RandomClass to get a 10% chance to run "if", else launch game.battle() and p.checkXp()
     */
    public void goAdventuring() {

        game.createRandomMonster(4);
        if(RandomClass.getRandomTenPercent() == 5) {
            System.out.println("Your are walking down the road... Everything looks peaceful and calm.. Hit enter to continue!");
            sc.nextLine();

        } else {
            game.battle();
            p.checkXp();
        }
    }

    /**
     * Launches theShop() for shop1
     */
    public void goShopping() {
        shop1.theShop();

    }

    /**
     * Displays info about Player p, using p.showDetails()
     */
    public void displayCharacter() {
        System.out.println("**************************");
        System.out.println(p.showDetails());
        System.out.println("**************************"+"\n");

    }

    /**
     * Exit message and exit System.
     */
    public void exitGame() {
        System.out.println("Thank you and good bye!");
        System.exit(0);
    }

}
