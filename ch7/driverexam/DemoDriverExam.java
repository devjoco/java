public class DemoDriverExam {
    public static void main(String[] args) {
        char[] testPassAns = {
            'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D',
            'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'},
            testFailAns = {
            'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B', 
            'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D'},
            testAllAAns = {
            'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 
            'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};

        DriverExam exam1 = new DriverExam(testPassAns);
        System.out.println();
        System.out.printf("Exam1 passed: %b, with %d correct, %d incorrect.\n",
                exam1.passed(),
                exam1.totalCorrect(),
                exam1.totalIncorrect());
        exam1.printMissed();

        DriverExam exam2 = new DriverExam(testFailAns);
        System.out.println();
        System.out.printf("Exam2 passed: %b, with %d correct, %d incorrect.\n",
                exam2.passed(),
                exam2.totalCorrect(),
                exam2.totalIncorrect());
        exam2.printMissed();

        DriverExam exam3 = new DriverExam(testAllAAns);
        System.out.println();
        System.out.printf("Exam3 passed: %b, with %d correct, %d incorrect.\n",
                exam3.passed(),
                exam3.totalCorrect(),
                exam3.totalIncorrect());
        exam3.printMissed();
    }
}
