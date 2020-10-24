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
    final private DecimalFormat moneyFormat = new DecimalFormat("#,##0.00");
    final private String[] items = {"Cherries", "Oranges", "Plums",
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
    public double spin(double wager) {
        int item1, item2, item3, matching;
        double winnings;
        if(wager < 0 || balance < wager) {
            System.out.printf("You only have %s to wager!", 
                    moneyFormat.format(balance));
            return 0.00;
        }
        Random rng = new Random();
        balance -= wager;
        item1 = rng.nextInt(6) + 1;
        item2 = rng.nextInt(6) + 1;
        item3 = rng.nextInt(6) + 1;
        matching = getMatching(item1, item2, item3);
        winnings = wager * matching;
        balance += winnings;
        if (matching == 0) {
            System.out.printf("You got no matching items!");
        } else {
            System.out.printf("You got %d matching items! You win $%s",
                              matching, 
                              moneyFormat.format(winnings));
        }
        return winnings;
    }

    private int getMatching(int item1, int item2, int item3) {
        return (item1 == item2 && item1 == item3)                   ? 3 :
               (item1 == item2 || item1 == item3 || item2 == item3) ? 2 :
                                                                      0;
    }
}
