/**
 * Collaboration of P{oliceOfficer, ark{edCar, ing{Meter, Ticket}}} classes.
 *
 * Will:
 *   - Create 3 different PoliceOfficer instances.
 *   - Create 5 ParkedCar/ParkingMeter instance combos, 3 w/ expired time.
 *   - Have P.O. #1 examine 1 unexpired, and 2 expired car/meter combos.
 *   - Have P.O. #2 examine 1 unexpired, and 1 expired car/meter combos.
 *   - Have P.O. #3 examine 1 expired car/meter combos.
 *   - Have each P.O. issue a ticket for each expired car, reporting info.
 */
public class DemoTicket {
    public static void main(String[] args) {
        ParkingTicket[] pts = new ParkingTicket[5];

        PoliceOfficer po1 = new PoliceOfficer("Terrance O'Connor", 744);
        PoliceOfficer po2 = new PoliceOfficer("Dylan O'Connor", 68);
        PoliceOfficer po3 = new PoliceOfficer("Samantha O'Connor", 69);

        ParkedCar pc1 = new ParkedCar("Toyota", "Rav4", "White", "93CFG2", 35);
        ParkedCar pc2 = new ParkedCar("Ford", "Expl.", "Gold", "A64GPP", 60*3);
        ParkedCar pc3 = new ParkedCar("Jeep", "Wrng.", "Red", "B39ZC1", 61*5);
        ParkedCar pc4 = new ParkedCar("Honda", "CRV", "Blue", "81DDMB", 82);
        ParkedCar pc5 = new ParkedCar("Saab", "9-3", "Black", "J3D8V9", 67);

        ParkingMeter pm1 = new ParkingMeter(30);
        ParkingMeter pm2 = new ParkingMeter(15);
        ParkingMeter pm3 = new ParkingMeter(25);
        ParkingMeter pm4 = new ParkingMeter(90);
        ParkingMeter pm5 = new ParkingMeter(75);

        pts[0] = po1.issueIfExpired(pc1, pm1);
        pts[1] = po2.issueIfExpired(pc2, pm2);
        pts[2] = po3.issueIfExpired(pc3, pm3);
        pts[3] = po1.issueIfExpired(pc4, pm4);
        pts[4] = po2.issueIfExpired(pc5, pm5);

        for(ParkingTicket ticket : pts)
            if(ticket != null)
                ticket.reportTicket();
    }
}
