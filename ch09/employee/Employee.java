import java.util.Date;
import java.text.DecimalFormat;

public class Employee {
    public static final String DEFAULT_NAME = "John Doe";
    private static int employeeCount = 0;
    private String name;
    private String number;   // Format: ###-<alpha>
    private Date   hireDate;

    /** Creates a new employee with given name, date.
     * Assigns a unique employee number. */
    public Employee(String name, Date date) {
        this.name     = name;
        this.number   = getEmployeeNumber(name);
        this.hireDate = date;
        employeeCount++;
    }

    /** Overloaded constructors */
    public Employee(String name) { this(name         , new Date()); }
    public Employee()            { this(DEFAULT_NAME , new Date()); }

    /** Provides a unique employee number in form ###-<alpha>.
     * Constructed using:
     *   - The current number of employees created.
     *   - A hyphen '-'
     *   - The first letter of the employees name.
     */
    private String getEmployeeNumber(String name) {
        DecimalFormat fmt = new DecimalFormat("000");
        String number = fmt.format(employeeCount);
        char   letter = name.trim().toUpperCase().charAt(0);
        return number + '-' + letter;
    }

    /** Getters */
    public String getName()     { return name;     }
    public String getNumber()   { return number;   }
    public Date   getHireDate() { return hireDate; }

    /** Setters */
    public void setName(String name)   { this.name = name;     }
    public void setHireDate(Date date) { this.hireDate = date; }

    @Override
    public String toString() {
        return number+" "+name;
    }
}
