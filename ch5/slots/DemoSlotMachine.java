import java.util.Scanner;
import java.text.DecimalFormat;

public class DemoSlotMachine {
    final static private DecimalFormat moneyFormat = 
        new DecimalFormat("#,##0.00");
    final static char    SPIN_CHAR     = 'S',
                         DEPOSIT_CHAR  = 'D',
                         WITHDRAW_CHAR = 'W',
                         ENDGAME_CHAR  = 'E';
    final static String  SPIN_STR      = "Spin",
                         DEPOSIT_STR   = "Deposit",
                         WITHDRAW_STR  = "Withdraw",
                         ENDGAME_STR   = "End Game";

    private static void printBalance(double bal) {
        System.out.printf("\nYou're balance is $%s\n", 
                moneyFormat.format(bal));
    }

    public static char getUserChoice() {
        Scanner scan = new Scanner(System.in);
        System.out.printf("\n(%c) %-12s (%c) %-12s\n",
                SPIN_CHAR, SPIN_STR, DEPOSIT_CHAR, DEPOSIT_STR);
        System.out.printf("(%c) %-12s (%c) %-12s\n",
                WITHDRAW_CHAR, WITHDRAW_STR, ENDGAME_CHAR, ENDGAME_STR);
        System.out.print("What do you want to do: ");
        return scan.nextLine().toUpperCase().charAt(0);
    }

    public static void main(String[] args) {
        Scanner     scan          = new Scanner(System.in);
        SlotMachine machine       = new SlotMachine();
        double totalDeposited = 0,
               totalWithdrawn = 0,
               totalWinnings  = 0,
               amount;
        char choice;
        
        System.out.print("How much money will you be depositing? ");
        totalDeposited = Double.parseDouble(scan.nextLine());
        machine.deposit(totalDeposited);

        while(machine.getBalance() > 0.00) {
            switch(getUserChoice()) {
                case SPIN_CHAR:
                    System.out.println("\nHow much are you wagering? ");
                    amount = scan.nextDouble();
                    amount = machine.spin(amount);
                    printBalance(machine.getBalance());
                    break;

                case DEPOSIT_CHAR:
                    System.out.print("\nHow much will you be depositing? ");
                    amount = Double.parseDouble(scan.nextLine());
                    totalDeposited += amount;
                    machine.deposit(amount);
                    printBalance(machine.getBalance());
                    break;

                case WITHDRAW_CHAR:
                    System.out.println("\nHow much will you be withdrawing? ");
                    amount = Double.parseDouble(scan.nextLine());
                    totalWithdrawn += amount;
                    machine.withdraw(amount);
                    printBalance(machine.getBalance());
                    break;

                case ENDGAME_CHAR:
                    System.out.println("\nYou chose to end game :(");
                    totalWithdrawn += machine.getBalance();
                    machine.withdraw(machine.getBalance());
                    break;

                default:
                    System.out.println("\nThat's an invalid choice!");
                    break;
            }
        }
    }
}
