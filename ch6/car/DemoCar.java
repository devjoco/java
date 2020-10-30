import java.util.Scanner;

/**
 * Simulates a car driving until running out of gas.
 *
 * Responsibilities:
 *   - Create instance of FuelGauge and Odometer
 *   - Have user determine how much gas to put in, up to 15 Gallons
 *   - Simulate driving car by incrementing Odometer until fuel runs out
 *   - Print car mileage and fuel amount during each iteration of loop
 */
public class DemoCar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("How much fuel are you putting in your car?");
        System.out.printf("Gallons: ");
        FuelGauge fg = new FuelGauge(scan.nextInt());

        System.out.println("What is the current mileage on your car?");
        System.out.printf("Miles: ");
        Odometer  od = new Odometer(scan.nextInt());

        Car car = new Car(fg, od);

        while(car.hasFuel()) {
            car.reportGauges();
            car.drive();
        }
    }
}
