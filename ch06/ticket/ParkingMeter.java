/**
 * This class simulates a parking meter.
 *
 * Responsibilities:
 *   - Know the purchased number of parking time minutes.
 */
public class ParkingMeter {
    private int minutes;

    public ParkingMeter(int min) {
        minutes = min;
    }

    public int getMinutes() { return minutes; }

    public void setMinutes(int newMin) { minutes = newMin; }
}
