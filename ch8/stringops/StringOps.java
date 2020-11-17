import java.util.StringTokenizer;

/**
 * Programming Challenges 1,2,3 Page 563.
 */
public class StringOps {

    /**
     * Convert alphanumeric telephone to numeric telephone number.
     * e.g. 1-800-GET-FOOD →  1-800-438-3663
     */
    public static String toPhoneNumber(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for(char ch: str.toCharArray()) {
            if(Character.isLetter(ch)) {
                char newChar, oldChar = Character.toUpperCase(ch);

                if     ("ABC".indexOf(oldChar)  != -1) newChar = '2';
                else if("DEF".indexOf(oldChar)  != -1) newChar = '3';
                else if("GHI".indexOf(oldChar)  != -1) newChar = '4';
                else if("JKL".indexOf(oldChar)  != -1) newChar = '5';
                else if("MNO".indexOf(oldChar)  != -1) newChar = '6';
                else if("PQRS".indexOf(oldChar) != -1) newChar = '7';
                else if("TUV".indexOf(oldChar)  != -1) newChar = '8';
                else if("WXYZ".indexOf(oldChar) != -1) newChar = '9';
                else                                   newChar = '?';
                sb.append(newChar);
            } else {
                sb.append(ch);
            }
        } 
        return sb.toString();
    }

    /**
     * Determine whether the given string meets the password reqs.
     *  - Should be at least 6 charaters long
     *  - Should contain at least one upper, lower, digit
     *  - Verbose option for req. hints or confirmation msg
     */
    public static boolean validatePassword(String str, boolean verbose) { 
        final int CHAR_NEEDED = 6;

        boolean reqsMet    = false;
        boolean upperFound = false;
        boolean lowerFound = false;
        boolean digitFound = false;
        boolean charsFound = false;
        int     charCount  = 0;
        
        for(char c: str.toCharArray()) {
            charCount++;
            if(Character.isUpperCase(c)) upperFound = true;
            if(Character.isLowerCase(c)) lowerFound = true;
            if(Character.isDigit(c))     digitFound = true;
            if(charCount >= CHAR_NEEDED) charsFound = true;
        } 

        if(upperFound && lowerFound && digitFound && charsFound) { 
            reqsMet = true;
            if(verbose)
                System.out.println("That password meets all requirements!");
        } else {
            System.out.println("Your password is missing some requirments!");
            if(!charsFound)
                System.out.println(" - Needs at least six characters");
            if(!upperFound)
                System.out.println(" - Needs at least one uppercase letter");
            if(!lowerFound)
                System.out.println(" - Needs at least one lowercase letter");
            if(!digitFound)
                System.out.println(" - Needs at least one digit");
        }

        return reqsMet;
    }

    /**
     * Return the number of vowels in the given String
     */
    public static int countVowels(String str) {
        int count = 0;
        for(char c: str.toCharArray())
            if("aeiouAEIOU".indexOf(c) != -1) 
                count++;
        return count;
    } 

    /**
     * Return the number of consonants in the given String
     */
    public static int countConsonants(String str) {
        int count = 0;
        for(char c: str.toCharArray())
            if(Character.isLetter(c) && "aeiouAEIOU".indexOf(c) == -1) 
                count++;
        return count;
    } 

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
     * e.g. countWords("Four score and seven years ago") → 6
     */
    public static int countWords(String str) {
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
