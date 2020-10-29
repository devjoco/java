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

    public void setCop(PoliceOfficer po) { cop = new PoliceOfficer(po); }
    public void setCar(ParkedCar c)      { car = new ParkedCar(c);      }

}
