public class DemoFactory {
    public static void main(String[] args) {
        final int NUM_FACTORIES = 4;
        final int[] wphRange = {5, 10, 15, 20};
        final int[] spdRange = {1, 2, 3, 4};
        final int[] hpsRange = {4, 6, 8, 10};
        String shiftPlur, dayPlur;
        int wph, spd, hps, days;
        int wtm = args.length == 1? Integer.parseInt(args[0]) : 1000;

        Factory[] facs = new Factory[NUM_FACTORIES];
        for(int i=0; i<NUM_FACTORIES; i+=1) 
            facs[i] = new Factory(wphRange[i], spdRange[i], hpsRange[i], wtm);

        /* Output:
         * To make {wtm} widgets it'll take:
         *     - {m1} days w/ {y1} {z1}-hour shifts at {x1} widgets/hour. 
         *     - {m2} days w/ {y2} {z2}-hour shifts at {x2} widgets/hour. 
         *        …            …    …                   … 
         *     - {mn} days w/ {yn} {zn}-hour shifts at {xn} widgets/hour. 
         */
        System.out.printf("To make %,d widgets it'll take:\n", wtm);
        for(int i=0; i<facs.length; i+=1) {
            facs[i].setWTM(wtm);
            wph       = facs[i].getWPH();
            spd       = facs[i].getSPD();
            hps       = facs[i].getHPS();
            days      = (int)Math.ceil(facs[i].getDTM());
            shiftPlur = spd == 1  ? " " : "s";
            dayPlur   = days == 1 ? "" : "s";

            System.out.printf(
                    "%,7d day%s w/ %d %2d-hour shift%s at %2d widgets/hour\n",
                    days, dayPlur, spd, hps, shiftPlur, wph
            );
        }
    }
}
