/**
 * Ch2 p116-117 - Programming Challenge 17 
 *
 * Stock Transaction Program
 *
 * - Purchased 1,000 shares @ $32.87, paying broker 2% of purchase price
 * - Sold 1,000 shares @ $33.92, paying broker 2% of sale price
 * 
 * Write program displaying:
 * - Amount paid for stock
 * - Commission paid to broker when buying stock
 * - Amount stock was sold for
 * - Commission paid to broker when selling stock
 * - Profit made after purchase, sale, and commission
 */
public class Stock {
    public static void main(String[] args) {
        final int SHARES = 1000;
        final double PURCHASE_PRICE = 32.87;
        final double SALE_PRICE = 33.92;
        final double COMMISSION = 0.02;

        double amount_paid = SHARES * PURCHASE_PRICE,
               buying_comm = amount_paid * COMMISSION,
               amount_sold = SHARES * SALE_PRICE,
               selling_comm = amount_sold * COMMISSION,
               profit = amount_sold - amount_paid - buying_comm - selling_comm;

        System.out.printf("Paid:   %,10.2f\n", amount_paid);
        System.out.printf("Comm1:  %,10.2f\n", buying_comm);
        System.out.printf("Sold:   %,10.2f\n", amount_sold);
        System.out.printf("Comm2:  %,10.2f\n", selling_comm);
        System.out.printf("Profit: %,10.2f\n", profit);
    }
}
