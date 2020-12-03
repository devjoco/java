public class TeamLeader extends ProductionWorker {
    public static final double DEFAULT_BONUS = 1_000.00 / 12;
    public static final int    DEFAULT_HOURS = 26;
    private double monthlyBonus;
    private int requiredHours;
    private int attendedHours;

    /** Constructs a TeamLeader with given parameters. */
    public TeamLeader(String name, int shift, double rate,
                      double bonus, int req, int att) {
        super(name, shift, rate); 
        this.monthlyBonus = bonus;
        this.requiredHours = req;
        this.attendedHours = att;
    }

    /** Overloaded Constructors */
    public TeamLeader(String name, double bonus, int req, int att) {
        this(name, DEFAULT_SHIFT, DEFAULT_RATE, bonus, req, att);
    }
    public TeamLeader(String name, double bonus, int req) {
        this(name, DEFAULT_SHIFT, DEFAULT_RATE, bonus, req, 0);
    }
    public TeamLeader(String name) {
        this(name, DEFAULT_SHIFT, DEFAULT_RATE,
                DEFAULT_BONUS, DEFAULT_HOURS, 0);
    }

    /** Getters */
    public double getMonthlyBonus() { return monthlyBonus;  }
    public int getRequiredHours()   { return requiredHours; }
    public int getAttendedHours()   { return attendedHours; }

    /** Setters */
    public void setMonthlyBonus(double bonus) { monthlyBonus = bonus; }
    public void setRequiredHours(int hours) { requiredHours = hours;  }
    public void setAttendedHours(int hours) { attendedHours = hours;  }

    @Override
    public String toString() {
        return super.toString() + " " + attendedHours + "/" + requiredHours;
    }

}
