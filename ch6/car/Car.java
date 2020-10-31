public class Car {
    // Fields
    private FuelGauge fg;
    private Odometer  od;
    private int MPG = 24;

    // Constructor
    public Car(FuelGauge fg, Odometer od) {
        this.fg = new FuelGauge(fg);
        this.od = new Odometer(od);
    }

    // Prints fuel and mileage
    public void reportGauges(int verbose) {
        switch(verbose) {
            case 0:
                System.out.printf("│Fuel: %2d gal │ Mileage: %,7d │\n", 
                        fg.getFuel(), od.getMileage());
                break;
            case 1:
                System.out.printf("│Fuel: %2d gal │ Mileage: %,7d │\n", 
                        fg.getFuel(), od.getMileage());
                if (fg.getFuel() != 0)
                    System.out.printf("├─────────────┼──────────────────┤\n");
                break;
            case 2:
                System.out.printf("┌─────────────┬──────────────────┐\n");
                System.out.printf("│Fuel: %2d gal │ Mileage: %,7d │\n", 
                        fg.getFuel(), od.getMileage());
                System.out.printf("└─────────────┴──────────────────┘\n");
                break;
            default:
        }
    }

    // If has gas, increase mileage and decrease fuel if necessary.
    public void drive() {
        if(hasFuel()) {
            od.incMileage();
            if (od.getNewMiles() % MPG == 0)
                fg.decFuel();
        } else {
            System.out.println("You can't drive without fuel!");
        }
    }

    // Tells if the car has fuel
    public boolean hasFuel() {
        return fg.getFuel() != 0;
    }
}
