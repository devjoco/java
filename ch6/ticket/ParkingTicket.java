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
     * ┌────────────────────────┐
     * │Car Info                │
     * │  Make:    Ford         │
     * │  Model:   Explorer     │
     * │  Color:   Gold         │
     * │  License: A64GPP       │
     * ├────────────────────────┤
     * │Fine                    │
     * │  $xxx                  │
     * ├────────────────────────┤
     * │Issuing Officer         │
     * │  #744 Terrance O'Connor│
     * └────────────────────────┘
     */
    public void reportTicket() {
        DecimalFormat money = new DecimalFormat("¤#,##0.00");
        DecimalFormat badge = new DecimalFormat("'#'000");

        // Car info
        System.out.printf("\nCar Info\n");
        System.out.printf("  %-8s %s\n", "Make:", car.getMake());
        System.out.printf("  %-8s %s\n", "Model:", car.getModel());
        System.out.printf("  %-8s %s\n", "Color:", car.getColor());
        System.out.printf("  %-8s %s\n", "License:", car.getLicense());

        // Fine info
        System.out.printf("Fine\n");
        System.out.printf("  %s\n", money.format(fine));

        // POlice Officer info
        System.out.printf("Issuing Officer\n");
        System.out.printf("  %s %s\n", 
                badge.format(cop.getBadgeNumber()),
                cop.getName());
    }


}
