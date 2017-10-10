package johanhjalmarsson.com.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements MenuOption, MenuShop {
    private ArrayList<String> menuText = new ArrayList<String>();
    private ArrayList<MenuOption> options = new ArrayList<MenuOption>();


    /**
     * Adds Menu option name and metod to menuText and options.
     * @param s Sets the name of the menu option
     * @param m adds MenuOption to options
     */
    public void add(String s, MenuOption m) {
        menuText.add(s);
        options.add(m);
    }

    /**
     * Displays menuText and options
     */
    public void display() {
        for (int i = 0; i<menuText.size(); i++) {
            System.out.println(i+1+". "+menuText.get(i));
        }
    }

    /**
     * Lets user input int and return it.
     * @return user input (int)
     */
    public int choice() {
        Scanner sc = new Scanner(System.in);
        return UserInput.input() - 1;
    }

    /**
     * ???
     */
    public void execute() {

    }

    /**
     * ???
     * @param i
     */
    public void option(int i) {
        options.get(i).execute();
    }

    /**
     * Executes Menu Option in options index I
     * @param i
     */
    public void execute1(int i) {
        options.get(i).execute();
    }
}
