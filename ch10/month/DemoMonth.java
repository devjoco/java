import java.util.Scanner;

public class DemoMonth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char choice = 'C';
        boolean choiceGotten = false;
        Month month = null;

        /* See if user wants to give ordinal or name of month */
        while(!choiceGotten) {
            try { 
                System.out.println("Creating month by:");
                System.out.println("A.) Number");
                System.out.println("B.) Name");
                choice = scan.nextLine().trim().toUpperCase().charAt(0); 
                choiceGotten = true;
            } catch(IndexOutOfBoundsException e) {
            }
        }

        /* Allow user to create month via chosen constructor */
        if(choice == 'A') {
            System.out.println("What is the ordinal of the month?");
            System.out.print("Ordinal: ");
            month = new Month(scan.nextInt());
        } else if(choice == 'B') {
            System.out.println("What is the name of the month?");
            System.out.print("Name: ");
            month = new Month(scan.nextLine().trim());
        } else {
            System.out.println("You didn't choose A or B!!");
            System.exit(0);
        }

        /* Print out the month created */
        System.out.println("Your month is: " + month);
    }
}
