import java.util.Random;

/**
 * Lottery Application ─ Programming Challenge 9, page 506.
 *  - Should have array of 5 integers named lotteryNumbers
 *  - Constructor should generate random numbers from 0-9 for each
 *  - Have a method that takes array of 5 integers, returns matches
 *  - Have a method that returns copy of the lotteryNumbers array
 * e.g.                            ✓   ✓
 *      lotteryNumbers array:  7 4 9 1 3
 *              User's array:  4 2 9 7 3
 */
public class Lottery {
    public static final int NUM_PICKS = 5;
    public static final int MAX_VALUE = 9;

    private int[] lotteryNumbers = new int[NUM_PICKS];
    private Random rng = new Random();
    
    public Lottery() { 
        for(int i=0; i<NUM_PICKS; i++)
            lotteryNumbers[i] = rng.nextInt(MAX_VALUE + 1);
    }

    public int getMatches(int[] picks) {
        int count = 0;
        for(int i=0; i<NUM_PICKS; i++)
            if(lotteryNumbers[i] == picks[i])
                count++;
        return count;
    }

    public int[] getNumbers() {
        int[] copy = new int[NUM_PICKS];
        for(int i=0; i<NUM_PICKS; i++)
            copy[i] = lotteryNumbers[i];
        return copy;
    }
}
