import java.text.DecimalFormat;

public class RoomDimension {
    private double length;
    private double width;

    public RoomDimension(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public String toString() {
        return "room{"+length+"' x"+width+"'}";
    }
}
