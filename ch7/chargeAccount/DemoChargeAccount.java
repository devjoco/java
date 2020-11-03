import java.util.Scanner;
import java.io.*;

public class DemoChargeAccount {
    public static void main(String[] args) { 
        Scanner scan    = new Scanner(System.in);
        boolean verbose = false;
        InputStream in  = System.in;

        for(String arg: args) {
            if (arg.equals("-v")) {
                verbose = true;
            }
            if (arg.matches("-f=.*")) {
                String filename = arg.substring(arg.indexOf("=")+1);
                System.out.printf("Filename: %s\n", filename);
            }
        }

        if(args.length > 0 && args[0].equals("-v")) 
            verbose = true;

        ChargeAccount.showValids();

        System.out.println("What number are you checking? (-1 to exit)");
        System.out.print("Number: ");
        int num = scan.nextInt();
        while (num != -1) {
            if(ChargeAccount.isValidSeq(num, verbose))
                System.out.println("Sequential Valid");
            else
                System.out.println("Sequential Invalid");

            if(ChargeAccount.isValidBin(num, verbose))
                System.out.println("Binary Valid");
            else
                System.out.println("Binary Invalid");

            System.out.println("\nWhat number are you checking? (-1 to exit)");
            System.out.print("Number: ");
            num = scan.nextInt();
        }
    }
}
