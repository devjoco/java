import java.util.Scanner;
/**
 * Ch.2 p.114 - Programing Challenge 4
 * Write a program that displays the following pattern:
 *    *   
 *   ***
 *  *****
 * *******
 *  *****
 *   ***
 *    *
 *
 * Problem has been adapted to allow for any odd number, either entered as 
 * an argument to main when run or entered by the user as a propmt.
 * */
public class Star {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        int STAR_WIDTH;
        STAR_WIDTH = args.length == 1? Integer.parseInt(args[0]) : 0;
        while( STAR_WIDTH % 2 == 0 || STAR_WIDTH < 0 ) {
            System.out.print("Enter a positive odd number: ");
            STAR_WIDTH = keyboard.nextInt();
        }
        float HALF_WIDTH = STAR_WIDTH / 2.0F; 
        int stars, blanks;

        for(int i = 0; i < STAR_WIDTH; i += 1) {
            // Calculate num stars in row i
            stars = i * 2 + 1 
                // This subtraction only happens if i < HALF_WIDTH
                - (int)(4 * (i - (int)HALF_WIDTH) * (int)(i / HALF_WIDTH));

            // Calc num blanks in row
            blanks = STAR_WIDTH - stars;

            // Print blanks before stars
            for(int j = 0; j < blanks / 2; j += 1)
                System.out.print(' ');

            // Print stars
            for(int j = 0; j < stars; j += 1)
                System.out.print('*');

            // Print blanks after stars and newline
            for(int j = 0; j < blanks / 2; j += 1)
                System.out.print(' ');

            System.out.println();
        }
    }
}
