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

    public static double getAverage(int[] arr) {
        return (double) getTotal(arr) / arr.length;
    }
    public static double getAverage(long[] arr) {
        return (double) getTotal(arr) / arr.length;
    }
    public static double getAverage(float[] arr) {
        return (double) getTotal(arr) / arr.length;
    }
    public static double getAverage(double[] arr) {
        return (double) getTotal(arr) / arr.length;
    }

    public static int getHighest(int[] arr) {
        int high = arr[0];
        for(int a: arr)
            if(a > high)
                high = a;
        return high;
    }
    public static long getHighest(long[] arr) {
        long high = arr[0];
        for(long a: arr)
            if(a > high)
                high = a;
        return high;
    }
    public static float getHighest(float[] arr) {
        float high = arr[0];
        for(float a: arr)
            if(a > high)
                high = a;
        return high;
    }
    public static double getHighest(double[] arr) {
        double high = arr[0];
        for(double a: arr)
            if(a > high)
                high = a;
        return high;
    }
}
