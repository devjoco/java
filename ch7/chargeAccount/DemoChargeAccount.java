import java.util.Scanner;

public class DemoChargeAccount {
    public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in);

        ChargeAccount.showValids();

        System.out.println("What number are you looking for? (-1 to exit)");
        System.out.print("Number: ");
        int num = scan.nextInt();
        while (num != -1) {
            if(ChargeAccount.isValidSeq(num)) {
                System.out.println("That's a valid number!");
            } else {
                System.out.println("Not a valid number!!!!");
            }
        System.out.println("\nWhat number are you looking for? (-1 to exit)");
        System.out.print("Number: ");
        num = scan.nextInt();
        }
    }
}
