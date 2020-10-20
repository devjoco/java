/**
 * Widget Factory -- Prog Challenge 6, p179
 * A Factory:
 *  - Creates x widgets per hour  (default of 10 wph)
 *  - Has     y shifts  per day   (default of 2 spd) 
 *  - Has     z hours   per shift (default of 8 hps)
 * 
 * There is no limit to the number of widgets that can be produced in an hour
 *
 * Shifts cannot be longer than a day, so if specified hps is more than 24,
 * then it is shortened to 24hrs
 *
 * Shifts cannot run over onto another day, so if spd * hps is more than 24,
 * then spd will be set to as many as possible without running over
 *
 * widgetsToMake is 0 to start, but can be changed with setWTM()
 */
public class Factory {
    private final int DAY_HRS = 24;
    private int widgetsPerHour; // No limit
    private int shiftsPerDay;   // Can't span multiple days
    private int hoursPerShift;  // Can't be more than 24
    private int widgetsToMake; 

    /**
     * No-arg constructor, creates factory w/ default production capacity, and
     * no widgets to be made yet
     */
    public Factory() {
        widgetsPerHour = 10;
        shiftsPerDay   = 2;
        hoursPerShift  = 8;
        widgetsToMake  = 0;
    }

    /**
     * Creates default factory and sets the number of widgets to make
     */
    public Factory(int wtm) {
        widgetsPerHour = 10;
        shiftsPerDay   = 2;
        hoursPerShift  = 8;
        widgetsToMake  = wtm;
    }

    /**
     * A constructor to create a factory with customized production capacity, 
     * and no widgets to be made yet
     */
    public Factory(int wph, int spd, int hps) {
        widgetsPerHour = wph;
        hoursPerShift  = (hps > DAY_HRS)? DAY_HRS : hps;
        shiftsPerDay   = (hoursPerShift * spd > 24)? DAY_HRS / hoursPerShift :
                                                     spd;
        widgetsToMake  = 0;
    }

    /**
     * A constructor to create a factory with customized production capacity, 
     * and sets the number of widgets to make
     */
    public Factory(int wph, int spd, int hps, int wtm) {
        widgetsPerHour = wph;
        hoursPerShift  = (hps > DAY_HRS)? DAY_HRS : hps;
        shiftsPerDay   = (hoursPerShift * spd > 24)? DAY_HRS / hoursPerShift :
                                                     spd;
        widgetsToMake  = wtm;
    }
    
    // Setters
    public void setWPH(int wph) { widgetsPerHour = wph; }
    public void setSPD(int spd) { shiftsPerDay   = spd; }
    public void setHPS(int hps) { hoursPerShift  = hps; }
    public void setWTM(int wtm) { widgetsToMake  = wtm; }
    
    // Getters
    public int getWPH() { return widgetsPerHour; }
    public int getSPD() { return shiftsPerDay;   }
    public int getHPS() { return hoursPerShift;  }
    public int getWTM() { return widgetsToMake;  }
    public double getDTM() {
        int widgetsPerDay = widgetsPerHour * hoursPerShift * shiftsPerDay;
        return (double)widgetsToMake / widgetsPerDay;
    }

}
