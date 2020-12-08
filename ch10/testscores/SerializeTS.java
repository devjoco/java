import java.util.Random;
import java.io.*;

public class SerializeTS {
    public static void main(String[] args) throws IOException {
        final String filename = "tsArrays.bin";

        /* Sample data to create TestScores from */
        double[] ts1 = {90};
        double[] ts2 = {89, 90};
        double[] ts3 = {78, 89, 90};
        double[] ts4 = {67, 78, 89, 90};
        double[] ts5 = {56, 67, 78, 89, 90};
        double[] ts6 = {45, 56, 67, 78, 89, 90};
        double[] ts7 = {34, 45, 56, 67, 78, 89, 90};
        double[] ts8 = {23, 34, 45, 56, 67, 78, 89, 90};
        double[] ts9 = {12, 23, 34, 45, 56, 67, 78, 89, 90};
        double[][] ts = {ts1, ts2, ts3, ts4, ts5, ts6, ts7, ts8, ts9};

        /* Create an un-init array of TestScores */
        TestScores[] TS1 = new TestScores[ts.length];

        /* Create an array of TestScores from sample data */
        TestScores[] TS2 = new TestScores[ts.length];
        for(int i=0; i<ts.length; i++)
            TS2[i] = new TestScores(ts[i]);

        /* Print out both arrays of TestScores */
        System.out.println("TS1:");
        printTSArray(TS1);
        System.out.println();
        System.out.println("TS2:");
        printTSArray(TS2);

        /* Serialize array of TestScores to a file */
        DataOutputStream file = new DataOutputStream(
                new FileOutputStream(filename));

        /* Deserialize TestScores from file into empty array */

        /* Print out both arrays of TestScores */

        /* Close file */
        file.close();
    }

    public static void printTSArray(TestScores[] ts) {
        String tsStr;
        for(int i=0; i<ts.length; i++) {
            tsStr = (ts[i] == null)? "null": ts[i].toString();
            System.out.println(tsStr);
        }
    }

}
