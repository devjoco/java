public class IllegalMonthOrdinalException extends IllegalArgumentException {
    public IllegalMonthOrdinalException() {
        super("Valid month range: 1-12");
    }

    public IllegalMonthOrdinalException(String msg) {
        super(msg);
    }
}
