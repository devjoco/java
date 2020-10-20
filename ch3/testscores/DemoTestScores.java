import java.util.Scanner;

/**
 * Demonstrate the class by writing a separate program that creates an 
 * instance of the class. 
 *
 * The program should ask the user to enter three test scores, which are stored
 * in the TestScore object. 
 *
 * Then the program should display the average of the scores, as reported by 
 * the TestScore object.
 */
public class DemoTestScores {
    public static void main(String[] args) {
        Scanner    sc     = new Scanner(System.in);
        TestScores ts     = new TestScores();
        double[]   scores = new double[3];
        
        if (args.length == 3) {
            for(int i=0; i<3; i+=1) {
                scores[i] = Double.parseDouble(args[i]);
            }
        } else {
            for(int i=0; i<3; i+=1) {
                System.out.print("Enter a test score: ");
                scores[i] = sc.nextDouble();
            }
        }
        ts.setScore1(scores[0]);
        ts.setScore2(scores[1]);
        ts.setScore3(scores[2]);

        System.out.printf("%.1f, %.1f, and %.1f average to be %.1f\n",
                ts.getScore1(),
                ts.getScore2(),
                ts.getScore3(),
                ts.getAverage()
        );
    }
}
