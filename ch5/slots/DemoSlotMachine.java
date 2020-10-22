import java.util.Scanner;

public class DemoSlotMachine {
    final static char    SPIN_CHAR     = 'S',
                         DEPOSIT_CHAR  = 'D',
                         WITHDRAW_CHAR = 'W',
                         ENDGAME_CHAR  = 'E';
    final static String  SPIN_STR      = "Spin",
                         DEPOSIT_STR   = "Deposit",
                         WITHDRAW_STR  = "Withdraw",
                         ENDGAME_STR   = "End Game";

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
        double totalDeposited, totalWinnings, amount;
        char choice;
        
        System.out.print("How much money will you be depositing? ");
        totalDeposited = Double.parseDouble(scan.nextLine());
        machine.deposit(totalDeposited);

        while(machine.getBalance() > 0.00) {
            switch(getUserChoice()) {
                case SPIN_CHAR:
                    System.out.println("\nYou chose to spin!");
                    break;
                case DEPOSIT_CHAR:
                    System.out.print("\nHow much will you be depositing? ");
                    amount = Double.parseDouble(scan.nextLine());
                    machine.deposit(amount);
                    System.out.printf("\nYou're new balance is $%-,#5.2f\n", 
                                      machine.getBalance());
                    break;
                case WITHDRAW_CHAR:
                    System.out.println("\nYou chose to withdraw!");
                    break;
                case ENDGAME_CHAR:
                    System.out.println("\nYou chose to end game :(");
                    break;
                default:
                    System.out.println("\nThat's an invalid choice!");
                    break;
            }
        }
    }
}
