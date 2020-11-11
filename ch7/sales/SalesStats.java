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

        final int DIVS = 6;
        final int QTRS = 4;

        double[][] sales       = new double[DIVS][QTRS];
        double[][] deltas      = new double[DIVS][QTRS];
        double[]   divTotals   = new double[DIVS];
        double[]   qtrTotals   = new double[QTRS];
        double[]   qtrAvg      = new double[QTRS];
        double[]   deltaAvg    = new double[QTRS];
        double[]   deltaTotals = new double[QTRS];
        double     totalSales  = 0;
        double     avgSales    = 0;
        
        int[]      qtrHigh   = new int[QTRS];
        int[]      qtrLow    = new int[QTRS];
        int[]      deltaLow  = new int[QTRS];
        int[]      deltaHigh = new int[QTRS];
        int        highSales = 0;
        int        lowSales  = 0;

        int        colWidths[]   = new int[9];
        int        qtrWidths[]   = new int[QTRS];
        int        deltaWidths[] = new int[QTRS];
        int        totalWidth    = 0;

        int        qtrOffset   = 1;
        int        totalOffset = 5;
        int        deltaOffset = 6;

        int        rowsPrinted = 0;

        // Gather sales info for each division
        for(int div=0; div<DIVS; div++) {
            System.out.printf("Enter quartly sales for Division %d\n", div+1);
            // Gather sales info for each quarter of that division
            for(int qtr=0; qtr<QTRS; qtr++) {
                System.out.printf("  Q%d: ", qtr+1); 
                // Save that quarter's sales
                sales[div][qtr] = scan.nextDouble();

                // Update divTotals
                divTotals[div] += sales[div][qtr];

                // Update qrtTotals
                qtrTotals[qtr] += sales[div][qtr];

                // Update totalSales
                totalSales += sales[div][qtr];

                // Update deltas
                deltas[div][qtr] = (qtr == 0)? 0:
                    sales[div][qtr] - sales[div][qtr-1];
                
                // Update deltaHigh
                if(deltas[div][qtr] > deltas[deltaHigh[qtr]][qtr])
                    deltaHigh[qtr] = div;

                // Update deltaLow
                if(deltas[div][qtr] < deltas[deltaLow[qtr]][qtr])
                    deltaLow[qtr] = div;

                // Update deltaTotals
                deltaTotals[qtr] += deltas[div][qtr];

                // Update qtrHigh
                if(sales[div][qtr] > sales[qtrHigh[qtr]][qtr])
                    qtrHigh[qtr] = div;

                // Update qtrLow
                if(sales[div][qtr] < sales[qtrLow[qtr]][qtr])
                    qtrLow[qtr] = div;

                // Update width of deltas columns
                if(getWidth(deltas[div][qtr]) > deltaWidths[qtr]) 
                    deltaWidths[qtr] = getWidth(deltas[div][qtr]);

                // Updates that happen after all quarters of a division proc.
                if(qtr == QTRS - 1) {

                    // Update width of Total column
                    if(getWidth(divTotals[div]) > totalWidth) 
                        totalWidth = getWidth(divTotals[div]);

                    // Update highSales
                    if(divTotals[div] > divTotals[highSales])
                        highSales = div;

                    // Update lowSales
                    if(divTotals[div] < divTotals[lowSales])
                        lowSales = div;
                }

                // Updates that happen after all divisions processed
                if(div == DIVS - 1) {

                    // Update qtrAvg
                    qtrAvg[qtr] = qtrTotals[qtr] / DIVS;
                    
                    // Update deltaAvg
                    deltaAvg[qtr] = deltaTotals[qtr] / DIVS;

                    // Update qtrWidths
                    qtrWidths[qtr] = getWidth(qtrTotals[qtr]);

                    // Calc width of totals column
                    if (getWidth(totalSales) > totalWidth)
                        totalWidth = getWidth(totalSales);

                    avgSales = totalSales / DIVS;
                }
            }
            System.out.println(); 
        }

        // Populate colWidths[] to easily print rowSeps
        colWidths[0] = getLongest(rowLabels);
        for(int i=0, j=1; i<QTRS; i++, j++)
            colWidths[j] = qtrWidths[i];
        colWidths[5] = totalWidth;
        for(int i=1, j=6; i<QTRS; i++, j++)
            colWidths[j] = deltaWidths[i];


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
        for(int div=0; div<DIVS; div++) {
            // Print row label
            System.out.printf("│%"+colWidths[0]+"s", rowLabels[rowsPrinted]);

            // Print quarters for that division
            for(int qtr=0; qtr<QTRS; qtr++) {
                System.out.printf("│%"+colWidths[qtrOffset + qtr]+"s", 
                        sale.format(sales[div][qtr]));
            }

            // Print total for that division
            System.out.printf("│%"+colWidths[totalOffset]+"s", 
                    sale.format(divTotals[div]));

            // print deltas for that division
            for(int col=deltaOffset, qtr=1; qtr<QTRS; col++, qtr++) {
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
        for(int col=qtrOffset, qtr=0; qtr<QTRS; qtr++, col++)
            System.out.printf("│%"+colWidths[col]+"s", 
                    sale.format(qtrTotals[qtr]));
        // Print total total
        System.out.printf("│%"+colWidths[totalOffset]+"s",
                sale.format(totalSales));
        // Print delta totals
        for(int col=deltaOffset, qtr=1; qtr<QTRS; qtr++, col++)
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
        for(int col=qtrOffset, qtr=0; qtr<QTRS; qtr++, col++)
            System.out.printf("│%"+colWidths[col]+"s", 
                    sale.format(qtrAvg[qtr]));
        // Print avgs total
        System.out.printf("│%"+colWidths[totalOffset]+"s",
                sale.format(avgSales));
        // Print delta avgs
        for(int col=deltaOffset, qtr=1; qtr<QTRS; qtr++, col++)
            System.out.printf("│%"+colWidths[col]+"s", 
                    sale.format(deltaAvg[qtr]));
        // End Avgs
        System.out.println("│");
        rowsPrinted++;

        // Print Most row
        printRowSep(colWidths, 'M');
        // Print Most row label
        System.out.printf("│%"+colWidths[0]+"s", rowLabels[rowsPrinted]);
        // Print quarter mosts
        for(int col=qtrOffset, qtr=0; qtr<QTRS; qtr++, col++)
            System.out.printf("│%"+colWidths[col]+"s", "D"+(++qtrHigh[qtr]));
        // Print total most
        System.out.printf("│%"+colWidths[totalOffset]+"s",
                "D"+(++highSales));
        // Print delta mosts
        for(int col=deltaOffset, qtr=1; qtr<QTRS; qtr++, col++)
            System.out.printf("│%"+colWidths[col]+"s", "D"+(++deltaHigh[qtr]));
        // End Mosts
        System.out.println("│");
        rowsPrinted++;

        // Print bottom row sep
        printRowSep(colWidths, 'B');
    } 
/** 
 *  getLongest(rowLabels)             totalWidth 
 *    ↓   ←────────qtrWidths[i]────────→  ↓    ←──deltaWidths[i]─→
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

    public static int getWidth(double amt) {
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
