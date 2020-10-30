import java.text.DecimalFormat;

/**
 * This class simulates a parking ticket.
 *
 * Responsibilities:
 *   - Report the make, model, color, and plate of the illegally parked car.
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
     * Prints the make, model, color, and plate of the illegally parked car
     * to std.out
     *
     * e.g.:
     * ┌────────────────────────┐
     * │Car Info                │
     * │  Make:    Ford         │
     * │  Model:   Explorer     │
     * │  Color:   Gold         │
     * │  Plate:   A64GPP       │
     * ├────────────────────────┤
     * │Fine                    │
     * │  $xxx                  │
     * ├────────────────────────┤
     * │Issuing Officer         │
     * │  #744 Terrance O'Connor│
     * └────────────────────────┘
     */
    public void reportTicket() {
        String money = new DecimalFormat("¤#,##0.00").format(fine);
        String badge = new DecimalFormat("'#'000").format(cop.getBadgeNumber());

        System.out.printf("\n");
        System.out.printf("┌────────────────────────┐\n");
        System.out.printf("│%s%-9s%-15s│\n", "", "Car Info", "");
        System.out.printf("│%s%-9s%-13s│\n", "  ", "Make:",  car.getMake());
        System.out.printf("│%s%-9s%-13s│\n", "  ", "Model:", car.getModel());
        System.out.printf("│%s%-9s%-13s│\n", "  ", "Color:", car.getColor());
        System.out.printf("│%s%-9s%-13s│\n", "  ", "Plate:", car.getPlate());
        System.out.printf("├────────────────────────┤\n");
        System.out.printf("│%s%-9s%-15s│\n", "", "Fine", "");
        System.out.printf("│%s%-9s%-13s│\n", "  ", money,  "");
        System.out.printf("├────────────────────────┤\n");
        System.out.printf("│%s%-9s%-15s│\n", "", "Officer", "");
        System.out.printf("│%s%-5s%-17s│\n", "  ", badge, cop.getName());
        System.out.printf("└────────────────────────┘\n");
    }


}
