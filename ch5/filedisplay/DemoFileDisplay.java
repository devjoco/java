import java.io.*;

public class DemoFileDisplay {
    public static void main(String[] args) throws IOException {
        FileDisplay fd = new FileDisplay("sixlines.txt");
        fd.displayHead();
    }
}
