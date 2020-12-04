import java.text.DecimalFormat;

public class Circle {
    private double radius;

    public Circle(double radius) { this.radius = radius; }
    public Circle()              { this(0); }

    private double getArea()   { return Math.PI * radius * radius; }
    private double getRadius() { return radius; }

    public String toString() {
        DecimalFormat fmt = new DecimalFormat("0.#");
        return "{r:"+fmt.format(radius)+", a:"+fmt.format(getArea())+"}";
    }

    public boolean equals(Circle obj) {
        return this.radius == obj.radius;
    }

    public boolean greaterThan(Circle obj) {
        return this.getArea() > obj.getArea();
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(10.7);
        Circle c2 = new Circle(10.7);
        Circle c3 = new Circle();
        System.out.printf("c1: %s\n", c1);
        System.out.printf("c2: %s\n", c2);
        System.out.printf("c3: %s\n", c3);
        System.out.printf("c1 equal to c2? %b\n", c1.equals(c2));
        System.out.printf("c1 equal to c3? %b\n", c1.equals(c3));
        System.out.printf("c2 equal to c3? %b\n", c2.equals(c3));
        System.out.printf("c1 greater than c2? %b\n", c1.greaterThan(c2));
        System.out.printf("c1 greater than c3? %b\n", c1.greaterThan(c3));
        System.out.printf("c2 greater than c3? %b\n", c2.greaterThan(c3));
        System.out.printf("c2 greater than c1? %b\n", c2.greaterThan(c1));
        System.out.printf("c3 greater than c1? %b\n", c3.greaterThan(c1));
        System.out.printf("c3 greater than c2? %b\n", c3.greaterThan(c2));
    }
}
