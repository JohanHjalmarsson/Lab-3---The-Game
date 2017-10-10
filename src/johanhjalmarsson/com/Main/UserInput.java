package johanhjalmarsson.com.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class UserInput {
    private static Scanner sc = new Scanner(System.in);


    /**
     * Returns int input from user with Scanner. Try and catch for other input than int
     * @return int Scanner nextInt()
     */
    public static int input() {
            int input = 0;
            boolean inValid;
            do {
                inValid = false;
                try {
                    input = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please use numbers");
                    inValid = true;
                    sc.next();
                }
            } while (inValid);
            return input;
        }
}
