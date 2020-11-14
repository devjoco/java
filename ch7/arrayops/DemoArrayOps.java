/**
 * ArrayOps Demo.
 * Demonstrate the class in a complete program with test data of various types
 */
public class DemoArrayOps {
    public static void main(String[] args) {
        int[] myInts = {1,4,7,9,3,6,8,234,9,45,32,45,3463,435,56,7,435,436};
        long[] myLongs = {124L, 2353L, 325324L, 23523L, 2323L, 234234L};
        float[] myFloats = {123.0F, 324.5F, 9923.9242F, 234.2432F, 23.93F};
        double[] myDoubles = {325324.2343, 32432.532, 123123.432, 23523.2341};

        // Check ArrayOps.getTotal()
        System.out.printf("Sum myInts: %d\n", ArrayOps.getTotal(myInts));
        System.out.printf("Sum myLongs: %d\n", ArrayOps.getTotal(myLongs));
        System.out.printf("Sum myFloats: %f\n", ArrayOps.getTotal(myFloats));
        System.out.printf("Sum myDoubles: %f\n", ArrayOps.getTotal(myDoubles));
        // Check ArrayOps.getAverage()
        // Check ArrayOps.getHighest()
        // Check ArrayOps.getLowest()

    }
}
