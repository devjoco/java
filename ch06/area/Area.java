public class Area {

    public static double getArea(Circle cir) {
        return Math.pow(cir.getRadius(), 2) * Math.PI;
    }

    public static double getArea(Rectangle rect) {
        return rect.getWidth() * rect.getLength();
    }

    public static double getArea(Cylinder cyl) {
        return 2 * Math.PI * cyl.getRadius() 
            * (cyl.getRadius() + cyl.getHeight());
    }
}
