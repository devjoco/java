import java.util.Scanner;

/**
 * Quarterly Sales Statistics.
 * Write a program that lets the user enter four quarterly sales figures for
 * six divisions of a company. The figures should be stored in a 
 * two-dimensional array. Once the figures are entered, the program should 
 * display the following data for each quarter:
 *   - A list of the sales figres by division
 *   - Each division's increase or decrease from the previous quarter (not 1st)
 *   - The total sales for the quarter
 *   - The company's increase or decrease from the previous quarter (not 1st)
 *   - The average sales for all divisions that quarter
 *   - The division with the highest sales for that quarter
 *
 * Example:
 * ┌─────┬─────┬────────────┬─────┬─────┬─────┬─────┬─────┬─────┐
 * │     │   Q1│          Q2│   Q3│   Q4│Total│  Q2∆│  Q3∆│  Q4∆│
 * ├─────┼─────┼────────────┼─────┼─────┼─────┼─────┼─────┼─────┤
 * │D1   │ 3.00│        2.00│ 1.00│ 0.00│ 6.00│-1.00│-1.00│-1.00│
 * │D2   │ 9.00│        1.00│ 3.00│ 2.00│15.00│-8.00│ 2.00│-1.00│
 * │D3   │ 1.00│        1.00│ 2.00│ 1.00│ 5.00│ 0.00│ 1.00│-1.00│
 * │D4   │ 1.00│        2.00│ 2.00│ 3.00│ 8.00│ 1.00│ 0.00│ 1.00│
 * │D5   │ 3.00│        2.00│ 1.00│ 3.00│ 9.00│-1.00│-1.00│ 2.00│
 * │D6   │ 0.00│        2.00│ 1.00│ 4.00│ 7.00│ 2.00│ 2.00│ 3.00│
 * ├─────┼─────┼────────────┼─────┼─────┼─────┼─────┼─────┼─────┤
 * │Total│17.00│       10.00│10.00│13.00│50.00│-7.00│-7.00│ 3.00│
 * ├─────┼─────┼────────────┼─────┼─────┼─────┴─────┴─────┴─────┤
 * │Avg  │ 2.83│        1.67│ 1.67│ 2.17│                       │
 * ├─────┼─────┼────────────┼─────┼─────┼───────────────────────┤
 * │Most │   D2│D1,2,3,4,5,6│   D2│   D4│                       │
 * └─────┴─────┴────────────┴─────┴─────┴───────────────────────┘
 */
public class SalesStats { 
    public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in);
        final int NUM_DIVS = 6;
        final int NUM_QRTS = 4;
        double[][] sales = new double[NUM_DIVS][NUM_QRTS];
        double[] DTotals = new double[NUM_DIVS];
        double[] QTotals = new double[NUM_QRTS];
        double[] QDeltas = new double[NUM_QRTS];
        double[] DAvgs   = new double[NUM_QRTS];
        int      bestDiv = 0;

        for(int div=0; div<NUM_DIVS; div++) {
            System.out.printf("Enter quartly sales for Division %d\n", div+1);
            for(int qtr=0; qtr<NUM_QRTS; qtr++) {
                System.out.printf("  Q%d: ", qtr+1); 
                sales[div][qtr] = scan.nextDouble();
                DTotals[div] += sales[div][qtr];
                QTotals[qtr] += sales[div][qtr];
                QDeltas[qtr] = (qtr == 0)? 0: QTotals[qtr] - QTotals[qtr-1];
                if(div == NUM_DIVS - 1) {
                    DAvgs[qtr] = QTotals[qtr] / NUM_DIVS; 
                }
            }
            if (DTotals[div] > DTotals[bestDiv]) {
                bestDiv = div;
            }
            System.out.println(); 
        }
    } 
}
