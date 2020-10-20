public class DemoFactory {
    public static void main(String[] args) {
        final int WTM = 1000;
        int wph, spd, hps, days;
        String shiftPlur, dayPlur;

        Factory slowFac = new Factory(5, 1, 6);
        Factory avgFac  = new Factory(); // Default with 10 WPH, 2 SPD, 8 HPS
        Factory fastFac = new Factory(15, 2, 8);
        Factory maxFac  = new Factory(15, 3, 8);

        Factory[] facs = new Factory[4];
        facs[0] = slowFac;
        facs[1] = avgFac;
        facs[2] = fastFac;
        facs[3] = maxFac;

        System.out.printf("To make %d widgets it'll take:\n", WTM);
        for(int i=0; i<facs.length; i+=1) {
            facs[i].setWTM(WTM);
            wph       = facs[i].getWPH();
            spd       = facs[i].getSPD();
            hps       = facs[i].getHPS();
            days      = (int)Math.ceil(facs[i].getDTM());
            shiftPlur = spd == 1  ? "" : "s";
            dayPlur   = days == 1 ? "" : "s";

            /*
             * End Result:
             * To make 1000 widgets it'll take:
             *     - 5 days with 2 8-hour shifts making 10 widgets per hour. 
             */
            System.out.printf(
                    "\t%3d day%s w/ %d %d-hour shift%s at %2d widgets/hour\n",
                    days, dayPlur, spd, hps, shiftPlur, wph
            );
        }
    }
}
