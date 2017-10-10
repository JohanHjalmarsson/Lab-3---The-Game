package johanhjalmarsson.com.Main;
import java.util.Random;


public final class RandomClass {

    static Random random1 = new Random();

    /**
     * Returns a random int between 1-10
     * @return random int between 1-10
     */
    public static int getRandomLow() {
        return 1+ random1.nextInt(10);
    }

    /**
     * Returns a random int between 5-10
     * @return random int between 5-10
     */
    public static int getRandomHigh() {
        return 5+ random1.nextInt(10);
    }
    /**
     * Returns a random int between 0-2
     * @return random int between 0-2
     */
    public static int getRandomMonsterInt() {
        return random1.nextInt(2);
    }
    /**
     * Returns a random int between 0-9
     * @return random int between 0-9
     */
    public static int getRandomTenPercent() {
        return random1.nextInt(9);
    }
    /**
     * Returns a random int between 0 and int bound
     * @return random int between 0 and int bound
     */
    public static int getRandom(int bound) {
        return random1.nextInt(bound);
    }

    private RandomClass() {

    }
}
