public class DemoArea {
    public static void main(String[] args) {
        Circle    shape1 = new Circle(8.3);
        Cylinder  shape2 = new Cylinder(8.3, 9.2);
        Rectangle shape3 = new Rectangle(8.3, 9.2);
        System.out.printf("%s area: %.2f\n", shape1, Area.getArea(shape1));
        System.out.printf("%s area: %.2f\n", shape2, Area.getArea(shape2));
        System.out.printf("%s area: %.2f\n", shape3, Area.getArea(shape3));
    }
}
