import java.util.Scanner;

public class Rainfall {
    final private static int NUM_MONTHS = 12;
    final private static String[] monthNames = {
        "January", "February", "March",
        "April",   "May",      "June",
        "July",    "August",   "September",
        "October", "November", "December"
    };
    private double[] months = new double[NUM_MONTHS];
    
    public double getYearTotal() {
        double total = 0;
        for(double month: months)
            total += month;
        return total;
    }

    public double getMonthAverage() {
        return getYearTotal() / NUM_MONTHS;
    }

    public String getMostRainMonth() {
        int idx = 0;
        double max = months[0];
        for(int i=1; i<months.length-1; i++) {
            double thisMonth = months[i];
            if(thisMonth > max) {
                max = thisMonth;
                idx = i;
            }
        }
        return monthNames[idx];
    }

    public String getLeastRainMonth() {
        int idx = 0;
        double min = months[0];
        for(int i=1; i<months.length-1; i++) {
            double thisMonth = months[i];
            if(thisMonth < min) {
                min = thisMonth;
                idx = i;
            }
        }
        return monthNames[idx];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Rainfall rf = new Rainfall();

        System.out.println("Enter the rainfall for each month");
        for(int i=0; i<NUM_MONTHS; i++) {
            System.out.printf("%s: ", monthNames[i]);
            rf.months[i] = scan.nextDouble();
        }

        System.out.printf("Total rainfall: %.2f\n", rf.getYearTotal());
        System.out.printf("Average rainfall: %.2f\n", rf.getMonthAverage());
        System.out.printf("Most rainfall in: %s\n", rf.getMostRainMonth());
        System.out.printf("Least rainfall in: %s\n", rf.getLeastRainMonth());

    }
}
