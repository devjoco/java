package ch09.account;

public class SavingsAccount extends BankAccount {
    private final double MIN_BALANCE    = 25.00;
    private final double MAX_WITHDRAWLS = 4;
    private boolean accountActive; // True if blance >= $25

    /** Determine whether account should be active or inactive */
    private void updateStatus() {
        if(getBalance() < MIN_BALANCE) accountActive = false;
        else                           accountActive = true;
    }

    /** Constructor */
    public SavingsAccount(double balance, double interestRate) {
        super(balance, interestRate);
        updateStatus();
    }


    /** Determine if active before withdrawl, check if still active after. */
    public void withdraw(double amt) {
        if(accountActive) {
            super.withdraw(amt);
            updateStatus();
        }
    }

    /** Deposit amount, then check to see if account is active. */
    public void deposit(double amt) {
        super.deposit(amt);
        updateStatus();
    }

    /** Add fee for exceeding alotted withdrawls. */
    public void monthlyProcess() {
        int withdrawls = getWithdrawls();
        if(withdrawls > MAX_WITHDRAWLS)
            addMonthlyCharge(withdrawls - MAX_WITHDRAWLS);
        super.monthlyProcess();
        updateStatus();
    }
}
