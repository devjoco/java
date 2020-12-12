import java.util.Scanner;
import ch06.retail.RetailItem;

public class DemoRetailItem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       
        System.out.println("Enter item description and pricing.");
        System.out.print("Description: "); 
        String desc = scan.nextLine();

        System.out.print("Wholesale Price: "); 
        double wholesale = scan.nextDouble();

        System.out.print("Retail Price   : "); 
        double retail = scan.nextDouble();

        RetailItem ri = new RetailItem(desc, wholesale, retail);
        System.out.println(ri);
    }
}
