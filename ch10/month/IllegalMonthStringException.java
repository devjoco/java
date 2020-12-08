public class IllegalMonthStringException extends IllegalArgumentException {
    public IllegalMonthStringException() {
        super("Valid Month Strings: January, February, March, ... Decemeber");
    }

    public IllegalMonthStringException(String msg) {
        super(msg);
    }
}
