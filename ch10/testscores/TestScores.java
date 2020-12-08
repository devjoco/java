import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.*;

/** Programming Challenge #1 Chapter 10 Page 697.
 * Write a class named TestScores. The class constructor should accept an array
 * of test scores. If any test score in the array is negative or greater than
 * 100, the class should throw an IllegalArgumentException. Demonstrate the
 * class in a program.  */
public class TestScores implements Serializable {
    private double[] scores;
    private double average;
    private boolean averageCalculated = false;

    /** Returns the average of the scores array.
     * Calculates the average before returning if not done yet. */
    public double getAverage() {
        if(!averageCalculated) {
            double sum = 0;
            for(double score: scores)
                sum += score;
            average = sum / scores.length;
        }
        return average;
    }

    /** Constructor.
     * Throws IllegalArgumentException if a score is negative or above 100 */
    public TestScores(double[] scores) {
        this.scores = new double[scores.length];
        for(int i=0; i<scores.length; i++) {
            if(scores[i] < 0 || 100 < scores[i])
                throw new IllegalArgumentException("Score range: 0-100");
            this.scores[i] = scores[i];
        }
    }

    /** Prints a one-line repr of the TestScores object.
     * e.g. TS{35.3, 56.4, 93.9, 87.5, 93.2, 57.0} */
    @Override
    public String toString() {
        DecimalFormat sFmt = new DecimalFormat("0.0");
        int scoresAdded = 0;
        String buffer;
        StringBuilder str = new StringBuilder("TS{");
        for(double score: scores) {
            buffer = (scoresAdded == 0)? "": ", ";
            str.append(buffer + sFmt.format(score));
            scoresAdded++;
        }
        str.append("}");
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("How many scores are there?");
        System.out.print("Number of Scores: ");
        int numScores = scan.nextInt();

        double[] scores = new double[numScores];

        for(int i=0; i<numScores; i++) {
            System.out.printf("Score %d: ", i+1); 
            scores[i] = scan.nextDouble();
        }

        TestScores ts = new TestScores(scores);
        System.out.printf("Average of scores: %.2f\n", ts.getAverage());
    }
}
