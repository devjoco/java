public class Customer extends Person {
    private static int numCustomers = 0;
    private int number;
    private boolean onMailingList;

    /** Constructor */
    public Customer(String name, String address, String telephone,
            boolean onMailingList) {
        super(name, address, telephone);
        this.onMailingList = onMailingList;
        setNumber();
    }

    /** Setters */
    public void addToMailingList()      { onMailingList = true;  }
    public void removeFromMailingList() { onMailingList = false; }

    /** Assigns the customer a unique number. */
    public void setNumber() { 
        number = numCustomers;
        numCustomers++;
    }

    /** Getters */
    public int     getNumber()       { return number;        }
    public boolean isOnMailingList() { return onMailingList; }
}
