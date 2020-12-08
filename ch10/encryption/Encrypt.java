import java.util.Scanner;
import java.io.*;

public class Encrypt {
    public static void usage() {
        System.out.println("Usage: java Encrypt [-d] <filename> <password>");
        System.exit(0);
    }

    public static int getOffset(String password) {
        int sum = 0;
        for(int i=0; i<password.length(); i++)
            sum += (int) password.charAt(i);
        return sum;
    }

    public static void main(String[] args) throws IOException {
        /* Make sure a filename is given and a password is given. */
        boolean twoArgs = args.length == 2;
        boolean threeArgs = args.length == 3;
        if(!twoArgs 
                && !threeArgs && !args[0].equals("-d"))
            Encrypt.usage();

        Scanner       inFile   = null;
        PrintWriter   outFile  = null;
        String        filename = args[args.length - 2];
        String        password = args[args.length - 1];
        boolean       decrypt  = threeArgs? true: false;
        int           offset;
        String        thisLine;
        StringBuilder newLine;
        int           numChars;
        char          thisChar;


        /* Open the given file for reading. */
        try {
            inFile = new Scanner(new File(filename));
        } catch(FileNotFoundException e) {
            System.out.println("That file doesn't exist.");
            System.exit(0);
        }

        /* Open another file for writing. */
        outFile = new PrintWriter(new File(filename + ".enc"));

        /* Figure out what offset for chars will be based on password. */
        offset = getOffset(password);

        /* Read each character into second file according to offset. */
        while(inFile.hasNext()) {
            thisLine = inFile.nextLine();
            numChars = thisLine.length();
            newLine  = new StringBuilder(numChars);

            for(int i=0; i<numChars; i++) {
                thisChar = thisLine.charAt(i);
                newLine.append((char) (((int)thisChar + offset) % 65536));
            }

            outFile.println(newLine);
        }
        

        /* Close the files. */
        inFile.close();
        outFile.close();
    }
}
