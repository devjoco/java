import java.util.Scanner;

/**
 * Simulates a car driving until running out of gas.
 *
 * Responsibilities:
 *   - Create instance of FuelGauge and Odometer
 *   - Have user determine how much gas to put in, up to 15 Gallons
 *   - Simulate driving car by incrementing Odometer until fuel runs out
 *   - Print car mileage and fuel amount during each iteration of loop
 *
 * Usage:
 *   java DemoCar [-v] 
 */
public class DemoCar {
    public static void main(String[] args) {
        int verbose = 0;
        if (args.length > 0) 
            if (args[0].equals("-v")) 
                verbose += 1;
            else if (args[0].equals("-vv"))
                verbose += 2;

        Scanner scan = new Scanner(System.in);

        System.out.println("How much fuel are you putting in your car?");
        System.out.printf("Gallons: ");
        int gallons = scan.nextInt();
        while(gallons < 0 || 15 < gallons) {
            if(gallons < 0)
                System.out.println("\nGallons cannot be negative.\n");
            if(gallons > 15)
                System.out.println("\nYour car can hold up to 15 gallons.\n");
            System.out.printf("Gallons: ");
            gallons = scan.nextInt();
        }
        FuelGauge fg = new FuelGauge(gallons);

        System.out.println("What is the current mileage on your car?");
        System.out.printf("Miles: ");
        int miles = scan.nextInt();
        while(miles < 0) {
            System.out.println("Enter a valid, positive integer for miles.");
            System.out.printf("Miles: ");
            miles = scan.nextInt();
        }
        Odometer od = new Odometer(miles % 1000000);

        Car car = new Car(fg, od);

        if (verbose != 2)
            System.out.printf("┌─────────────┬──────────────────┐\n");
        car.reportGauges(verbose);
        while(car.hasFuel()) {
            car.drive();
            car.reportGauges(verbose);
        }
        if (verbose != 2)
            System.out.printf("└─────────────┴──────────────────┘\n");
    }
}
