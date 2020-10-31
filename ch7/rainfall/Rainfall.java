public class Rainfall {
    final private int NUM_MONTHS = 12;
    final private String[] monthNames = {"January", "February", "March",
                                         "April",   "May",      "June",
                                         "July",    "August",   "September",
                                         "October", "November", "December"};
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

    public String getLeasttRainMonth() {
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

}
