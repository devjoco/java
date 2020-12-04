import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

/**
 * Simulates a multiple choice exam.
 *
 * Holds the correct values for the Qs.
 * Holds the student's answers for the Qs.
 *
 * Has methods to:
 *   - Determine if student passed must have 75% correct to pass.
 *   - return the total number of correctly answered Qs
 *   - return the total number of incorrect answers
 *   - return the numbers of the Qs that were missed
 *
 * Scenarios at instance creation:
 *   1. Know the correct answers and the student's answers
 *       - Useful for calculating statistics on an exam already taken
 *       - char[] passed to constructor for correct answers
 *       - char[] passed to constructor for student's answers
 *   2. Know the test questions/correct answers, not student answers
 *       - Qs shown to user one at a time, allow the user to take the test
 *       - filename for csv with Qs and As passed to the constructor
 */
public class Exam {
    private final int LINE_LENGTH = 80;
    private final double PASS_PERCENT = 0.75;
    private final char CORRECT_CHAR = '*';
    private char[] studentAns, correctAns;

    /**
     * Constructor for scenario 1
     */
    public Exam(char[] correctAns, char[] studentAns) {
        this.correctAns = correctAns;
        this.studentAns = studentAns;
    }

    /**
     * Constructor for scenario 2
     */
    public Exam(String filename) throws IOException {
        displayTest(filename);
    }

    /**
     * Displays a multiple choice exam to the user one Q at a time, 
     * user enters his/her answers which are saved alongside correct answers.
     */
    public void displayTest(String filename) throws IOException {
        ArrayList<Character> csvAnswers  = new ArrayList<>();
        ArrayList<Character> userAnswers = new ArrayList<>();
        Scanner file = new Scanner(new File(filename));
        String currQ[], options[], question;
        char label;
        int numChoices, qNum = 1;

        // Loop through exam csv file
        while(file.hasNext()) {
            // Get info for currect Question
            currQ = file.nextLine().split(",");
            question = currQ[0];
            options  = Arrays.copyOfRange(currQ, 1, currQ.length);
            numChoices = options.length;

            // Display current Question and Options
            displayQuestion(question, qNum);
            displayOptions(Arrays.copyOfRange(currQ, 1, currQ.length),
                    csvAnswers);

            // Save user's answer
            userAnswers.add(validateUserChoice(numChoices));

            // Adv. question number
            qNum++;
        }

        // Set correctAns and studentAns to csvAnswers and userAnswers
        correctAns = new char[csvAnswers.size()];
        studentAns = new char[userAnswers.size()];
        for(int i=0; i<correctAns.length; i++) {
            correctAns[i] = csvAnswers.get(i);
            studentAns[i] = userAnswers.get(i);
        }
    }

    public void displayQuestion(String question, int qNum) {
        String[] words = question.split(" ");
        int charsThisLine = 0;

        System.out.println();
        System.out.printf("%3d.) ", qNum);
        charsThisLine += 6;

        for(String word: words) {
            if(charsThisLine + word.length() + 1 > LINE_LENGTH) {
                System.out.print("\n");
                System.out.printf("      %s ", word);
                charsThisLine = 6 + word.length();
            } else {
                System.out.printf("%s ", word);
                charsThisLine += word.length() + 1;
            }
        }
        System.out.println();
    }

    public void displayOptions(String[] options, ArrayList<Character> ans) {
        String option;
        char label;
        // Display options for question
        for(int i=0; i<options.length; i++) {
            label = (char)((int)'A' + i);
            option = options[i].trim();
            // Remove * from correct answer, and remember label
            if(option.charAt(0) == CORRECT_CHAR) {
                ans.add(label);
                option = option.substring(1);
            }
            System.out.printf("\t%c.) %s\n", label, option);
        }
    }

    public char validateUserChoice(int numChoices) {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.print("\tYour answer: ");
        char choice = scan.nextLine().toUpperCase().charAt(0);
        while((int)choice < (int)'A' 
                || (((int)'A' - 1) + numChoices) < (int)choice) {
            System.out.print("\tInvalid choice\n\n");
            System.out.print("\tYour answer: ");
            choice = scan.nextLine().toUpperCase().charAt(0);
        }
        return choice;
    }

    public boolean passed() { 
        return (double)totalCorrect() / correctAns.length >= PASS_PERCENT;
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
