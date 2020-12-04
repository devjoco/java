/**
 * ArrayOps Demo.
 * Demonstrate the class in a complete program with test data of various types
 */
public class DemoArrayOps {
    public static void main(String[] args) {
        int[] myInts = {1,2,3,4,5};
        long[] myLongs = {1L, 2L, 3L, 4L, 5L};
        float[] myFloats = {1.0F, 2.0F, 3.0F, 4.0F, 5.0F};
        double[] myDoubles = {1.0D, 2.0D, 3.0D, 4.0D, 5.0D};

        // Check ArrayOps.getTotal()
        System.out.printf("Sum myInts: %d\n", ArrayOps.getTotal(myInts));
        System.out.printf("Sum myLongs: %d\n", ArrayOps.getTotal(myLongs));
        System.out.printf("Sum myFloats: %f\n", ArrayOps.getTotal(myFloats));
        System.out.printf("Sum myDoubles: %f\n", ArrayOps.getTotal(myDoubles));

        // Check ArrayOps.getAverage()
        System.out.printf("Avg myInts: %f\n", ArrayOps.getAverage(myInts));
        System.out.printf("Avg myLongs: %f\n", ArrayOps.getAverage(myLongs));
        System.out.printf("Avg myFloats: %f\n", ArrayOps.getAverage(myFloats));
        System.out.printf("Avg myDoubles: %f\n", ArrayOps.getAverage(myDoubles));

        // Check ArrayOps.getHighest()
        System.out.printf("High myInts: %d\n", ArrayOps.getHighest(myInts));
        System.out.printf("High myLongs: %d\n", ArrayOps.getHighest(myLongs));
        System.out.printf("High myFloats: %f\n", ArrayOps.getHighest(myFloats));
        System.out.printf("High myDoubles: %f\n", ArrayOps.getHighest(myDoubles));

        // Check ArrayOps.getLowest()
        System.out.printf("Low myInts: %d\n", ArrayOps.getLowest(myInts));
        System.out.printf("Low myLongs: %d\n", ArrayOps.getLowest(myLongs));
        System.out.printf("Low myFloats: %f\n", ArrayOps.getLowest(myFloats));
        System.out.printf("Low myDoubles: %f\n", ArrayOps.getLowest(myDoubles));


    }
}
