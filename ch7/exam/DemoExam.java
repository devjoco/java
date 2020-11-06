import java.io.*;

public class DemoExam {
    public static void main(String[] args) throws IOException {
        Exam ch6Exam = new Exam("ch6Exam.csv");
        displayExamResults(ch6Exam);

        Exam ch7Exam = new Exam("ch7Exam.csv");
        displayExamResults(ch7Exam);
    }

    public static void displayExamResults(Exam exam) {
        System.out.println();
        System.out.printf("Exam %s with %d correct, %d incorrect.\n",
                exam.passed()? "passed" : "didn't pass",
                exam.totalCorrect(),
                exam.totalIncorrect());
        exam.printMissed();
    }
}
