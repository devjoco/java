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
    final private String[] items = {"Cherries", "Oranges", "Plums",
                                    "Bells",    "Melons",  "Bars"};
    private double balance;

    public SlotMachine()             { balance = 0;    }
    public SlotMachine(double amt)   { balance = amt;  }
    public double getBalance()       { return balance; }
    public void deposit(double amt)  { balance += amt; }
    public void withdraw(double amt) { balance -= amt; }
}
