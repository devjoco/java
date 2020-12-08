import java.util.Scanner;

public class Payroll {
    private String name;
    private int    id;
    private double rate;
    private double hours;

    /* Constructor */
    public Payroll(String n, int i) {
        if(n.equals("")) throw new IllegalArgumentException(
                    "Employee name cannot be empty string");
        if(i <= 0) throw new IllegalArgumentException(
                    "Employee ID cannot be zero or negative");
        name = n;
        id = i;
        // rate = 0;
        // hours = 0;
    }

    /* Set employee name, making sure it's valid */
    public void setName(String n)  { 
        if(n.equals("")) throw new IllegalArgumentException(
                    "Employee name cannot be empty string");
        name  = n; 
    }

    /* Set employee ID number, making sure it's valid */
    public void setId(int i) { 
        if(i <= 0) throw new IllegalArgumentException(
                    "Employee ID cannot be zero or negative");
        id = i; 
    }

    /* Set the employee's payrate, making sure rate is valid. */
    public void setRate(double r)  { 
        if(r < 0 || 25 < r) throw new IllegalArgumentException(
                    "Acceptable range for rate: 0-25");
        rate  = r; 
    }

    /* Set employee's hours worked, making sure hours is valid. */
    public void setHours(double h) { 
        if(h < 0 || 84 < h) throw new IllegalArgumentException(
                    "Acceptable range for hours: 0-84");
        hours = h; 
    }

    /* Getters */
    public String getName()     { return name;         }
    public int    getId()       { return id;           }
    public double getRate()     { return rate;         }
    public double getGrossPay() { return rate * hours; }
    public double getHours()    { return hours;        }

    @Override
    public String toString() {
        return "Payroll for " + name + " ID: " + id
            + "\n Rate:  " + rate
            + "\n Hours: " + hours
            + "\n Pay:   " + getGrossPay();
    }

    /* Demo for Payroll class with many opportunities to throw exceptions. */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Payroll pr;
        String name;
        int id;

        /* Get the employee's name           */
        System.out.print("Employee Name: ");
        name = scan.nextLine();

        /* Get the employee's ID             */
        System.out.print("Employee ID:   ");
        id = Integer.parseInt(scan.nextLine());

        /* Create employee and print to user */
        pr = new Payroll(name, id);
        System.out.println(pr);

        /* Change the employee's name        */
        System.out.print("New Employee Name:  ");
        pr.setName(scan.nextLine());

        /* Change the employee's ID          */
        System.out.print("New employee ID:    ");
        pr.setId(Integer.parseInt(scan.nextLine()));

        /* Change the employee's rate        */
        System.out.print("New employee Rate:  ");
        pr.setRate(Integer.parseInt(scan.nextLine()));

        /* Change the employee's hours       */
        System.out.print("New employee Hours: ");
        pr.setHours(Integer.parseInt(scan.nextLine()));

        /* Print the employee to user        */
        System.out.println(pr);
    }
}
