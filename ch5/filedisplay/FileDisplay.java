import java.util.Scanner;
import java.io.*;

/**
 * FileDisplay Class -- Programming Challenge 14 p330
 */
public class FileDisplay {
    private String filename;
    final private int HEAD_NUM = 5, ALL_LINES_SIGNAL = -1; 

    /**
     * Constructor:
     * Should take the name of a file as an argument.
     */
    public FileDisplay(String name) {
        filename = name;
    }

    /**
     * display:
     * helper class used by other classes
     */
    public void display(int maxLines, boolean numbered) throws IOException {
        // Check if file exists, exit if not
        File f = new File(filename);
        if(!f.exists()) {
            System.out.println("File " + filename + " doesn't exist.");
            System.exit(1);
        }

        // Create scanner, print necessary lines
        Scanner inFile = new Scanner(f);
        int linesRead = 0;
        while(inFile.hasNext()) {
            if(maxLines != ALL_LINES_SIGNAL && linesRead >= maxLines)
                break;
            linesRead++;
            if(numbered)
                System.out.print(linesRead + ": ");
            System.out.println(inFile.nextLine());
        }
        inFile.close();
    }

    /**
     * displayHead: 
     * Should display only the first five lines of the file's contents.
     * If the file contains less than five lines, it should display the 
     * file's entire contents.
     */
    public void displayHead() throws IOException {
        display(HEAD_NUM, false);
    }

    /**
     * displayContents:
     * Should display the entire contents of the file, the name of which was 
     * passed to the constructor.
     */
    public void displayContents() throws IOException {
        display(ALL_LINES_SIGNAL, false);
    }

    /**
     * displayWithLineNumbers:
     * Should display the contents of the file.
     * Each line should be preceded with a line number followed by a colon. 
     * The line numbering should start at 1.
     */
    public void displayWithLineNumbers() throws IOException {
        display(ALL_LINES_SIGNAL, true);
    }
}
