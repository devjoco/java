import java.util.Scanner;

public class SalesStats { 
    public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in);
        final int NUM_DIVS = 6;
        final int NUM_QRTS = 4;
        double[][] sales = new double[NUM_DIVS][NUM_QRTS];

        for(int row=0; row<NUM_DIVS; row++) {
            System.out.printf("Enter quartly sales for Division %d\n", row+1);
            for(int col=0; col<NUM_QRTS; col++) {
                System.out.printf("  Q%d: ", col+1); 
                sales[row][col] = scan.nextDouble();
            }
            System.out.println(); 
        }
    } 
}
