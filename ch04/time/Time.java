import java.util.Scanner;

public class Time {
    public static void main(String[] args) {
        final int SEC_IN_MIN = 60;
        final int SEC_IN_HR  = 3600;
        final int SEC_IN_DAY = 86400;

        System.out.print("Enter a number of seconds: ");
        int seconds = (new Scanner(System.in)).nextInt();

        
        // Display number of min in given seconds if greater than 60
        if (seconds >= SEC_IN_MIN)
            System.out.printf("That's %d minutes!\n", seconds / SEC_IN_MIN);
        
        // Display number of hours in given seconds if greater than 3600
        if (seconds >= SEC_IN_HR)
            System.out.printf("That's %d hours!\n", seconds / SEC_IN_HR);

        // Display number of days in given seconds if greater than 86400
        if (seconds >= SEC_IN_DAY)
            System.out.printf("That's %d days!\n", seconds / SEC_IN_DAY);
    }
}
