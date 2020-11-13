import java.lang.Math;
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
 * │High │   D2│D1,2,3,4,5,6│   D2│   D4│   D2│   D6│ D2,6│   D6│
 * └─────┴─────┴────────────┴─────┴─────┴─────┴─────┴─────┴─────┘
 */
public class SalesStats { 
    public static void main(String[] args) { 
        DecimalFormat sale = new DecimalFormat("¤#,##0.00");
        Scanner       scan = new Scanner(System.in);
        String[] rowLabels = {
            "", "D1", "D2", "D3", "D4", "D5", "D6", 
            "Total", "Avg", "High", "Low"
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
        
        int[][]    qtrHigh   = new int[QTRS][0];
        int[][]    qtrLow    = new int[QTRS][0];
        int[][]    deltaLow  = new int[QTRS][0];
        int[][]    deltaHigh = new int[QTRS][0];
        int[]      highSales = new int[0];
        int[]      lowSales  = new int[0];

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
                if(deltaHigh[qtr].length == 0  ||
                        deltas[div][qtr] > deltas[deltaHigh[qtr][0]][qtr]) {
                    // Found a new, lone deltaHigh; set deltaHigh[qtr] to div
                    deltaHigh[qtr] = new int[1];
                    deltaHigh[qtr][0] = div;
                } else if(deltas[div][qtr] == deltas[deltaHigh[qtr][0]][qtr]) {
                    // Found a new, add't deltaHigh; add div to deltaHigh[qtr]
                    int[] tempArr = new int[deltaHigh[qtr].length + 1];
                    for(int i=0; i<deltaHigh[qtr].length; i++) 
                        tempArr[i] = deltaHigh[qtr][i];
                    tempArr[tempArr.length - 1] = div;
                    deltaHigh[qtr] = tempArr;
                }

                // Update deltaLow
                if(deltaLow[qtr].length == 0  ||
                        deltas[div][qtr] < deltas[deltaLow[qtr][0]][qtr]) {
                    // Found a new, lone deltaLow; set deltaLow[qtr] to div
                    deltaLow[qtr] = new int[1];
                    deltaLow[qtr][0] = div;
                } else if(deltas[div][qtr] == deltas[deltaLow[qtr][0]][qtr]) {
                    // Found a new, add't deltaLow; add div to deltaLow[qtr]
                    int[] tempArr = new int[deltaLow[qtr].length + 1];
                    for(int i=0; i<deltaLow[qtr].length; i++) 
                        tempArr[i] = deltaLow[qtr][i];
                    tempArr[tempArr.length - 1] = div;
                    deltaLow[qtr] = tempArr;
                }

                // Update deltaTotals
                deltaTotals[qtr] += deltas[div][qtr];

                // Update qtrHigh
                if(qtrHigh[qtr].length == 0  ||
                        sales[div][qtr] > sales[qtrHigh[qtr][0]][qtr]) {
                    // Found a new, lone qtrHigh; set qtrHigh[qtr] to that div
                    qtrHigh[qtr] = new int[1];
                    qtrHigh[qtr][0] = div;
                } else if(sales[div][qtr] == sales[qtrHigh[qtr][0]][qtr]) {
                    // Found a new, add't qtrHigh; add div to qtrHigh[qtr]
                    int[] tempArr = new int[qtrHigh[qtr].length + 1];
                    for(int i=0; i<qtrHigh[qtr].length; i++) 
                        tempArr[i] = qtrHigh[qtr][i];
                    tempArr[tempArr.length - 1] = div;
                    qtrHigh[qtr] = tempArr;
                }

                // Update qtrLow
                if(qtrLow[qtr].length == 0  ||
                        sales[div][qtr] < sales[qtrLow[qtr][0]][qtr]) {
                    // Found a new, lone qtrLow; set qtrLow[qtr] to that div
                    qtrLow[qtr] = new int[1];
                    qtrLow[qtr][0] = div;
                } else if(sales[div][qtr] == sales[qtrLow[qtr][0]][qtr]) {
                    // Found a new, add't qtrLow; add div to qtrLow[qtr]
                    int[] tempArr = new int[qtrLow[qtr].length + 1];
                    for(int i=0; i<qtrLow[qtr].length; i++) 
                        tempArr[i] = qtrLow[qtr][i];
                    tempArr[tempArr.length - 1] = div;
                    qtrLow[qtr] = tempArr;
                }

                // Update width of deltas columns
                if(getWidth(deltas[div][qtr]) > deltaWidths[qtr]) 
                    deltaWidths[qtr] = getWidth(deltas[div][qtr]);

                // Updates that happen after all quarters of a division proc.
                if(qtr == QTRS - 1) {

                    // Update width of Total column
                    if(getWidth(divTotals[div]) > totalWidth) 
                        totalWidth = getWidth(divTotals[div]);

                    // Update highSales
                    if(highSales.length == 0 
                            || divTotals[div] > divTotals[highSales[0]]) {
                        // Found a new, lone qtrLow; set highSales to that div
                        highSales = new int[1];
                        highSales[0] = div;
                    } else if(divTotals[div] == divTotals[highSales[0]]) {
                        // Found a new, add't highSales; add div to highSales
                        int[] tempArr = new int[highSales.length + 1];
                        for(int i=0; i<highSales.length; i++) 
                            tempArr[i] = highSales[i];
                        tempArr[tempArr.length - 1] = div;
                        highSales = tempArr;
                    }
                        

                    // Update lowSales
                    if(lowSales.length == 0 
                            || divTotals[div] < divTotals[lowSales[0]]) {
                        // Found a new, lone qtrLow; set lowSales to that div
                        lowSales = new int[1];
                        lowSales[0] = div;
                    } else if(divTotals[div] == divTotals[lowSales[0]]) {
                        // Found a new, add't lowSales; add div to lowSales
                        int[] tempArr = new int[lowSales.length + 1];
                        for(int i=0; i<lowSales.length; i++) 
                            tempArr[i] = lowSales[i];
                        tempArr[tempArr.length - 1] = div;
                        lowSales = tempArr;
                    }
                }

                // Updates that happen after all divisions processed
                if(div == DIVS - 1) {

                    // Update qtrAvg
                    qtrAvg[qtr] = qtrTotals[qtr] / DIVS;
                    
                    // Update deltaAvg
                    deltaAvg[qtr] = deltaTotals[qtr] / DIVS;

                    // Update qtrWidths
                    qtrWidths[qtr] = Math.max(
                            getWidth(qtrTotals[qtr]),
                            Math.max(
                                getDivString(qtrLow[qtr]).length(),
                                getDivString(qtrHigh[qtr]).length()
                                )
                            );

                    // Calc width of totals column
                    if(getWidth(totalSales) > totalWidth)
                        totalWidth = getWidth(totalSales);

                    totalWidth = Math.max(
                            Math.max(
                                totalWidth,
                                getWidth(totalSales)
                                ),
                            Math.max(
                                getDivString(highSales).length(),
                                getDivString(lowSales).length()
                                )
                            );

                    // Update deltaWidths
                    if(getWidth(deltaTotals[qtr]) > deltaWidths[qtr]) 
                        deltaWidths[qtr] = getWidth(deltaTotals[qtr]);

                    deltaWidths[qtr] = Math.max(
                            Math.max(
                                deltaWidths[qtr],
                                getWidth(deltaTotals[qtr])
                                ),
                            Math.max(
                                getDivString(deltaLow[qtr]).length(),
                                getDivString(deltaHigh[qtr]).length()
                                )
                            );

                    // Calc avgSales
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

        // Print High row
        printRowSep(colWidths, 'M');
        // Print High row label
        System.out.printf("│%"+colWidths[0]+"s", rowLabels[rowsPrinted]);
        // Print quarter highs
        for(int col=qtrOffset, qtr=0; qtr<QTRS; qtr++, col++)
            System.out.printf("│%"+colWidths[col]+"s", 
                    getDivString(qtrHigh[qtr]));
        // Print total high
        System.out.printf("│%"+colWidths[totalOffset]+"s",
                getDivString(highSales));
        // Print delta highs
        for(int col=deltaOffset, qtr=1; qtr<QTRS; qtr++, col++)
            System.out.printf("│%"+colWidths[col]+"s", 
                    getDivString(deltaHigh[qtr]));
        // End Highs
        System.out.println("│");
        rowsPrinted++;

        // Print Low row
        printRowSep(colWidths, 'M');
        // Print Low row label
        System.out.printf("│%"+colWidths[0]+"s", rowLabels[rowsPrinted]);
        // Print quarter lows
        for(int col=qtrOffset, qtr=0; qtr<QTRS; qtr++, col++)
            System.out.printf("│%"+colWidths[col]+"s", 
                    getDivString(qtrLow[qtr]));
        // Print total low
        System.out.printf("│%"+colWidths[totalOffset]+"s",
                getDivString(lowSales));
        // Print delta lows
        for(int col=deltaOffset, qtr=1; qtr<QTRS; qtr++, col++)
            System.out.printf("│%"+colWidths[col]+"s", 
                    getDivString(deltaLow[qtr]));
        // End Lows
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
 * │High │   D2│D1,2,3,4,5,6│   D2│   D4│   D2│   D6│ D2,6│   D6│
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

    public static String getDivString(int[] divs) {
        String str = "D";
        for(int i=0; i<divs.length; i++) 
            str += (i == divs.length - 1)? divs[i] + 1: (divs[i] + 1)+",";
        return str.equals("D1,2,3,4,5,6")? "All": str;
    }
}
