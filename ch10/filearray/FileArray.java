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
    public static void readArray(String filename, int[] arrayRef) 
        throws IOException
    {
        DataInputStream file = new DataInputStream(
                new FileInputStream(filename));
        boolean EOFReached = false;
        int pos = 0;
        while(!EOFReached) {
            try {
                arrayRef[pos] = file.readInt();
                pos++;
            } catch(EOFException e) {
                EOFReached = true;
            }
        }
        file.close();
    }

    /* Demostrate writeArray and readArray in program. */
    public static void main(String[] args) 
            throws IOException 
    {
        int[] intsToWrite = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] intsToRead  = new int[intsToWrite.length];

        /* Print out starting values for intsToWrite */
        System.out.print("intsToWrite: ");
        for(int i: intsToWrite)
            System.out.print(i + " ");
        System.out.print("\n");

        /* Print out starting values for intsToRead */
        System.out.print("intsToRead: ");
        for(int i: intsToRead)
            System.out.print(i + " ");
        System.out.print("\n");

        /* Write intsToWrite to myInts.bin */
        System.out.println("Writing intsToWrite to myInts.bin");
        FileArray.writeArray("myInts.bin", intsToWrite);

        /* Read myInts.bin into intsToRead */
        System.out.println("Reading myInts.bin into intsToRead");
        FileArray.readArray("myInts.bin", intsToRead);

        /* Print out final values for intsToWrite */
        System.out.print("intsToWrite: ");
        for(int i: intsToWrite)
            System.out.print(i + " ");
        System.out.print("\n");

        /* Print out final values for intsToRead */
        System.out.print("intsToRead: ");
        for(int i: intsToRead)
            System.out.print(i + " ");
        System.out.print("\n");

    }
}
