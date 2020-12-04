public class RoomDimension {
    private double length;
    private double width;

    public RoomDimension(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public RoomDimension(RoomDimension size) { 
        this(size.length, size.width);
    }

    public double getArea() {
        return length * width;
    }
    
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public String toString() {
        return "room{"+length+"' x "+width+"'}";
    }
}
