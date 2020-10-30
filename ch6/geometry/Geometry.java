/**
 * A geometry class with three static methods.
 *
 *   1.) circleArea(double)            →  double
 *   2.) rectangleArea(double, double) →  double
 *   3.) triangleArea(double, double)  →  double
 */
public class Geometry {
    public static double circleArea(double r) {
        double ans = -1.0;
        if(r < 0.0) {
            System.err.println("Radius must be positive!");
        } else {
            ans = Math.PI * r * r;
        }
        return ans;
    }

    public static double rectangleArea(double l, double w) {
        double ans = -1.0;
        if(l < 0.0) {
            System.err.println("Length must be positive!");
        } else if(w < 0.0) {
            System.err.println("Width must be positive!");
        } else {
            ans = l * w;
        }
        return ans;
    }

    public static double triangleArea(double b, double h) {
        double ans = -1.0;
        if(b < 0.0) {
            System.err.println("Base must be positive!");
        } else if(h < 0.0) {
            System.err.println("Height must be positive!");
        } else {
            ans = 0.5 * b * h;
        }
        return ans;
    }
}
