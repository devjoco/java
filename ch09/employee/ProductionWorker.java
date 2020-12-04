public class ProductionWorker extends Employee {
    public static final double DEFAULT_RATE  = 15.00;
    public static final int    DEFAULT_SHIFT = 1;
    private             int    shift;
    private             double rate;

    /** Constructs a ProductionWorker with given name, shift, rate */
    public ProductionWorker(String name, int shift, double rate) {
        super(name);
        this.shift = shift;
        this.rate  = rate;
    }

    /** Overlooaded Constructors */
    public ProductionWorker() {
        this(DEFAULT_NAME, DEFAULT_SHIFT, DEFAULT_RATE);
    }
    public ProductionWorker(String name) {
        this(name, DEFAULT_SHIFT, DEFAULT_RATE);
    }

    /** Getters */
    public double getRate()  { return rate; }
    public String getShift() {
        return shift == 1? "Day": shift == 2? "Night": "Neither";
    }

    /** Setters */
    public void setShift(int shift)  { this.shift = shift; }
    public void setRate(double rate) { this.rate  = rate;  }
    
    @Override
    public String toString() {
        return super.toString() + " " + this.getShift() + " " + rate;
    }
}
