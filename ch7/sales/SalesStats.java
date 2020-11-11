import java.util.Scanner;
import java.text.DecimalFormat;

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
 * │Total│17.00│       10.00│10.00│13.00│50.00│-7.00│ 3.00│ 3.00│
 * ├─────┼─────┼────────────┼─────┼─────┼─────┼─────┼─────┼─────┤
 * │Avg  │ 2.83│        1.67│ 1.67│ 2.17│ 8.33│-1.17│ 0.50│ 0.50│
 * ├─────┼─────┼────────────┼─────┼─────┼─────┼─────┼─────┼─────┤
 * │Most │   D2│D1,2,3,4,5,6│   D2│   D4│   D2│   D6│ D2,6│   D6│
 * └─────┴─────┴────────────┴─────┴─────┴─────┴─────┴─────┴─────┘
 */
public class SalesStats { 
    public static void main(String[] args) { 
        DecimalFormat sale = new DecimalFormat("¤#,##0.00");
        Scanner       scan = new Scanner(System.in);
        String[] rowLabels = {
            "", "D1", "D2", "D3", "D4", "D5", "D6", "Total", "Avg", "Most"
        };
        String[] colLabels = {
            "Q1", "Q2", "Q3", "Q4", "Total", "Q2∆", "Q3∆", "Q4∆"
        };

        final int NUM_DIVS = 6;
        final int NUM_QTRS = 4;

        double[][] sales       = new double[NUM_DIVS][NUM_QTRS];
        double[][] deltas      = new double[NUM_DIVS][NUM_QTRS];
        double[]   dTotals     = new double[NUM_DIVS];
        double[]   qTotals     = new double[NUM_QTRS];
        double[]   qAvgSales   = new double[NUM_QTRS];
        double[]   qAvgDeltas  = new double[NUM_QTRS];
        double[]   deltaTotals = new double[NUM_QTRS];
        double     salesTotal  = 0;
        double     salesAvg    = 0;
        int        colWidths[] = new int[9];
        int        qtrWidths[] = new int[NUM_QTRS];
        int        delWidths[] = new int[NUM_QTRS];
        int        dTotalWidth = 0;
        int        bestDiv     = 0;
        int        rowsPrinted = 0;
        int        qtrColOffset = 1;
        int        totalColOffset = 5;
        int        deltaColOffset = 6;

        for(int div=0; div<NUM_DIVS; div++) {
            System.out.printf("Enter quartly sales for Division %d\n", div+1);
            for(int qtr=0; qtr<NUM_QTRS; qtr++) {
                System.out.printf("  Q%d: ", qtr+1); 
                sales[div][qtr] = scan.nextDouble();
                dTotals[div] += sales[div][qtr];
                qTotals[qtr] += sales[div][qtr];
                salesTotal   += sales[div][qtr];
                deltas[div][qtr] = (qtr == 0)? 0:
                    sales[div][qtr] - sales[div][qtr-1];
                deltaTotals[qtr] += deltas[div][qtr];
                if (getLength(deltas[div][qtr]) > delWidths[qtr]) {
                    // Update length of deltas columns
                    delWidths[qtr] = getLength(deltas[div][qtr]);
                }
                if(qtr == NUM_QTRS - 1) {
                    // Can update width of Total column for divisions
                    if (getLength(dTotals[div]) > dTotalWidth)
                        dTotalWidth = getLength(dTotals[div]);
                }
                if(div == NUM_DIVS - 1) {
                    qAvgSales[qtr] = qTotals[qtr] / NUM_DIVS;
                    qAvgDeltas[qtr] = deltaTotals[qtr] / NUM_DIVS;

                    // Can calc width of column for that quarter
                    qtrWidths[qtr] = getLength(qTotals[qtr]);

                    // Calc width of totals column
                    if (getLength(salesTotal) > dTotalWidth)
                        dTotalWidth = getLength(salesTotal);

                    salesAvg = salesTotal / NUM_DIVS;
                }
            }
            if (dTotals[div] > dTotals[bestDiv]) {
                bestDiv = div;
            }
            System.out.println(); 
        }

        // Populate colWidths[] to easily print rowSeps
        colWidths[0] = getLongest(rowLabels);
        for(int i=0, j=1; i<NUM_QTRS; i++, j++)
            colWidths[j] = qtrWidths[i];
        colWidths[5] = dTotalWidth;
        for(int i=1, j=6; i<NUM_QTRS; i++, j++)
            colWidths[j] = delWidths[i];


        // Print Header
        // Print top row sep
        printRowSep(colWidths, 'T');
        // Print header row label
        System.out.printf("│%"+colWidths[0]+"s", rowLabels[rowsPrinted]);
        // Print column labels
        for(int i=0; i<colLabels.length; i++)
            System.out.printf("│%"+colWidths[i+1]+"s", colLabels[i]);
        // End Header
        System.out.println("│");
        rowsPrinted++;

        // Print Division rows
        printRowSep(colWidths, 'M');
        for(int div=0; div<NUM_DIVS; div++) {
            // Print row label
            System.out.printf("│%"+colWidths[0]+"s", rowLabels[rowsPrinted]);

            // Print quarters for that division
            for(int qtr=0; qtr<NUM_QTRS; qtr++) {
                System.out.printf("│%"+colWidths[qtrColOffset + qtr]+"s", 
                        sale.format(sales[div][qtr]));
            }

            // Print total for that division
            System.out.printf("│%"+colWidths[totalColOffset]+"s", 
                    sale.format(dTotals[div]));

            // print deltas for that division
            for(int col=deltaColOffset, qtr=1; qtr<NUM_QTRS; col++, qtr++) {
                System.out.printf("│%"+colWidths[col]+"s", 
                        sale.format(deltas[div][qtr]));
            }
            
            // End Division
            System.out.println("│");
            rowsPrinted++;
        }

        // Print Total row
        printRowSep(colWidths, 'M');
        // Print total row label
        System.out.printf("│%"+colWidths[0]+"s", rowLabels[rowsPrinted]);
        // Print quarter totals
        for(int col=qtrColOffset, qtr=0; qtr<NUM_QTRS; qtr++, col++)
            System.out.printf("│%"+colWidths[col]+"s", 
                    sale.format(qTotals[qtr]));
        // Print total total
        System.out.printf("│%"+colWidths[totalColOffset]+"s",
                sale.format(salesTotal));
        // Print delta totals
        for(int col=deltaColOffset, qtr=1; qtr<NUM_QTRS; qtr++, col++)
            System.out.printf("│%"+colWidths[col]+"s", 
                    sale.format(deltaTotals[qtr]));
        // End Totals
        System.out.println("│");
        rowsPrinted++;

        // Print Avg row
        printRowSep(colWidths, 'M');
        // Print Avg row label
        System.out.printf("│%"+colWidths[0]+"s", rowLabels[rowsPrinted]);
        // Print quarter avgs
        for(int col=qtrColOffset, qtr=0; qtr<NUM_QTRS; qtr++, col++)
            System.out.printf("│%"+colWidths[col]+"s", 
                    sale.format(qAvgSales[qtr]));
        // Print avgs total
        System.out.printf("│%"+colWidths[totalColOffset]+"s",
                sale.format(salesAvg));
        // Print delta avgs
        for(int col=deltaColOffset, qtr=1; qtr<NUM_QTRS; qtr++, col++)
            System.out.printf("│%"+colWidths[col]+"s", 
                    sale.format(qAvgDeltas[qtr]));
        // End Avgs
        System.out.println("│");
        rowsPrinted++;

        // Print Most row
        printRowSep(colWidths, 'M');
        // Print Most row label
        System.out.printf("│%"+colWidths[0]+"s", rowLabels[rowsPrinted]);
        // Print quarter mosts
        // Print total most
        // Print delta mosts
        // End Mosts
        System.out.println("│");
        rowsPrinted++;

        // Print bottom row sep
        printRowSep(colWidths, 'B');
    } 
/** 
 *  getLongest(rowLabels)             dTotalWidth 
 *    ↓   ←────────qtrWidths[i]────────→  ↓    ←──delWidths[i]─→
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
 * │Total│17.00│       10.00│10.00│13.00│50.00│-7.00│ 3.00│ 3.00│
 * ├─────┼─────┼────────────┼─────┼─────┼─────┼─────┼─────┼─────┤
 * │Avg  │ 2.83│        1.67│ 1.67│ 2.17│ 8.33│-1.17│ 0.50│ 0.50│
 * ├─────┼─────┼────────────┼─────┼─────┼─────┼─────┼─────┼─────┤
 * │Most │   D2│D1,2,3,4,5,6│   D2│   D4│   D2│   D6│ D2,6│   D6│
 * └─────┴─────┴────────────┴─────┴─────┴─────┴─────┴─────┴─────┘
 */

    public static void printRowSep(int[] widths, char pos) {
        String lBreak, mBreak, rBreak, sep = "─";
        switch (pos) {
            case 't':
            case 'T':
                lBreak = "┌";
                mBreak = "┬";
                rBreak = "┐";
                break;
            case 'b':
            case 'B':
                lBreak = "└";
                mBreak = "┴";
                rBreak = "┘";
                break;
            default:
                lBreak = "├";
                mBreak = "┼";
                rBreak = "┤";
                break;
            }
        System.out.print(lBreak);
        for(int width: widths) {
            for(int i=0; i<width; i++)
                System.out.print(sep);
            System.out.print(mBreak);
        }
        System.out.println("\b"+rBreak);
    }

    public static int getLength(double amt) {
        DecimalFormat sale = new DecimalFormat("¤#,##0.00"); 
        return sale.format(amt).length();
    }

    public static int getLongest(String[] strs) {
        int thisLen, longest = 0;
        for(String str: strs) {
            thisLen = str.length();
            if (thisLen > longest) {
                longest = thisLen;
            }
        }
        return longest;
    }
}
