public class ShiftSupervisor extends Employee {
    public static final double DEFAULT_SALARY = 69_400.00;
    public static final double DEFAULT_BONUS  =  4_511.00;
    private double salary;
    private double bonus;

    public ShiftSupervisor(String name, double salary, double bonus) {
        super(name);
        this.salary = salary;
        this.bonus  = bonus;
    }

    public ShiftSupervisor(String name) {
        this(name, DEFAULT_SALARY, DEFAULT_BONUS);
    }

    public double getSalary() { return salary; }
    public double getBonus()  { return bonus;  }

    public void setSalary(double salary) { this.salary = salary; }
    public void setBonus(double bonus)   { this.bonus  = bonus;  }

    @Override
    public String toString() { 
        return super.toString() + " " + salary + " " + bonus;
    }
}
