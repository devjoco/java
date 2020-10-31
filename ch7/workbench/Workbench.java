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
            System.out.print(name + " " + name.length() + ",");
        System.out.println();
    }
}
