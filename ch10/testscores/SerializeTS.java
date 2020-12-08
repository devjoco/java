import java.util.Random;
import java.io.*;

public class SerializeTS {
    public static void main(String[] args) 
            throws IOException, ClassNotFoundException {
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

        /* Create an array of TestScores from sample data */
        TestScores[] TS1 = new TestScores[ts.length];
        for(int i=0; i<ts.length; i++)
            TS1[i] = new TestScores(ts[i]);

        /* Create an un-init array of TestScores */
        TestScores[] TS2 = new TestScores[ts.length];

        /* Print out both arrays of TestScores */
        System.out.println("TS1:");
        printTSArray(TS1);
        System.out.println();
        System.out.println("TS2:");
        printTSArray(TS2);

        /* Serialize array of TestScores to a file */
        ObjectOutputStream outFile = new ObjectOutputStream(
                new FileOutputStream(filename));
        for(TestScores testScore: TS1)
            outFile.writeObject(testScore);
        outFile.close();

        /* Deserialize TestScores from file into empty array */
        boolean EOFReached = false;
        int pos = 0;
        ObjectInputStream inFile = new ObjectInputStream(
                new FileInputStream(filename));
        while(!EOFReached) {
            try {
                TS2[pos] = (TestScores) inFile.readObject();
                pos++;
            } 
            catch(EOFException e) {
                EOFReached = true;
            }
        }
        inFile.close();

        /* Print out both arrays of TestScores */
        System.out.println();
        System.out.println();
        System.out.println("TS1:");
        printTSArray(TS1);
        System.out.println();
        System.out.println("TS2:");
        printTSArray(TS2);
    }

    public static void printTSArray(TestScores[] ts) {
        String tsStr;
        for(int i=0; i<ts.length; i++) {
            tsStr = (ts[i] == null)? "null": ts[i].toString();
            System.out.println(tsStr);
        }
    }

}
