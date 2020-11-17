import java.util.StringTokenizer;

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
        StringTokenizer st = new StringTokenizer(str);
        return st.countTokens();
    }

    /**
     * Return a copy of the given string with the first char of 
     * each sentence capitalized.
     * e.g. toCapitalized("hello. my name is Joe. what is your name?")
     *        → "Hello. My name is Joe. What is your name?"
     */
    public static String toCapitalized(String str) {
        String token, DELIMS = ".!?";
        StringBuilder strb = new StringBuilder(str.length());
        StringTokenizer st = new StringTokenizer(str, DELIMS, true);
        int pos;

        while(st.hasMoreTokens()) {
            token = st.nextToken();
            if(DELIMS.indexOf(token) != -1) {
                strb.append(token);
            } else {
                pos = 0;
                while(Character.isWhitespace(token.charAt(pos))) {
                    strb.append(token.charAt(pos));
                    pos++;
                }
                strb.append(Character.toUpperCase(token.charAt(pos)));
                pos++;
                strb.append(token.substring(pos));
            }
        }

        return strb.toString();
    }
}
