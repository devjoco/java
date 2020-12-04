import java.util.Random;

/**
 * Dice Simulator -- Programming Challenge 14 p260.
 * Write a program that simulates the rolling of a pair of dice.
 *
 * Write a class named Die that simulates a single die.
 *   - The Die class should have a method named roll that generates a random 
 *     number in the range of 1 through 6 for the value of the die. 
 *   - It should have another method named getValue that returns the die's 
 *     value.
 *     
 * The program should create two instances of the Die class to simulate a pair
 * of dice. 
 *
 * The program should simulate the rolling of the dice and dsiplay 
 * their values.
 */
public class Die {
    private Random r = new Random();
    private int value;

    public Die() {
        roll();
    }

    public int roll() {
        value = r.nextInt(6) + 1;
        return value;
    }

    public int getValue() {
        return value;
    }

}
