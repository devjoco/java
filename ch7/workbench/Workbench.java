/**
 * Algorithm Workbench problems from ch7.
 */
public class Workbench {
    public static void main(String[] args) {
        // Problem 1
        int[] nums = new int[20];
        for(int num : nums)
            System.out.print(num + " ");
        System.out.println();

        // Problem 2
        int[] numberArray1 = new int[100];
        int[] numberArray2 = new int[100];
        for(int i=0; i<numberArray1.length; i++)
            numberArray2[i] = numberArray1[i];

        // Problem 3
        String[] names = {"Einstein", "Newton", "Copernicus", "Kepler"};
        for(String name : names)
            System.out.printf("(%s, %d) ", name, name.length());
        System.out.println();

        // Problem 4
        String[] countries   = {"USA", "Japan", "China", "India"};
        int[]    populations = {  328_200_000,   126_500_000,
                                1_393_000_000, 1_353_000_000};
        for(int i=0; i<countries.length; ++i)
            System.out.printf("(%s: %,d) ", countries[i], populations[i]);
        System.out.println();
    }
}
