public class ProductionWorker extends Employee {
    public static final double DEFAULT_RATE  = 15.00;
    public static final int    DEFAULT_SHIFT = 1;
    private int    shift;
    private double rate;

    public ProductionWorker(String name, int shift, double rate) {
        super(name);
        this.shift = shift;
        this.rate  = rate;
    }

    public ProductionWorker() {
        this(DEFAULT_NAME, DEFAULT_SHIFT, DEFAULT_RATE);
    }
}
