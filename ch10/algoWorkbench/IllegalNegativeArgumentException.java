public class IllegalNegativeArgumentException extends IllegalArgumentException{

    public IllegalNegativeArgumentException() {
        super("Error: Illegal negative argument");
    }

    public IllegalNegativeArgumentException(String msg) {
        super(msg);
    }
}
