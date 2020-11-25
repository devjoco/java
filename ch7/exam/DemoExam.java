import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;
import static java.nio.file.FileVisitOption.*;
import java.util.Scanner;
import java.util.ArrayList;

public class DemoExam {

    public static class ExamFinder extends SimpleFileVisitor<Path> {
        private final PathMatcher matcher = 
            FileSystems.getDefault().getPathMatcher("regex:ch[0-9]+Exam.csv");
        private ArrayList<String> exams = new ArrayList<String>();

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes atrs) {
            Path name = file.getFileName();
            if (name != null && matcher.matches(name))
                exams.add(file.toString());
            return CONTINUE;
        } 

        public String[] getExams() {
            return exams.toArray(new String[exams.size()]);
        }
    }

    public static void main(String[] args) throws IOException {
        Path startingDir = Paths.get("../../");

        ExamFinder eFinder = new ExamFinder();
        Files.walkFileTree(startingDir, eFinder);
        String[] tests = eFinder.getExams();

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
        String displayName, name;
        char label;
        int nameElems;
        System.out.println("  Which test do you want to take:");
        for(int i=0; i<choices.length; i++) { 
            label = (char)(i + (int)'A');
            nameElems = Paths.get(choices[i]).getNameCount();
            name = Paths.get(choices[i]).getName(nameElems-1).toString();
            displayName = name.split("\\.")[0]; 
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
