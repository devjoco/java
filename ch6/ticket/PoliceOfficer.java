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

    public boolean timeExpired(ParkedCar car, ParkingMeter meter) {
        return car.getMinutes() > meter.getMinutes();
    }

    public ParkingTicket issueTicket(ParkedCar car, ParkingMeter meter) {
        int minExpired = car.getMinutes() - meter.getMinutes();
        int fine = 25 + 10 * (getHoursCharged(minExpired) - 1);
        return new ParkingTicket(new PoliceOfficer(this), 
                                 new ParkedCar(car), 
                                 fine);
    }

    public ParkingTicket issueIfExpired(ParkedCar car, ParkingMeter meter) {
        ParkingTicket ticket = null;
        if(car.getMinutes() > meter.getMinutes()) {
            int hours = (int) // Continued on next line
                Math.ceil((car.getMinutes() - meter.getMinutes()) / 60.0);
            int amt = 25 + 10 * (hours - 1);
            ticket = new ParkingTicket(new PoliceOfficer(this), 
                                       new ParkedCar(car), 
                                       amt);
        }
        return ticket;
    }

    private int getHoursCharged(int minExpired) {
        return (int) Math.ceil(minExpired / 60.0);
    }

}
