/**
 * Programming Challenges 1,2,3 Page 563.
 */
public class StringOps {
    /**
     * Display the given String in reverse.
     * e.g. printReverse("gravity") → "ytivarg"
     */
    public static void printReverse(String str) {
        StringBuilder strb = new StringBuilder(str.length());
        for(int i=str.length()-1; i>=0; i--)
            strb.append(str.charAt(i));
        System.out.println(strb);
    }

    /**
     * Return the number of words in the given String.
     * e.g. getWordCount("Four score and seven years ago") → 6
     */
    public static int getWordCount(String str) {
        int ans = 0;
        return ans;
    }

    /**
     * Return a copy of the given string with the first char of 
     * each sentence capitalized.
     * e.g. toCapitalized("hello. my name is Joe. what is your name?")
     *        → "Hello. My name is Joe. What is your name?"
     */
    public static String toCapitalized(String str) {
        StringBuilder strb = new StringBuilder(str.length());
        return strb.toString();
    }
}
