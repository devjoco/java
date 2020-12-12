package ch09.account;

public abstract class BankAccount {
    private double balance;
    private double interestRate;
    private double monthlyCharges;
    private int    monthlyDeposits;
    private int    monthlyWithdrawls;

    /** Constructor */
    public BankAccount(double balance, double interestRate) {
        this.balance           = balance;
        this.interestRate      = interestRate;
        this.monthlyCharges    = 0.00;
        this.monthlyDeposits   = 0;
        this.monthlyWithdrawls = 0;
    }

    /** Getters */
    public double getBalance()    { return balance;           }
    public int    getWithdrawls() { return monthlyWithdrawls; }

    /** Add a monthly charge */
    public void addMonthlyCharge(double amt) {
        monthlyCharges += amt;
    }

    /** Deposits given amount, increments deposits count. */
    public void deposit(double amt) { 
        balance += amt; 
        monthlyDeposits++;
    }

    /** Withdraws given amount, increments withdrawls count. */
    public void withdraw(double amt) {
        balance -= amt;
        monthlyWithdrawls++;
    }

    /** Adds monthly interest to balance. */
    public void calcInterest() {
        balance *= 1 + interestRate / 12;
    }

    /** Called once a month. */
    public void monthlyProcess() {
        balance -= monthlyCharges;
        calcInterest();
        monthlyDeposits   = 0;
        monthlyWithdrawls = 0;
    }
}
