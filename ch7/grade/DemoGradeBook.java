import java.util.Scanner;
/**
 * Grade Book Demo -- Programming Challenge 7, page 506.
 *
 * Demonstrate the class in a program that:
 *   - Allows the user to enter each student's name and 4 test scores
 *   - Displays each student's average test score and letter grade.
 *
 * Input validation: 
 *   -Don't accept test scores less than 0 or greater than 100.
 */
public class DemoGradeBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final int NUM_STUDENTS = 5, NUM_TESTS = 4;

        String[]   names  = new String[NUM_STUDENTS];
        double[][] grades = new double[NUM_STUDENTS][NUM_TESTS];

        System.out.println("Enter student information.\n");
        for(int i=0; i<NUM_STUDENTS; i++) {
            System.out.printf("Student #%d's name: ", i+1);
            names[i] = scan.nextLine();

            System.out.printf("\nEnter %s's test information.\n\n", names[i]);
            for(int j=0; j<NUM_TESTS; j++) {
                System.out.printf("Test #%d's score: ", j+1);
                grades[i][j] = Double.parseDouble(scan.nextLine());
            }
            System.out.println();
            System.out.println();
        }

        GradeBook book = new GradeBook(names, grades);
        book.showGrades();
    }
}
