/**
 * Algorithm Workbench problems from ch7.
 */
public class Workbench {
    public static void main(String[] args) {
        // Problem 1
        int[] names = new int[20];
        for(int name : names)
            System.out.print(name + " ");
        System.out.println();

        // Problem 2
        int[] numberArray1 = new int[100];
        int[] numberArray2 = new int[100];
        for(int i=0; i<numberArray1.length; i++)
            numberArray2[i] = numberArray1[i];
    }
}
