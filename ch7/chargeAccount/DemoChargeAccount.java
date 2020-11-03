import java.util.Scanner;

public class DemoChargeAccount {
    public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in);

        ChargeAccount.showValids();

        System.out.println("What number are you checking? (-1 to exit)");
        System.out.print("Number: ");
        int num = scan.nextInt();
        while (num != -1) {
            if(ChargeAccount.isValidBin(num))
                System.out.println("Valid");
            else
                System.out.println("Invalid");
            System.out.println("\nWhat number are you checking? (-1 to exit)");
            System.out.print("Number: ");
            num = scan.nextInt();
        }
    }
}
