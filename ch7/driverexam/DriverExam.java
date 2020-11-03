/**
 * Simulates a driver's license exam.
 *
 * Holds the correct values for the 20 Qs.
 * Holds the student's answers for the 20 Qs.
 *
 * Has methods to:
 *   - Determine if student passed
 *   - return the total number of correctly answered Qs
 *   - return the total number of incorrect answers
 *   - return the numbers of the Qs that were missed
 */
public class DriverExam {
    private char[] studentAns, correctAns = {
        'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D',
        'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'
    };
}
