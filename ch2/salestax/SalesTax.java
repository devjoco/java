import java.util.Scanner;
/**
 * Ch2 p.115 - Programming Challenge 8
 *
 * Write a program that will ask the user to enter the amount of a purchase. 
 * The program should then compute the state and county sales tax.  Assume 
 * the state sales tax is 4 percent and the county sales tax is 2 percent. 
 * The program should display the amount of the purchase, the state sales tax,
 * the county sales tax, the total sales tax, and the total of the sale (which 
 * is the sum of the amount of purchase plus the total sales tax). 
 * Hint: Use the value 0.02 to represent 2 percent, and 0.04 to represent 
 * 4 percent.
 */
public class SalesTax {
    public static void main(String args[]) {
        Scanner k = new Scanner(System.in);
        
        // Ask for purchase price
        System.out.print("Enter purchase price: ");
        double price = Double.parseDouble(k.nextLine());

        // Compute state tax of 4%
        double state = price * 0.04;

        // Compute county tax 2%
        double county = price * 0.02;

        // Display:
        // 1. Purchase Price
        System.out.printf("%-13s % ,7.2f\n", "Price:", price);
        // 2. State Tax
        System.out.printf("%-13s % ,7.2f\n", "State Tax:", state);
        // 3. County Tax
        System.out.printf("%-13s % ,7.2f\n", "County Tax:", county);
        // 4. Total Tax
        System.out.printf("%-13s % ,7.2f\n", "Total Tax:", state + county);
        // 5. Total Sale
        System.out.printf("%-13s % ,7.2f\n", "Total:", price + state + county);
    }
}
