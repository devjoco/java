/**
 * Simulates a car's odometer.
 *
 * Responsibilities:
 *   - Know/report the car's current mileage.
 *   - Increment current mileage by 1 mile (Resets to 0 after 999,999).
 *   - Decrease fuel in FuelGauge for every 24 miles traveled.
 */
public class Odometer {
    // Fields
    private int mileage;
    private int newMiles = 0;

    // Constructors
    public Odometer(int initMileage) { mileage = initMileage; }
    public Odometer(Odometer od)     { this(od.mileage);      }

    // Accessors
    public int getMileage()  { return mileage; }
    public int getNewMiles() { return newMiles; }

    // Mutators
    public void incMileage() { 
        mileage = (mileage == 999999)? 0 : ++mileage;
        newMiles++;
    }
}
