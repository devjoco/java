/**
 * Checkpoint 2.25 emphasizes the internal workings of byte, char, and short
 * arithmetic. Each are converted to int before mathematical operations
 * occur on them, and so adding two shorts will result in integer addition. 
 * This will cause an error if you attempt to save this result in a short-type 
 * variable.
 */
public class CP2_25 {
    /*
     * The solution to this is to either cast the resulting integer divition to
     * the type of short, or to declare the variable that is to hold the result
     * as an int.
     */
    public static void main(String[] args){
        /**
         * totalPay, basePay, and bonus are all declared as shorts
         */
        short totalPay, basePay = 500, bonus = 1000;
        /*
         * totalPay is assigned the result casted to a short
         */
        totalPay = (short) (basePay + bonus);
        // This next line prints out total
        System.out.println(totalPay);
    }
}
