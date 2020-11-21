import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;
import static java.nio.file.FileVisitOption.*;
import java.util.Scanner;

public class DemoExam {
    public static void main(String[] args) throws IOException {
        PathMatcher matcher = 
            FileSystems.getDefault().getPathMatcher("glob:ch[0-9]*Exam.csv");
        String[] tests = {"ch6Exam.csv", "ch7Exam.csv", "ch8Exam.csv"};
        Scanner scan = new Scanner(System.in);
        enumerateChoices(tests);
        char choice = scan.nextLine().toUpperCase().charAt(0);
        while( !(choice == '0') ) {
            Exam exam = new Exam(tests[(int)choice - (int)'A']);
            displayExamResults(exam);
            enumerateChoices(tests);
            choice = scan.nextLine().toUpperCase().charAt(0);
        } 
    }

    public static void enumerateChoices(String[] choices) {
        String displayName;
        char label;
        System.out.println("  Which test do you want to take:");
        for(int i=0; i<choices.length; i++) { 
            label = (char)(i + (int)'A');
            displayName = choices[i].split("\\.")[0]; 
            System.out.printf("\t%c.) %s\n", label, displayName);
        }
        System.out.print("\t0.) Exit\n");
        System.out.print("\n\tYour Choice: ");
    }

    public static void displayExamResults(Exam exam) {
        System.out.println();
        System.out.printf("Exam %s with %d correct, %d incorrect.\n",
                exam.passed()? "passed" : "didn't pass",
                exam.totalCorrect(),
                exam.totalIncorrect());
        exam.printMissed();
        System.out.println();
    }
}
