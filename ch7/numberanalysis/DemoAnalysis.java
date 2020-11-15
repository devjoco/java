import java.io.*;

public class DemoAnalysis {
    public static void main(String[] args) throws IOException {
        NumberAnalysis a = new NumberAnalysis("numbers.txt");
        System.out.println(a.getLowest());
        System.out.println(a.getHighest());
        System.out.println(a.getTotal());
        System.out.println(a.getAverage());
    }
}
