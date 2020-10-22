import java.util.Scanner;

public class DemoSlotMachine {
    public static void main(String[] args) {
        final char  SPIN_CHAR     = 's',
                    DEPOSIT_CHAR  = 'd',
                    WITHDRAW_CHAR = 'w',
                    ENDGAME_CHAR  = 'e';
        Scanner     scan          = new Scanner(System.in);
        SlotMachine machine       = new SlotMachine();
        double totalDeposited, totalWinnings;
        char choice;
        
        System.out.println("How much money will you be depositing?");
        totalDeposited = Double.parseDouble(scan.nextLine());
        machine.deposit(totalDeposited);

        while(machine.getBalance() > 0.00) {
            System.out.println("What do you want to do:");
            System.out.printf("(%c) Spin\n", SPIN_CHAR);
            System.out.printf("(%c) Deposit Money\n", DEPOSIT_CHAR);
            System.out.printf("(%c) Withdraw Money\n", WITHDRAW_CHAR);
            System.out.printf("(%c) End Game\n", ENDGAME_CHAR);
            choice = scan.nextLine().toLowerCase().charAt(0);

            switch(choice) {
                case SPIN_CHAR:
                    System.out.println("You chose to spin!");
                    break;
                case DEPOSIT_CHAR:
                    System.out.println("You chose to deposit!");
                    break;
                case WITHDRAW_CHAR:
                    System.out.println("You chose to withdraw!");
                    break;
                case ENDGAME_CHAR:
                    System.out.println("You chose to end game :(");
                    break;
                default:
                    System.out.println("That's an invalid choice!");
                    break;
            }
        }
    }
}
