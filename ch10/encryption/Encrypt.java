public class Encrypt {
    public static void usage() {
        System.out.println("Usage: java Encrypt <filename> <password>");
        System.exit(0);
    }

    public static void main(String[] args) {
        boolean twoArgs = args.length == 2;
        if(!twoArgs)
            Encrypt.usage();
    }
}
