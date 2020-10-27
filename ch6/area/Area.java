public class Area {

    public static double getArea(Circle cir) {
        return Math.pow(cir.radius, 2) * Math.PI;
    }

    public static double getArea(Rectangle rect) {
        return rect.width * rect.length;
    }

    public static double getArea(Cylinder cyl) {
        return 2 * Math.PI * cyl.radius * (cyl.radius + cyl.height);
    }
}
