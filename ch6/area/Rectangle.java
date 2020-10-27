public class Rectangle {
    private double length, width;
    public Rectangle(double l, double w) { 
        length = l; 
        width = w;
    }
    public double getLength() { return length; }
    public double getWidth() { return width; }
    public String toString() { return "Rectangle{l="+length+" w="+width+"}"; }
}
