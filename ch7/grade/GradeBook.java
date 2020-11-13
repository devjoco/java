/**
 * Grade Book -- Programming Challenge 7, Page 506.
 * A Teacher has five students who have taken four tests. The teacher uses the
 * following grading scale to assign a letter grade to a student, based on the
 * average of his or her four test scores.
 *
 *      Test Score  Letter Grade
 *      90-100          A
 *      80-89           B
 *      70-79           C
 *      60-69           D
 *      0-59            F
 *
 * Write a class that:
 *   - Uses 1 String array to hold 5 students' names
 *   - Uses 1 char   array to hold 5 students' grades
 *   - Uses 5 double arrays to hold each student's set of test scores.
 *   - Has a method to return a specific student's name
 *   - Has "   "    "    "    "   "        "       average test score
 *   - Has "   "    "    "    "   "        "       letter grade based on avg
 *
 * Demonstrate the class in a program that:
 *   - Allows the user to enter each student's name and 4 test scores
 *   - Displays each student's average test score and letter grade.
 *
 * Input validation: 
 *   -Don't accept test scores less than 0 or greater than 100.
 *
 * Modify the grade book application so it drops each student's lowest score
 * when determining the test score averages and letter grades.
 */
public class GradeBook {
    final private int NUM_STUDENTS = 5;
    final private int NUM_TESTS = 4;

    private String[]   names   = new String[NUM_STUDENTS];    
    private char[]     letters = new char[NUM_STUDENTS];
    private double[][] grades  = new double[NUM_STUDENTS][NUM_TESTS];

    public String getName(int pos) {
        return names[pos]; 
    }

    public char getLetter(int pos) {
        return letters[pos];
    }

    public double getAvg(int pos) {
        double total = 0;
        for(double grade: grades[pos])
            total += grade;
        return total / NUM_TESTS;
    }
}
