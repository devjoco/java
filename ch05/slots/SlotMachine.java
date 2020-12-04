import java.util.Random;
import java.text.DecimalFormat;

/**
 * Slot Machine Simulation -- Programming Challenge 21 p332
 *
 *   - balance: double (Money deposited into the machine)
 *   - items: An array of possible words that can pop up on machine
 *
 *   + SlotMachine()           : void   (Creates a slotmachine w/ $0 blanace)
 *   + SlotMachine(amt: double): void   (SlotMachine with an initial balance)
 *   + spin(wager: double)     : void   (Simulates a spin)
 *   + deposit(amount: double) : void   (Adds money to the machine's balance)
 *   + withdraw(amount: double): void   (Removes money from machine's balance)
 *   + getBalance()            : double (Returns amount of money in machine)
 */
public class SlotMachine {
    public static DecimalFormat moneyFormat = new DecimalFormat("#,##0.00");
    public static String[] items = {"Cherries", "Oranges", "Plums",
                                    "Bells",    "Melons",  "Bars"};
    private double balance;

    public SlotMachine()             { balance = 0;    }
    public SlotMachine(double amt)   { balance = amt;  }
    public double getBalance()       { return balance; }
    public void deposit(double amt)  { balance += amt; }
    public void withdraw(double amt) { balance -= amt; }

    /**
     * Randomly selects three items.
     * Wager must be more than $0.00, less than balance.
     * 0 matches -- user wins $0
     * 2 matches -- user wins 2x the wager
     * 3 matches -- user wins 3x the wager
     */
    public int[] spin(double wager) {
        int   matching;
        int[] itemArray = {0, 0, 0};
        double winnings;
        if(wager < 0 || balance < wager) {
            System.out.printf("You only have %s to wager!", 
                    moneyFormat.format(balance));
            return itemArray;
        }
        Random rng = new Random();
        balance -= wager;
        itemArray[0] = rng.nextInt(6);
        itemArray[1] = rng.nextInt(6);
        itemArray[2] = rng.nextInt(6);
        matching = getMatching(itemArray);
        winnings = wager * matching;
        balance += winnings;
        return itemArray;
    }

    public static int getMatching(int[] items) {
        return (items[0] == items[1] && items[0] == items[2]) ? 3 :
               (items[0] == items[1] ||  
                items[0] == items[2] ||
                items[1] == items[2])                         ? 2 : 0;
    }
}
