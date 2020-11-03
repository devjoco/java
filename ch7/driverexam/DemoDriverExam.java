public class DemoDriverExam {
    public static void main(String[] args) {
        char[] testPassAns = {
            'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D',
            'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'
        };
        char[] testFailAns = {
            'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B', 
            'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D'
        };
        DriverExam exam1 = new DriverExam(testPassAns);
        System.out.println(exam1.passed());
        DriverExam exam2 = new DriverExam(testFailAns);
        System.out.println(exam2.passed());
    }
}
