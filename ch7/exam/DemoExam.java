import java.io.*;

public class DemoExam {
    public static void main(String[] args) throws IOException {
        Exam exam = new Exam("sampleTest.csv");
        displayExamResults(exam);
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
