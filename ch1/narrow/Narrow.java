/**
 * Checkpoint 2.26 page 74
 *
 * This deals with storing double value into a float variable.
 *
 * The double is possibly larger than the float variable can hold, so Java
 * will not automatically convert the double to a float b/c of a possible 
 * loss of precision. 
 *
 * The solution is to cast the double as a float before storing in the variable
 */
public class Narrow {
    public static void main(String[] args){
        float a = 1.2F;         // A var of type float
        double b = 4.8;         // A var of type double
        a = (float) b;          // double must be cast as float to fit
        System.out.println(a);
        System.out.println(b);
    }
}
