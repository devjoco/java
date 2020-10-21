import java.util.Scanner;
import java.io.*;

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
