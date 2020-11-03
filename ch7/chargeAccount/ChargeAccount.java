public class ChargeAccount {
    private static int[] validNums = { 
        100, 125, 130, 385, 452, 456,
        458, 505, 555, 565, 654, 757,
        782, 788, 789, 808, 845, 877
    };

    public static void showValids() {
        for(int num: validNums)
            System.out.printf("%d ", num);
        System.out.println();
    }

    public static boolean isValidSeq(int num) {
        boolean found = false;
        for(int i=0; i<validNums.length; i++) {
            if(validNums[i] == num) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static boolean isValidBin(int num) { 
        boolean found = false;
        int mid,
            elem,
            lower = 0,
            upper = validNums.length - 1;

        while(!found && lower <= upper) {
            mid = (upper + lower) / 2;
            elem = validNums[mid];
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
