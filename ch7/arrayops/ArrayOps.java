/**
 * ArrayOps class ─ Programming Challenge 10, page 507.
 * Write the following static methods
 *  1.) getTotal(int[])   : int
 *  2.) getAverage(int[]) : int
 *  3.) getHighest(int[]) : int
 *  4.) getLosest(int[])  : int
 *
 * Overload each method to accept double[], float[], and long[]
 */
public class ArrayOps {
    public static int getTotal(int[] arr) {
        int sum = 0;
        for(int a : arr)
            sum += a;
        return sum;
    }
    public static long getTotal(long[] arr) {
        long sum = 0;
        for(double a : arr)
            sum += a;
        return sum;
    }
    public static float getTotal(float[] arr) {
        float sum = 0.0f;
        for(float a : arr)
            sum += a;
        return sum;
    }
    public static double getTotal(double[] arr) {
        double sum = 0.0;
        for(double a : arr)
            sum += a;
        return sum;
    }
}
