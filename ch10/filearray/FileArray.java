import java.io.*;

public class FileArray {
    /* Open file as binary file, write contents of array, close file. */
    public static void writeArray(String filename, int[] arrayRef) 
        throws IOException 
    {
        DataOutputStream file = new DataOutputStream(
                new FileOutputStream(filename));
        for(int i: arrayRef)
            file.writeInt(i);
        file.close();
    }

    /* Open file as binary file, read contents into array, close file. */
    public static void readArray(String filename, int[] arrayRef) {
    }

    /* Demostrate writeArray and readArray in program. */
    public static void main(String[] args) {
    }
}
