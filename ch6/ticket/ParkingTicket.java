/**
 * This class simulates a parking ticket.
 *
 * Responsibilities:
 *   - Report the make, model, color, and license of the illegally parked car.
 *   - Report fine amount ($25 for first hour, plus $10 each add'l hour).
 *   - Report the name and badge number of the cop issuing the ticket.
 */
public class ParkingTicket {
    private PoliceOfficer cop;
    private ParkedCar car;
    private int fine;

    public ParkingTicket(PoliceOfficer cop, ParkedCar car, int fine) {
        this.cop = cop;
        this.car = car;
        this.fine = fine;
    }

    public PoliceOfficer getCop()  { return cop; }
    public ParkedCar     getCar()  { return car; }
    public int           getFine() { return fine; }

    public void setCop(PoliceOfficer po) { cop  = new PoliceOfficer(po); }
    public void setCar(ParkedCar c)      { car  = new ParkedCar(c);      }
    public void setFine(int newFine)     { fine = newFine;               }

    /**
     * Prints the make, model, color, and license of the illegally parked car
     * to std.out
     *
     * e.g.:
     * Car Info
     *  Make:    Ford
     *  Model:   Explorer
     *  Color:   Gold
     *  License: A64GPP
     */
    public void reportCarInfo() {
        System.out.println();
        System.out.printf("%8s %s\n", "Make:", car.getMake());
        System.out.printf("%8s %s\n", "Make:", car.getModel());
        System.out.printf("%8s %s\n", "Make:", car.getColor());
        System.out.printf("%8s %s\n", "Make:", car.getLicense());
    }

}
