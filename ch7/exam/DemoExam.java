import java.io.*;

public class DemoExam {
    public static void main(String[] args) throws IOException {
        char[] answers1 = {
            'B', 'A', 'B', 'D', 'C', 'C', 'B', 'A', 'B', 'A',
            'C', 'C', 'A', 'A', 'A', 'B', 'A', 'A', 'A', 'A',
            'A', 'B', 'A', 'A'},
            answers2 = {
            'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B', 
            'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D',
            'C', 'D', 'A', 'B'},
            answers3 = {
            'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 
            'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
            'A', 'A', 'A', 'A'};

        Exam exam1 = new Exam(answers1, answers1);
        Exam exam2 = new Exam(answers2, answers3);
        Exam exam3 = new Exam(answers1, answers3);
        Exam exam4 = new Exam("sampleTest.csv");
        displayExamResults(exam1);
        displayExamResults(exam2);
        displayExamResults(exam3);
        displayExamResults(exam4);
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
