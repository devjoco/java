import java.text.DecimalFormat;

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
     *
     * Fine
     *  $xxx
     *
     * Issuing Officer
     *  Terrance O'Connor
     *  Badge #744
     *  
     */
    public void reportTicket() {
        DecimalFormat money = new DecimalFormat("¤#,##0.00");
        DecimalFormat badge = new DecimalFormat("'#000");

        // Car info
        System.out.println("\nCar Info");
        System.out.printf("\t%8s %s\n", "Make:", car.getMake());
        System.out.printf("\t%8s %s\n", "Make:", car.getModel());
        System.out.printf("\t%8s %s\n", "Make:", car.getColor());
        System.out.printf("\t%8s %s\n", "Make:", car.getLicense());

        // Fine info
        System.out.println("Fine");
        System.out.printf("\t%s", money.format(fine));

        // POlice Officer info
        System.out.println("Issuing Officer");
        System.out.printf("\t%s", cop.getName());
        System.out.printf("\t%s", badge.format(cop.getBadgeNumber()));
    }


}
