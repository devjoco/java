package ch06.retail;

public class NegativePriceException extends IllegalArgumentException { 
    public NegativePriceException() {
        super("Negative prices not allowed");
    }

    public NegativePriceException(String msg) {
        super(msg);
    }
}
