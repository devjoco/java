public class PreferredCustomer extends Customer {
    private double purchases;
    private double discount;

    /** Constructor */
    public PreferredCustomer(String name, String address, String telephone,
            boolean onMailingList, double purchases) {
        super(name, address, telephone, onMailingList);
        this.purchases = purchases;
        updateDiscount();
    }

    /** Getters */
    public double getPurchases() { return purchases; }
    public double getDiscount()  { return discount;  }

    /** Sets the discount on future purchases based on previous purchases */
    public void updateDiscount() {
        discount = purchases >= 2000? 0.10:
                   purchases >= 1500? 0.07:
                   purchases >= 1000? 0.06:
                   purchases >=  500? 0.05: 0.00;
    }

    /** Increases purchases by given amt, updates discount */
    public void makePurchase(double amt) {
        purchases += amt;
        updateDiscount();
    }
}
