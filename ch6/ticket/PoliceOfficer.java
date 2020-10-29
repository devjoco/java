/**
 * This class simulates a police officer inspecting parked cars.
 *
 * Responsibilities:
 *   - Know the police officer's name and badge number.
 *   - Examine a ParkedCar object and a ParkingMeter object,
 *     determine whether the car's time has expired.
 *   - Issue a parking ticket if the car's time has expired.
 */
public class PoliceOfficer {
    private String name;
    private int badgeNumber;

    public PoliceOfficer(String name, int badgeNumber) {
        this.name = name;
        this.badgeNumber = badgeNumber;
    }

    public PoliceOfficer(PoliceOfficer po) {
        this(po.name, po.badgeNumber);
    }

    public String getName()        { return name;        }
    public int    getBadgeNumber() { return badgeNumber; }

    public void setName(String n)      { name        = n;  }
    public void setBadgeNumber(int bn) { badgeNumber = bn; }

}
