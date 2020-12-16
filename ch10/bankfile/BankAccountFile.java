public class BankAccountFile {
    private final int RECORD_SIZE;
    private RandomAccessFile bankFile;

    public BankAccountFile(String filename) 
            throws FileNotFoundException {
        bankFile = new RandomAccessFile(filename, "rw");
    }

    public void writeBankAccount(BankAccount account) throws IOException {} 
    public BankAccount readBankAccount() throws IOException {}

    private long getByteNum(long recordNum) {
        return RECORD_SIZE * recordNum;
    }

    public void moveFilePointer(long recordNum) throws IOException {} 
    public long getNumberOfRecords() throws IOException {} 
    public void close() throws IOException {}
}
