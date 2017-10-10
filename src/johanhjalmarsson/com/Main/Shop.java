package johanhjalmarsson.com.Main;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Shop {

    private Player player;
    static Menu shopMenu = new Menu();
    static Scanner sc = new Scanner(System.in);

    /**
     * Adds armor to player with setArmor() and subracts gold using setGold()
     * @param amount determines amount of armor bought and amount of gold paid
     */
    public void buyArmor(int amount) {
        player.setArmor(amount);
        player.setGold(player.getGold()-amount);

    }

    /**
     * Adds MagicPower to player with setMagicPower() and substracts gold using setGold()
     * @param amount determines amount of armor bought and amount of gold paid
     */
    public void buyMagicPower(int amount) {
        player.setMagicPower(amount);
        player.setGold(player.getGold()-amount);

    }

    /**
     * Adds armor to player with setHp() and substracts gold using setGold()
     * @param amount determines amount of hp bought and amount of gold paid.
     */
    public void buyHp(int amount) {
        player.setHp(player.getHp()+amount);        // FIXA TILL DET HÄR!!
        player.setGold(player.getGold()-amount);

    }

    /**
     * adds menu options using the MenuOption interface to Menu shopMenu.
     */
    void menu() {
        shopMenu.add("Buy Armor; 1 gold per armor", this::shopArmor );
        shopMenu.add("Buy Magic Power; 1 gold per potion", this::shopMagicPower);
        shopMenu.add("Buy healing potions", this::shopHp);
        shopMenu.add("Return to main menu", this::returnToMenu);
    }



    /**
     * Displays shopMenu and lets user choose menu option.
     */
    public void theShop() {
        System.out.println("***************************");
        System.out.println("* Welcome to the SHOP!!!! *");
        System.out.println("***************************");

        while (true) {
            System.out.println("Available gold: "+player.getGold());
            shopMenu.display();
            int i = shopMenu.choice();
            shopMenu.option(i);
        }

    }

    private void returnToMenu() {
        Main.displayMenu();
    }

    /**
     * Lets the user purchase MagicPower by entering amount and using buyMagicPower.
     * Checks if the player has enough gold to purchase.
     */
    void shopMagicPower() {
        System.out.println("Enter amount of potions of Magic Power you want to buy:");
        int amount = UserInput.input();
        if(!isGoodFor(amount)) {
            return;
        }
        buyMagicPower(amount);
        System.out.println("Thank you! You've bougth "+amount+" potions and now have "+player.getGold()+" gold left."+"\n");

    }
    /**
     * Lets the user purchase Armor by entering amount and using buyArmor.
     * Checks if the player has enough gold to purchase.
     */
    void shopArmor() {
        System.out.println("Enter amount of armor you want to buy:");
        int amount = UserInput.input();
        if(!isGoodFor(amount)) {
            return;
        }
        buyArmor(amount);
        System.out.println("Thank you! You've bougth "+amount+" armor and now have "+player.getGold()+" gold left."+"\n");
    }

    /**
     * Lets the user purchase hp by entering amount and using buyHp
     * Checks if the player has enough gold to purchase.
     */
    private void shopHp() {
        System.out.println("Enter amount of healing potions you want to buy:");
        int amount = UserInput.input();
        if(!isGoodFor(amount)) {
            return;
        }
        if (!healthUnderHundred(amount)) {
            return;
        }
        buyHp(amount);
        System.out.println("Thank you! You've bougth "+amount+" healing potions and now have "+player.getGold()+" gold left."+"\n");
    }

    /**
     * Check if player has enough gold for purchasing (amount)
     * @param amount amount of armor or magic power user wants to purchase
     * @return false if player doesn't has enough gold, else true.
     */
    boolean isGoodFor(int amount) {
        if (player.getGold() < amount) {
            System.out.println("You don't have enough gold!"+"\n");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check if amount of healing potions combined with healt points is more than 99.
     *
     * @param amount amount of healing potions user wants to buy
     * @return true if selected amount + player health point is less than 100, else false.
     */
    boolean healthUnderHundred(int amount) {
        if ((player.getHp()+amount) > 99) {
            System.out.println("You cannot have more health than 100! Try to buy less healing potions"+"\n");
            return false;
        } else {
            return true;
        }
    }
    public Player getPlayer() {
        return player;
    }

    /**
     * setter for player
     * @param player argument Player player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
}
