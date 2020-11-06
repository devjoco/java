public class DemoExam {
    public static void main(String[] args) {
        char[] testPassAns = {
            'B', 'A', 'B', 'D', 'C', 'C', 'B', 'A', 'B', 'A',
            'C', 'C', 'A', 'A', 'A', 'B', 'A', 'A', 'A', 'A',
            'A', 'B', 'A', 'A'},
            testFailAns = {
            'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B', 
            'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D',
            'C', 'D', 'A', 'B'},
            testAllAAns = {
            'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 
            'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
            'A', 'A', 'A', 'A'};

        Exam exam1 = new Exam(testPassAns);
        System.out.printf("Exam1 %s with %d correct, %d incorrect.\n",
                exam1.passed()? "passed" : "didn't pass",
                exam1.totalCorrect(),
                exam1.totalIncorrect());
        exam1.printMissed();

        Exam exam2 = new Exam(testFailAns);
        System.out.println();
        System.out.printf("Exam2 %s with %d correct, %d incorrect.\n",
                exam2.passed()? "passed" : "didn't pass",
                exam2.totalCorrect(),
                exam2.totalIncorrect());
        exam2.printMissed();

        Exam exam3 = new Exam(testAllAAns);
        System.out.println();
        System.out.printf("Exam3 %s with %d correct, %d incorrect.\n",
                exam3.passed()? "passed" : "didn't pass",
                exam3.totalCorrect(),
                exam3.totalIncorrect());
        exam3.printMissed();
    }
}
