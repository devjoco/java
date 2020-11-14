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

    private String[]   names       = new String[NUM_STUDENTS];
    private char[]     letters     = new char[NUM_STUDENTS];
    private double[][] grades      = new double[NUM_STUDENTS][NUM_TESTS];
    private int        nameWidth = 0;

    public GradeBook(String[] names, double[][] grades) {
        setNamesGrades(names, grades);
        setLetters();
    }

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

    private void setNamesGrades(String[] names, double[][] grades) {
        boolean validNumberStudents = names.length >= NUM_STUDENTS;
        boolean validNumberGrades = grades.length >= NUM_STUDENTS
            && grades[0].length >= NUM_TESTS
            && grades[1].length >= NUM_TESTS
            && grades[2].length >= NUM_TESTS
            && grades[3].length >= NUM_TESTS
            && grades[4].length >= NUM_TESTS;

        if(validNumberStudents && validNumberGrades) {
            for(int i=0; i<NUM_STUDENTS; i++) {
                this.names[i] = names[i];
                if(names[i].length() > nameWidth)
                    nameWidth = names[i].length();

                for(int j=0; j<NUM_TESTS; j++)
                    this.grades[i][j] = grades[i][j];
            }
        }
    }

    private void setLetters() {
        for(int i=0; i<NUM_STUDENTS; i++)
            setLetter(i);
    }

    private void setLetter(int pos) {
        if(0 <= pos && pos < NUM_STUDENTS) {
            double avg = getAvg(pos);
            if (avg >= 90)
                letters[pos] = 'A';
            else if (avg >= 80)
                letters[pos] = 'B';
            else if (avg >= 70)
                letters[pos] = 'C';
            else if (avg >= 60)
                letters[pos] = 'D';
            else
                letters[pos] = 'F';
        }
    }

    public void showGrades() {
        int[] widths = {nameWidth, 8, 8};
        printBorder(widths, 't');
        for(int i=0; i<NUM_STUDENTS; i++) {
            System.out.printf(
                    "│%-"+nameWidth+"s│Avg:%4.0f│Grade: %c│\n", 
                    names[i], getAvg(i), getLetter(i)
                    );
            if(i != NUM_STUDENTS - 1)
                printBorder(widths, 'm');
        }
        printBorder(widths, 'b');
    }

    private void printBorder(int[] widths, char pos) {
        char lBreak, mBreak, rBreak, sep = '─';
        switch(pos) {
            case 't':
            case 'T':
                lBreak = '┌';
                mBreak = '┬';
                rBreak = '┐';
                break;
            case 'b':
            case 'B':
                lBreak = '└';
                mBreak = '┴';
                rBreak = '┘';
                break;
            default:
                lBreak = '├';
                mBreak = '┼';
                rBreak = '┤';
                break;
        }
        System.out.print(lBreak);
        for(int width: widths) {
            for(int i=0; i<width; i++)
                System.out.print(sep);
            System.out.print(mBreak);
        }
        System.out.println("\b"+rBreak);
    }
}
