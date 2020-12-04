import java.io.*;
import java.util.Scanner;

/**
 * Number Analysis Class ─ Programming Challenge #11, Page 507.
 *
 * Write a class with a constructor that accepts a file name as its argument. 
 * Asssume the file contains a series of numbers, each written on a separate 
 * line. The class should read the contents of the file into an array, and 
 * then display the following data:
 *  - The lowest number in the array
 *  - The highest number in the array
 *  - The total of the numbers in the array
 *  - The average of the numbers in the array
 */
public class NumberAnalysis {
    private double   lowest, highest, total, average, num;
    private int      count;
    private Scanner  scan;

    public NumberAnalysis(String filename) throws IOException {
        scan = new Scanner(new File(filename));
        while(scan.hasNext()) {
            num = scan.nextDouble();
            total += num;
            highest = num > highest ? num : highest;
            lowest  = num < lowest  ? num : lowest;
            count++;
        }
        average = total / count;
    }

    public double getLowest()  { return lowest;  }
    public double getHighest() { return highest; }
    public double getTotal()   { return total;   }
    public double getAverage() { return average; }
}
