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
    //   1    2    3    4    5    6    7    8    9    0
        'B', 'A', 'B', 'D', 'C', 'C', 'B', 'A', 'B', 'A',
        'C', 'C', 'A', 'A', 'A', 'B', 'A', 'A', 'A', 'A'
        'A', 'B', 'A', 'A' 
    };

    public DriverExam(char[] ans) {
        studentAns = ans;
    }

    public boolean passed() { 
        return totalCorrect() >= PASSING_AMOUNT;
    }

    public int totalIncorrect() {
        int num = 0;
        for(int i=0; i<correctAns.length; i++)
            if(studentAns[i] != correctAns[i])
                num++;
        return num;
    }

    public int totalCorrect() {
        int num = 0;
        for(int i=0; i<correctAns.length; i++)
            if(studentAns[i] == correctAns[i])
                num++;
        return num;
    }

    public int[] questionsMissed() {
        int pos      = 0,
            missed[] = new int[totalIncorrect()];
        for(int i=0; i<correctAns.length; i++) {
            if(studentAns[i] != correctAns[i]) {
                missed[pos] = i + 1;
                pos++;
            }
        }
        return missed;
    }

    public void printMissed() {
        int[] missed = questionsMissed();
        boolean onePrinted = false;
        System.out.print("Missed Questions: [");
        for(int i=0; i<missed.length; i++) {
            System.out.printf("%d, ", missed[i]);
            onePrinted = true;
        }
        if (onePrinted)
            System.out.print("\b\b]\n");
        else
            System.out.print("]\n");
    }

}
