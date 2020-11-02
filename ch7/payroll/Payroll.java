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
    private int[]    hours   = new int[employeeId.length];
    private double[] payRate = new double[employeeId.length],
                     wages   = new double[employeeId.length];

    public int[]  getIds()          { return employeeId;   }
    public double getWages(int idx) { return wages[idx];   }
    public int    getHours(int idx) { return hours[idx];   }
    public double getRate(int idx)  { return payRate[idx]; }

    public void setHours(int idx, int hours)  { this.hours[idx] = hours; }
    public void setRate(int idx, double rate) { payRate[idx]    = rate;  }

    public void calcWages(int idx) {
        wages[idx] = hours[idx] * payRate[idx];
    }

    
    public static void main(String[] args) {
        Scanner       scan  = new Scanner(System.in);
        DecimalFormat money = new DecimalFormat("¤#,##0.00");
        Payroll       roll  = new Payroll();
        int[]         ids   = roll.getIds();

        System.out.println("Enter each employee's hours and pay rate.");

        for(int i=0; i<ids.length; i++) {
            System.out.printf("\nEmployee #%d\n", ids[i]);
            System.out.printf("Hours: ");
            roll.setHours(i, scan.nextInt());
            while(roll.getHours(i) < 0) {
                System.out.println("\nHours cannot be negative!");
                System.out.printf("Hours: ");
                roll.setHours(i, scan.nextInt());
            }

            System.out.printf("Rate: $");
            roll.setRate(i, scan.nextDouble());
            while(roll.getRate(i) < 6.00) {
                System.out.println("\nRate cannot be less than $6.00!");
                System.out.printf("Rate: ");
                roll.setRate(i, scan.nextDouble());
            }

            roll.calcWages(i);
        }

        System.out.printf("┌─────────┬─────────┐\n");
        System.out.printf("│ %-7s │ %-7s │\n", "Emp. ID", "Wages");
        System.out.printf("├─────────┼─────────┤\n");
        for(int i=0; i<ids.length; i++)
            System.out.printf("│ %7s │ %7s │\n", 
                    ids[i], money.format(roll.getWages(i)));
        System.out.printf("└─────────┴─────────┘\n");
    }
}
