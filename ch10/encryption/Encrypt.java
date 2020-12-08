import java.util.Scanner;
import java.io.*;

public class Encrypt {
    public static void usage() {
        System.out.println("Usage: java Encrypt <filename> <password>");
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        /* Make sure a filename is given and a password is given. */
        boolean twoArgs = args.length == 2;
        if(!twoArgs)
            Encrypt.usage();

        Scanner     inFile   = null;
        PrintWriter outFile  = null;
        String      filename = args[0];
        String      password = args[1];

        /* Open the given file for reading. */
        try {
            inFile = new Scanner(new File(filename));
        } catch(FileNotFoundException e) {
            System.out.println("That file doesn't exist.");
            System.exit(0);
        }

        /* Open another file for writing. */
        outFile = new PrintWriter(new File(filename + ".enc"));

        /* Read each character into second file offset according to pw. */
        /* Close the files. */
        inFile.close();
        outFile.close();
    }
}
