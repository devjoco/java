import java.util.Scanner;
import java.io.*;

/**
 * Checkpoint 5.21 p320
 *
 * Write code that opens a file name MyName.txt, reads the first line from 
 * the file and displays it, and then closes the file.
 */
public class NameFileRead {
    public static void main(String[] args) throws IOException {
        final String filename = "MyName.txt";

        File file = new File(filename);

        if(!file.exists()) {
            System.out.println(filename + " doesn't exist!");
            System.exit(1);
        }

        Scanner inFile = new Scanner(file);
        System.out.println(inFile.nextLine());
        inFile.close();
    }
}
