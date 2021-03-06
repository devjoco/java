import java.util.Scanner;

/**
 * Lottery Application Demo.
 *  - Ask user to enter Lottery.NUM_PICKS numbers
 *  - Display the number of digits that match
 *  - If all match, display message proclaiming grand prize winner
 */
public class DemoLottery {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int[]   picks = new int[Lottery.NUM_PICKS];
        int     matches;
        String  ordStr;

        System.out.println("Pick your lotto numbers!");
        for(int i=0; i<Lottery.NUM_PICKS; i++) {
            ordStr = i==0? "st": i==1? "nd": i==2? "rd" : "th";
            System.out.printf("%d%s Number: ", i+1, ordStr);
            picks[i] = scan.nextInt();
            while(picks[i] < 0 || picks[i] > Lottery.MAX_VALUE) {
                System.out.printf("Invalid pick! Choose from 0-%d\n",
                        Lottery.MAX_VALUE);
            System.out.printf("%d%s Number: ", i+1, ordStr);
            picks[i] = scan.nextInt();
            }
        }
        System.out.println();

        Lottery lotto = new Lottery();
        matches = lotto.getMatches(picks);

        System.out.printf("You got %d correct.\n", matches);
        if(matches == Lottery.NUM_PICKS)
            System.out.println("You're a grand prize winner!");

        System.out.printf("%15s: %s\n%15s: %s\n",
                "Winning Numbers", arrToStr(lotto.getNumbers()),
                "Your Numbers", arrToStr(picks)
                );
    }

    public static String arrToStr(int[] arr) {
        String str = "[";
        for(int i=0; i<arr.length; i++) {
            str += arr[i];
            if(i != arr.length - 1)
                str += " ,";
        }
        str += "]";
        return str;
    }
}
