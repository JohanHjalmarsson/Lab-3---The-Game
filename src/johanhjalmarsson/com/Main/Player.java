package johanhjalmarsson.com.Main;
import johanhjalmarsson.com.Monsters.Monster;

public class Player {
    private String name;
    private int experience;
    private int hp;
    private int level;
    private int gold;
    private int armor;
    private int magicPower;

    /**
     * Constructor for Player
     */
    public Player() {
        experience = 0;
        hp = 100;
        level = 1;
    }

    /**
     * Getter for name
     * @return returns name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name
     * @param name argument String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for hp
     * @return returns hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * setter for hp
     * @param hp argument int hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * getter for armor
     * @return returns armor
     */
    public int getArmor() {
        return armor;
    }

    /**
     * setter for armor
     * @param armor argument int armor
     */
    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     * setter for magicPower
     * @param magicPower argument int magicPower
     */
    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    /**
     * Deals random amount of damage to Monster monster.
     * Sets a new Hp value for monster using setHp()
     * If the player has purchased Magic Power, damage has more effect.
     *
     * @param monster
     */
    public void dealDamage(Monster monster) {
        int damage = RandomClass.getRandomHigh();
        if (magicPower > 0) {
            damage += 2;
            magicPower--;
        }
        monster.setHp(monster.getHp()-damage);
        System.out.println("You've attacked and dealed "+damage+"!");
        System.out.println("The monster now has "+monster.getHp()+" health left");
    }

    /**
     * Changing the level of the player by 1
     */
    public void levelUp() {
        level += 1;
        System.out.println("Congrats! You've just leveled up!");
    }

    /**
     * Checks if experience is 100 or more. If yes it uses levelUp() to change level of player.
     */
    public void checkXp() {
        if (experience >= 100) {
            levelUp();
            isWinning();
            experience = experience - 100;
        }
    }

    /**
     * Checks if level is 10. If so the player has won the game and the program exits.
     */
    public void isWinning() {
        if (level == 10) {
            System.out.println("Congrats! You've reached level 10 and thereby won the game!!");
            System.out.println("Bye bye!!!");
            System.exit(0);
        }
    }

    /**
     * Adds int e to experience
     * @param e
     */
    public void retrieveExperience(int e) {
        experience += e;
    }

    /**
     * Add int g to gold
     * @param g
     */
    public void retrieveGold(int g) {
        gold += g;
    }

    /**
     * Boolean if hp is more than 0
     * @return true if hp is more than 0, else false
     */
    public boolean notDead() {
        return hp > 0;
    }

    /**
     * toString-similar metod to return String of Player info.
     * @return String of name+hp+level+experience+gold
     */
    public String showDetails() {
        return "* Name: "+name+"\n"+
                "* Healt point: "+Integer.toString(hp)+"\n"+
                "* Level: "+Integer.toString(level)+"\n"+
                "* Experience points: "+Integer.toString(experience)+"\n"+
                "* Gold: "+Integer.toString(gold);
    }

    /**
     * getter for gold
     * @return returns gold
     */
    public int getGold() {
        return gold;
    }

    /**
     * setter for gold
     * @param gold argument int gold
     */
    public void setGold(int gold) {
        this.gold = gold;
    }
}
