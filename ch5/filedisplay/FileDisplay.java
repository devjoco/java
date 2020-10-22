import java.util.Scanner;
import java.io.*;

/**
 * FileDisplay Class -- Programming Challenge 14 p330
 */
public class FileDisplay {
    private String filename;

    /**
     * Constructor:
     * Should take the name of a file as an argument.
     */
    public FileDisplay(String name) {
        filename = name;
    }

    /**
     * displayHead: 
     * Should display only the first five lines of the file's contents.
     * If the file contains less than five lines, it should display the 
     * file's entire contents.
     */
    public void displayHead() throws IOException {
        final MAX_LINES = 5;
        // Check if file exists, exit if not
        File f = new File(filename);
        if(!f.exists()) {
            System.out.println("File " + filename + " doesn't exist.");
            System.exit(1);
        }

        // Create scanner, print up to five lines
        Scanner inFile = new Scanner(f);
        for(int i=0; i<MAX_LINES; i++) {
            if(!inFile.hasNext())
                break;
            System.out.println(inFile.nextLine());
        }
        
    }

    /**
     * displayContents:
     * Should display the entire contents of the file, the name of which was 
     * passed to the constructor.
     */

    /**
     * displayWithLineNumbers:
     * Should display the contents of the file.
     * Each line should be preceded with a line number followed by a colon. 
     * The line numbering should start at 1.
     */
}
