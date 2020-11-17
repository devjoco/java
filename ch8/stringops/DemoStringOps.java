import java.util.Scanner;

public class DemoStringOps {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String  str;

        System.out.println("Type something!");
        System.out.print("Your string: ");
        str = scan.nextLine();

        // Print the word, vowel, consonant counts
        System.out.printf("\nThat has %d words, %d vowels, & %d consonants\n",
                StringOps.countWords(str),
                StringOps.countVowels(str),
                StringOps.countConsonants(str));

        // Print the string with capitalized sentences
        System.out.println("\nYour string with capitalized sentences:");
        System.out.println(StringOps.toCapitalized(str));

        // Print the reverse of the string
        System.out.println("\nYour string reversed:");
        StringOps.printReverse(str);

        // Print whether the user's input would be a good password
        System.out.println("\nYour string if used as a password:");
        StringOps.validatePassword(str, true);
    }
}
