import java.io.*;

/**
 * Checkpoint 5.19 p320
 *
 * Write code that opens a file name MyName.txt, writes your first name to 
 * the file, and then closes the file.
 */
public class NameFileWrite {
    public static void main(String[] args) throws IOException {
        final String filename = "MyName.txt";

        File file = new File(filename);

        if(file.exists()) {
            System.out.println(filename + " already exists!");
            System.exit(1);
        }

        PrintWriter pr = new PrintWriter(filename);

        pr.println("Devon");

        pr.close();
    }
}
