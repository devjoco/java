import java.util.Scanner;

public class DemoStringOps {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String  str;

        System.out.println("Enter a string to be reversed.");
        System.out.print("Str: ");
        str = scan.nextLine();
        System.out.print("Rvs: ");
        StringOps.printReverse(str);

        System.out.println("\nEnter a string to be counted.");
        System.out.print("Str: ");
        str = scan.nextLine();
        System.out.print("Word count: ");
        System.out.println(StringOps.getWordCount(str));
        
        System.out.println("\nEnter a string to be capitalized.");
        System.out.print("Str: ");
        str = scan.nextLine();
        System.out.print("Cap: ");
        System.out.println(StringOps.toCapitalized(str));
    }
}
