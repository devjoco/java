import java.io.*;

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
