/**
 * Simulates a fuel gauge.
 *
 * Responsibilities:
 *   - Know/report car's current fuel in gallons
 *   - Increment fuel by 1 gallon (Max of 15).
 *   - Decrement fuel by 1 gallon (Min of 0).
 */
public class FuelGauge {
    // Fields
    private int fuel;

    // Constructors
    public FuelGauge(int initFuel) { fuel = initFuel; }
    public FuelGauge(FuelGauge fg) { this(fg.fuel);   }

    // Accessors
    public int getFuel() { return fuel; }

    // Mutators
    public void incFuel() { fuel++; }
    public void decFuel() { fuel--; }
}
