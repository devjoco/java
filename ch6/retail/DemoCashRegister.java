import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.*;

public class DemoCashRegister {
    public static void main(String[] args) {
        FileWriter  file   = new FileWriter("Receipts.txt", true);
        PrintWriter writer = new PrintWriter(file);
        DecimalFormat cash = new DecimalFormat("¤#,##0.00");
        Scanner scan = new Scanner(System.in);
        CashRegister reg;
        int quantity;
        double retail;
        String desc;

        // Ask user what is being bought
        System.out.println("\nWhat are you purchasing?");
        System.out.print("Description: ");
        desc = scan.nextLine();
        
        // Ask user for the retail price 
        System.out.println("\nHow much does this cost?");
        System.out.print("Price: $");
        retail = scan.nextDouble();
        
        // Ask user how many items are being bought
        System.out.println("\nHow many are you buying?");
        System.out.print("Quantity: ");
        quantity = scan.nextInt();

        // Create CashRegister from user input
        reg = new CashRegister(new RetailItem(desc, retail), quantity);

        // Display subtotal, sales tax, total
        System.out.println();
        System.out.printf("%8s: %8s\n", "Sub", cash.format(reg.getSubtotal()));
        System.out.printf("%8s: %8s\n", "Tax", cash.format(reg.getTax()));
        System.out.printf("%8s: %8s\n", "Total", cash.format(reg.getTotal()));
    }
}
