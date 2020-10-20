public class Factory {
    private int widgetsPerHour;
    private int shiftsPerDay;
    private int hoursPerShift;
    private int widgetsToMake;

    /**
     * A no-arg constructor that creates a factory with a default production
     * capacity, specified by Widget Factory Programming Challenge on p.179
     */
    public Factory() {
        widgetsPerHour = 10;
        shiftsPerDay   = 2;
        hoursPerShift  = 8;
        widgetsToMake  = 0;
    }

    /**
     * A constructor to create a factory with customized production capacity.
     */
    public Factory(int wph, int spd, int hps) {
        widgetsPerHour = wph;
        shiftsPerDay   = spd;
        hoursPerShift  = (hps > 24)? 24 : hps;
        widgetsToMake  = 0;
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
