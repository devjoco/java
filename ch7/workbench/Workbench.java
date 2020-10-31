/**
 * Algorithm Workbench problems from ch7.
 */
public class Workbench {
    public static void main(String[] args) {
        // Problem 1
        System.out.println("Problem 1");
        int[] nums = new int[20];
        for(int num : nums)
            System.out.print(num + " ");
        System.out.println();
        System.out.println();

        // Problem 2
        System.out.println("Problem 2");
        int[] numberArray1 = new int[100];
        int[] numberArray2 = new int[100];
        for(int i=0; i<numberArray1.length; i++)
            numberArray2[i] = numberArray1[i];
        System.out.println();
        System.out.println();

        // Problem 3
        System.out.println("Problem 3");
        String[] names = {"Einstein", "Newton", "Copernicus", "Kepler"};
        for(String name : names)
            System.out.printf("(%s, %d) ", name, name.length());
        System.out.println();
        System.out.println();

        // Problem 4
        System.out.println("Problem 4");
        String[] countries   = {"USA", "Japan", "China", "India"};
        int[]    populations = {  328_200_000,   126_500_000,
                                1_393_000_000, 1_353_000_000};
        for(int i=0; i<countries.length; ++i)
            System.out.printf("(%s: %,d) ", countries[i], populations[i]);
        System.out.println();
        System.out.println();

        // Problem 5
        System.out.println("Problem 5");
        int[] ids = {123,234,345,456,567,678,789,890,901,012};
        double[] grossPay = {12.3,23.4,34.5,45.6,56.7,67.8,78.9,89.0,90.1,1.2};
        for(int i=0; i<ids.length; i++)
            System.out.printf("(%d: %.2f) ", ids[i], grossPay[i]);
        System.out.println();
        System.out.println();

        // Problem 6
        System.out.println("Problem 6");
        int[][] grades = {{94,93,94,92,88,93,94,92,81,91}, 
                          {76,86,77,82,79,96,80,63,97,67},
                          {77,97,76,78,76,95,77,62,93,79},
                          {80,96,75,70,84,93,83,72,94,74},
                          {79,95,74,62,79,92,86,58,92,77},
                          {80,94,73,82,84,98,85,69,97,76},
                          {82,93,72,82,69,95,76,58,89,70},
                          {84,92,71,78,84,92,81,68,94,76},
                          {76,91,70,76,78,94,81,54,92,78},
                          {85,90,69,74,78,97,79,77,95,67},
                          {76,89,68,86,79,94,84,54,96,79},
                          {82,97,67,74,85,95,82,63,94,76},
                          {76,96,66,82,79,97,83,67,96,69},
                          {83,95,65,78,79,94,86,62,92,76},
                          {76,94,64,80,79,97,79,72,95,78},
                          {83,93,63,79,87,93,85,64,96,67},
                          {83,92,62,77,83,97,82,58,92,78},
                          {78,91,61,86,83,97,81,74,96,76},
                          {80,90,60,78,82,93,86,69,96,70},
                          {76,89,55,79,74,98,86,94,92,76},
                          {77,97,44,80,85,95,80,79,96,79},
                          {78,96,24,81,79,97,85,64,93,70},
                          {78,95,66,82,82,98,92,54,95,81},
                          {79,94,46,83,79,96,79,60,93,69},
                          {84,93,74,84,82,92,80,54,96,79},
                          {81,92,76,85,79,97,81,62,94,76},
                          {82,91,73,72,73,95,82,61,95,69},
                          {83,90,71,73,85,97,83,59,95,76},
                          {84,89,70,75,75,96,71,57,92,78},
                          {86,97,69,74,77,92,69,55,96,74},
        };
        System.out.println();
        System.out.println();

        // Problem 7
        System.out.println("Problem 7");
        double avg;
        int total = 0;
        for(int[] row: grades)
            for(int grade: row)
                total += grade;
        avg = (double)total / (grades.length * grades[0].length);
        System.out.printf("Average Grade: %.2f", avg);
        System.out.println();
        System.out.println();

        // Problem 8
        System.out.println("Problem 8");
        int[][] numberArray = new int[9][11];
        int lastRow = numberArray.length-1;
        int lastCol = numberArray[0].length-1;
        numberArray[0][0] = 145;
        numberArray[lastRow][lastCol] = 145;
        System.out.println();
        System.out.println();

        // Problem 9
        System.out.println("Problem 9");
        double[][] values = {{0,1,2,3,4,5,6,7,8,9}, {0,1,2,3,4,5,6,7,8,9},
                             {0,1,2,3,4,5,6,7,8,9}, {0,1,2,3,4,5,6,7,8,9},
                             {0,1,2,3,4,5,6,7,8,9}, {0,1,2,3,4,5,6,7,8,9},
                             {0,1,2,3,4,5,6,7,8,9}, {0,1,2,3,4,5,6,7,8,9},
                             {0,1,2,3,4,5,6,7,8,9}, {0,1,2,3,4,5,6,7,8,9}, };
        double valuesTotal = 0;
        for(double[] row: values)
            for(double value: row)
                valuesTotal += value;
        System.out.printf("valuesTotal: %.0f", valuesTotal);
        System.out.println();
        System.out.println();

        // Problem 10
        System.out.println("Problem 10");
        System.out.println();
        System.out.println();

        // Problem 11
        System.out.println("Problem 11");
        System.out.println();
        System.out.println();
    }
}
