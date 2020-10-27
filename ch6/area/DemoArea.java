public class DemoArea {
    public static void main(String[] args) {
        Circle    shape1 = new Circle(8.3);
        Cylinder  shape2 = new Cylinder(8.3, 9.2);
        Rectangle shape3 = new Rectangle(8.3, 9.2);
        System.out.printf("shape1 area: %.2f\n", Area.getArea(shape1));
        System.out.printf("shape2 area: %.2f\n", Area.getArea(shape2));
        System.out.printf("shape3 area: %.2f\n", Area.getArea(shape3));
    }
}
