import java.util.Scanner;

public class DemoSlotMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SlotMachine machine = new SlotMachine();
        double totalDeposited, totalWinnings;
        char choice;
        
        System.out.println("How much money will you be depositing?");
        totalDeposited = Double.parseDouble(scan.nextLine());
        machine.deposit(totalDeposited);

        while(machine.getBalance() > 0.00) {
            // User can spin, deposit, withdraw, end game
            System.out.println("What do you want to do:");
            System.out.println("(S) Spin");
            System.out.println("(D) Deposit Money");
            System.out.println("(W) Withdraw Money");
            System.out.println("(E) End Game");
            choice = scan.nextLine().toLowerCase().charAt(0);
            
        }


    }
}
