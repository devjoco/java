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
        boolean negL = l < 0.0;
        boolean negW = w < 0.0;
        if(negL && negW) {
            System.err.println("Length and width must be positive!");
        } else if(negL) {
            System.err.println("Length must be positive!");
        } else if(negW) {
            System.err.println("Width must be positive!");
        } else {
            ans = l * w;
        }
        return ans;
    }

    public static double triangleArea(double b, double h) {
        double ans = -1.0;
        boolean negB = b < 0.0;
        boolean negH = h < 0.0;
        if(negB && negH) {
            System.err.println("Base and height must be positive!");
        } else if(negB) {
            System.err.println("Base must be positive!");
        } else if(negH) {
            System.err.println("Height must be positive!");
        } else {
            ans = 0.5 * b * h;
        }
        return ans;
    }
}
