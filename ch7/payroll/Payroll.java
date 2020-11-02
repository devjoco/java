import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Payroll class.
 * Asks user for each employee's hours and wages, calculates gross pay.
 * Bounds checks to prevent negative numbers, payRate must be above $6.00.
 */
public class Payroll {
    private int[] employeeId = {5658845, 4520125, 7895122, 
                       8777541, 8451277, 1302850, 7580489};
    private int[] hours;
    private double[] payRate, 
                     wages;

    
    public static void main(String[] args) {
        Scanner       scan  = new Scanner(System.in);
        DecimalFormat money = new DecimalFormat("¤#,##0.00");
        Payroll       roll  = new Payroll();

        System.out.println("Enter each employee's hours and pay rate.");
        ids = roll.getIds();                    // TODO

        for(int i=0; i<ids.length; i++) {
            System.out.printf("\nEmployee #%d\n", ids[i]);
            System.out.printf("Hours: ");
            roll.setHours(i, scan.nextInt());   // TODO 
            System.out.printf("Rate: $");
            roll.setRate(i, scan.nextInt());    // TODO 
            roll.calcWages(i);                  // TODO
        }

        System.out.printf("┌───────────────────┐\n");
        System.out.printf("│ %-7s │ %-7s │\n", "Emp. ID", "Wages");
        for(int i=0; i<ids.length; i++)
            System.out.printf("│ %-7s │ %-7s │\n", 
                    roll.getId(i), roll.getWages(i));
        System.out.printf("└───────────────────┘\n");
    }
}
