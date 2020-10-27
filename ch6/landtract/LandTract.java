import java.util.Scanner;
import java.text.DecimalFormat;

public class LandTract {
    private double length;
    private double width;

    public LandTract(double l, double w) {
        length = l;
        width = w;
    }

    public double getArea() {
        return length * width;
    }

    public boolean equals(LandTract obj) {
        return this.getArea() == obj.getArea();
    }

    public String toString() {
        DecimalFormat fmt = new DecimalFormat("#,##0.#");
        return "{" 
            + fmt.format(length) 
            + "x" 
            + fmt.format(width) 
            + "}";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many land tracts are you comparing? ");
        int numTracts = sc.nextInt();
        double length, width;
        LandTract[] lts = new LandTract[numTracts];
        
        for(int i = 0; i < numTracts; i++) {
            System.out.println();
            System.out.printf("What are the dimensions for the %d%s tract?\n",
                    i+1, 
                    getSuffix(i+1));
            System.out.print("Length in ft: ");
            length = sc.nextDouble();
            System.out.print("Width in ft: ");
            width = sc.nextDouble();
            lts[i] = new LandTract(length, width);
        }
        printEqualityMatrix(lts);
    }

    /**
     * Prints a matrix of LT equalities.
     *
     *      e.g. LT1 = 5x4, LT2 = 3x9, LT3 = 2x10
     *            
     *      {LxW}       | {5x4} | {3x9} | {2x10}
     *             Area |  20   |  27   |  20  
     *      {5x4}   20  |   T   |   F   |   T
     *      {3x9}   27  |   F   |   T   |   F    
     *      {2x10}  20  |   T   |   F   |   T      
     *
     */
    public static void printEqualityMatrix(LandTract[] lts) {
        DecimalFormat fmt = new DecimalFormat("#,##0.#");
        int thisLen, longest = 5;

        // Get longest string repr of LTs
        for(int i=0; i<lts.length; i++) {
            thisLen = lts[i].toString().length();
            longest = thisLen > longest? thisLen : longest;
        }
        
        // Print header of LTs
        System.out.printf("\n%"+longest+"s │ %"+longest+"s │ ",
                "{LxW}",
                " ");
        for(int i=0; i<lts.length; i++) {
            System.out.printf("%"+longest+"s%s",
                    lts[i],
                    i == lts.length - 1? "\n":" │ ");
        }

        // Print header of Areas
        System.out.printf("%"+longest+"s │ %"+longest+"s │ ",
                " ",
                "Area");
        for(int i=0; i<lts.length; i++) {
            System.out.printf("%"+longest+"s%s",
                    fmt.format(lts[i].getArea()),
                    i == lts.length - 1? "\n":" │ ");
        }

        // Print body of matrix
        for(int i=0; i<lts.length; i++) {
            System.out.printf("%"+longest+"s │ %"+longest+"s │ ",
                    lts[i],
                    fmt.format(lts[i].getArea()));
            for(int j=0; j<lts.length; j++) {
                System.out.printf("%"+longest+"s%s",
                        lts[i].equals(lts[j])? "Same" : "",
                        j == lts.length - 1? "\n" : " │ ");
            }
        }
    }

    /**
     * Returns the ordinal suffix for the given number.
     * 
     * e.g. 1, 21, 31, 41, etc. →  return "st"
     *      2, 22, 32, 42, etc. →  return "nd"
     *      3, 23, 33, 43, etc. →  return "rd"
     *      All others          →  return "th"
     */
    public static String getSuffix(int num) {
        String suffix;
        switch(num % 10) {
            case 0:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                suffix = "th";
                break;
            case 1:
                suffix = (num == 11)? "th" : "st";
                break;
            case 2:
                suffix = (num == 12)? "th" : "nd";
                break;
            case 3:
                suffix = (num == 13)? "th" : "rd";
                break;
            default:
                suffix = "?";
                break;
        }
        return suffix;
    }
}
