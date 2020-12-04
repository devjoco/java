import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ChargeAccount {
    private int[] validNums;

    public ChargeAccount() {
        int[] defaultValidNums = { 100, 125, 130, 385, 452, 456,
            458, 505, 555, 565, 654, 757,
            782, 788, 789, 808, 845, 877 
        };
        validNums = defaultValidNums;
    }

    public ChargeAccount(String filename) throws IOException {
        validNums = getNumsFromFile(filename);
    }

    private int[] getNumsFromFile(String filename) throws IOException {
        File           file = new File(filename);
        Scanner        scan = new Scanner(file);
        ArrayList<Integer> nums = new ArrayList<>();
        int[] result;

        while(scan.hasNext())
            nums.add(scan.nextInt());
        scan.close();

        result = new int[nums.size()];
        for(int i=0; i<nums.size(); i++) {
            result[i] = nums.get(i).intValue();
        }

        return result;
    }

    public void showValids() {
        System.out.println("Valid Numbers:");
        for(int num: validNums)
            System.out.printf("%d ", num);
        System.out.println();
        System.out.println();
    }

    public boolean isValidSeq(int num, boolean verbose) {
        boolean found = false;
        for(int i=0; i<validNums.length; i++) {
            int elem = validNums[i];

            if(verbose)
                System.out.printf("Checking %d\n", elem);

            if(elem == num) {
                found = true;
                break;
            }
        }
        return found;
    }

    public boolean isValidBin(int num, boolean verbose) { 
        boolean found = false;
        int mid,
            elem,
            lower = 0,
            upper = validNums.length - 1;

        while(!found && lower <= upper) {
            mid = (upper + lower) / 2;
            elem = validNums[mid];

            if(verbose)
                System.out.printf("Checking %d\n", elem);

            if(elem == num)
                found = true;
            else if(elem > num)
                upper = mid - 1;
            else
                lower = mid + 1;
        }

        return found;
    }
}
