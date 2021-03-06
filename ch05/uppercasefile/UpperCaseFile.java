import java.util.Scanner;
import java.io.*;

/**
 * UpperCaseFile Class -- Programming Challenge 15 p330
 *
 * Write a class named UpperCaseFile. 
 *
 * The class's constructor should accept two file names as arguments.
 *
 * The first file should be opened for reading and the second file should 
 * be opened for writing. 
 * 
 * The class should read the contents of the first file, change all 
 * characters to uppercase, and store the results in the second file.
 *
 * The second file will be a copy of the first file, except all the characters 
 * will be uppercase.
 */
public class UpperCaseFile {
    String inFilename, outFilename;

    public UpperCaseFile(String in, String out) throws IOException {
        inFilename = in;
        outFilename = out;
        exitIfNoFile();
        copyToUpper();
    }

    private void exitIfNoFile() throws IOException {
        File inF        = new File(inFilename);
        if(!inF.exists()) {
            System.err.println("File " + inFilename + " doesn't exist!");
            System.exit(1);
        }
    }

    private void copyToUpper() throws IOException {
        Scanner     in  = new Scanner(new File(inFilename));
        PrintWriter out = new PrintWriter(new FileWriter(outFilename, true));

        while(in.hasNext()) 
            out.println(in.nextLine().toUpperCase());

        in.close();
        out.close();
    }
}
