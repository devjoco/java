public class ChargeAccount {
    private static int[] validNums = { 
        100, 125, 130, 385, 452, 456,
        458, 505, 555, 565, 654, 757,
        782, 788, 789, 808, 845, 877
    };

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
        return false;
    }


}
