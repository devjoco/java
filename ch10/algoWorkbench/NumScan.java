import java.util.Scanner;

public class NumScan {
    public static int[] numberList = {1, 3, 6, 3, 5, 8, 2, 25, 13, 90, 32, 12};

    public static int findNumber(int x) throws Exception {
        for(int i=0; i<NumScan.numberList.length; i++) {
            if(NumScan.numberList[i] == x)
                return i;
        }
        throw new Exception("Element not found");
    }


    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("What number are you looking for?");
        System.out.print("Number: ");
        int val   = scan.nextInt();
        int index = NumScan.findNumber(val);
        System.out.printf("%d is at index %d\n", val, index);
    }
}
