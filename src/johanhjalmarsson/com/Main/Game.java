package johanhjalmarsson.com.Main;
import java.util.ArrayList;
import java.util.Scanner;

import johanhjalmarsson.com.Monsters.*;


public class Game {
    // private RandomClass RC;
    private Player player;
    private ArrayList<Monster> monsters = new ArrayList<Monster>();
    static Scanner sc = new Scanner(System.in);


    /**
     * Clears ArrayList<Monster> monsters, creates random Monster and adds it to ArrayList<Monster> monsters.
     * @param amountOfMonsters sets the amount of Mosters created.
     */
    void createRandomMonster(int amountOfMonsters) {
        monsters.clear();
        for (int i = 0; i<amountOfMonsters; i++) {
            switch (RandomClass.getRandom(4)) {
                case 0: {
                    Demon d = new Demon();
                    monsters.add(d);
                    break;
                }
                case 1: {
                    Dragon dr = new Dragon();
                    monsters.add(dr);
                    break;
                }
                case 2: {
                    Ghost g = new Ghost();
                    monsters.add(g);
                    break;
                }
                case 3: {
                    Warlock w = new Warlock();
                    monsters.add(w);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    /**
     * Setter for Player
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Takes a random Monster from ArrayList<Monster> monsters and battles the Player using dealDamage()
     * Uses the killedMonster() and killedPlayer() to determine if the monster or the player has died.
     */
    void battle() {

        int randomMonster = RandomClass.getRandomMonsterInt();
        System.out.println("A "+monsters.get(randomMonster).getName()+" apears! Hit enter to continue");
        sc.nextLine();
        while (true) {
            System.out.println("Attack the "+monsters.get(randomMonster).getName()+"!");
            sc.nextLine();
            specialEffects();
            player.dealDamage(monsters.get(randomMonster));         // här ska det fixas!!

            if (killedMonster(randomMonster)) break;
            checkStats(randomMonster);
            System.out.println("The "+monsters.get(randomMonster).getName()+" is attacking!");
            sc.nextLine();
            specialEffects();
            monsters.get(randomMonster).dealDamage(player);

            checkStats(randomMonster);

            killedPlayer();
        }
    }

    /**
     * Determines if player is dead. If dead: Game over and exit system.
     */
    private void killedPlayer() {
        if (!player.notDead()) {
            System.out.println("You died! GAME OVER!");
            System.exit(0);
        }
    }

    /**
     * Determines if Monster is dead. If Monster is dead: Battle is over,
     * Player retrieves Experience points and gold from Monster using
     * getExperiencePoints() and getGold() and returns true;
     * If Monster is alive: return false;
     * @param randomMonster set the Index of ArrayList<Monster> monsters.
     * @return
     */
    private boolean killedMonster(int randomMonster) {
        if (!monsters.get(randomMonster).notDead() ) {
            System.out.println("You've killed it! You recieved "+monsters.get(randomMonster).getExperiencePoints()+" experience points!");
            System.out.println("You collected "+monsters.get(randomMonster).getGold()+" gold from the corps!"+"\n"+"\n");
            monsters.get(randomMonster).giveExperience(player);
            monsters.get(randomMonster).loseGold(player);
            return true;
        }
        return false;
    }

    /**
     * Displays the Name and healt for Monster and Player using getName() and getHp()
     * @param i sets the Index of ArrayList<Monster> monsters.
     */
    void checkStats(int i) {
        System.out.println(player.getName()+": "+player.getHp());
        System.out.println(monsters.get(i).getName()+": "+monsters.get(i).getHp()+"\n");

    }

    /**
     * Simple delay and loop method to add some visual effects.
     */
    void specialEffects() {
        for (int i = 0; i<6; i++) {
            try {
                Thread.sleep(200);
                System.out.print("*");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            try {
                Thread.sleep(100);
                System.out.print("POW!!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        try {
            Thread.sleep(1000);
            System.out.println();
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
