public class Payroll {
    private String name;
    private int    id;
    private double rate;
    private double hours;

    public Payroll(String n, int i) {
        name = n;
        id = i;
    }

    public void setName(String n)  { name  = n; }
    public void setId(int i)       { id    = i; }
    public void setRate(double r)  { rate  = r; }
    public void setHours(double h) { hours = h; }

    public String getName()     { return name;         }
    public int    getId()       { return id;           }
    public double getRate()     { return rate;         }
    public double getHours()    { return hours;        }
    public double getGrossPay() { return rate * hours; }

}
