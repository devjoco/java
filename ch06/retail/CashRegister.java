public class CashRegister {
    private RetailItem item;
    private int quantity;
    private double TAX = 0.06;

    public CashRegister(RetailItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return item.getRetail() * quantity;
    }

    public double getTax() {
        return getSubtotal() * TAX;
    }

    public double getTotal() {
        return getSubtotal() + getTax();
    }
    
}
