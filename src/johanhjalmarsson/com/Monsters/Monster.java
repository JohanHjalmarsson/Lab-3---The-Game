package johanhjalmarsson.com.Monsters;
import johanhjalmarsson.com.Main.Main;
import johanhjalmarsson.com.Main.Player;
import johanhjalmarsson.com.Main.RandomClass;
import johanhjalmarsson.com.Main.Game;


public abstract class Monster {
    private String name;
    private int experiencePoints;
    private int hp;
    private int gold;

    /**
     * getter for name
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
     * getter for experiencePoints
     * @return return experiencePoints
     */
    public int getExperiencePoints() {
        return experiencePoints;
    }

    /**
     * setter for experiencePoints
     * @param experiencePoints argument int experiencePoints
     */
    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
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
     * Deals random amount of damage to Player victim.
     * Sets a new Hp value for victim using setHp()
     * If the player has purchased Armor, damage has less effect.
     *
     * @param victim
     */
    public void dealDamage(Player victim) {
        int damage = RandomClass.getRandomLow();
        if (victim.getArmor() > 0) {
            damage -= 2;
            victim.setArmor(victim.getArmor()-1);
        }
        victim.setHp(victim.getHp()-damage);
        System.out.println("The monster hit you and you lost "+damage+" in health. You now have "+victim.getHp());

    }

    /**
     * gives a defeating Player victim experiencePoints using retrieveExperience();
     * @param victim
     */
    public void giveExperience(Player victim) {
        victim.retrieveExperience(experiencePoints);
    }

    /**
     * adds gold to Player p using retrieveGold() and sets gold to 0 using setGold()
     * @param p
     */
    public void loseGold(Player p) {
        p.retrieveGold(getGold());
        setGold(0);
    }

    /**
     * Check is Monster is alive
     * @return true if hp is more than 0, else false
     */
    public boolean notDead() {
        return hp > 0;
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
