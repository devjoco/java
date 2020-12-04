import java.util.Scanner;
import java.io.*;

public class DemoChargeAccount {
    public static void main(String[] args) throws IOException { 
        Scanner scan    = new Scanner(System.in);
        boolean verbose = false;
        String filename = "";

        for(String arg: args) {
            if (arg.equals("-v")) {
                verbose = true;
            } else if (arg.matches("-f=.*")) {
                filename = arg.substring(arg.indexOf("=")+1);
                System.out.printf("Filename: %s\n", filename);
            }
        }

        ChargeAccount account = filename.equals("")? 
            new ChargeAccount() :
            new ChargeAccount(filename);
                                                    ;
        account.showValids();

        System.out.println("What number are you checking? (-1 to exit)");
        System.out.print("Number: ");
        int num = scan.nextInt();
        while (num != -1) {
            if(account.isValidSeq(num, verbose))
                System.out.println("Sequential Valid");
            else
                System.out.println("Sequential Invalid");

            if(account.isValidBin(num, verbose))
                System.out.println("Binary Valid");
            else
                System.out.println("Binary Invalid");

            System.out.println("\nWhat number are you checking? (-1 to exit)");
            System.out.print("Number: ");
            num = scan.nextInt();
        }
    }
}
