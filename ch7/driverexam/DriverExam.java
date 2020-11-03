/**
 * Simulates a driver's license exam.
 *
 * Holds the correct values for the 20 Qs.
 * Holds the student's answers for the 20 Qs.
 *
 * Has methods to:
 *   - Determine if student passed must have 15 correct to pass.
 *   - return the total number of correctly answered Qs
 *   - return the total number of incorrect answers
 *   - return the numbers of the Qs that were missed
 */
public class DriverExam {
    private final int PASSING_AMOUNT = 15;
    private char[] studentAns, correctAns = {
        'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D',
        'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'
    };

    public DriverExam(char[] ans) {
        studentAns = ans;
    }

    public boolean passed() { 
        return totalCorrect() >= PASSING_AMOUNT;
    }

    public int totalCorrect() {
        int numCorrect = 0;
        for(int i=0; i<correctAns.length; i++)
            if(studentAns[i] == correctAns[i])
                numCorrect++;
        return numCorrect;
    }
}
