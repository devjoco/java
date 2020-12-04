import java.util.Scanner;

public class DemoPayroll {
    public static void main(String[] args) {
        Scanner sc     = new Scanner(System.in);
        Payroll myRoll = new Payroll("Devon", 123);

        System.out.print("How many hours did you work this week: ");
        myRoll.setHours(sc.nextDouble());

        System.out.print("What is your pay rate: ");
        myRoll.setRate(sc.nextDouble());

        System.out.printf("%s %d got paid %.2f for %.0f hours at %.2f rate.\n",
                          myRoll.getName(),
                          myRoll.getId(),
                          myRoll.getGrossPay(),
                          myRoll.getHours(),
                          myRoll.getRate()
        );
    }
}
