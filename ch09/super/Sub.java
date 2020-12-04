/**
 * A subclass that extends from Super. 
 * The Super class's no-arg constructor is necessary because this class
 * does not call the Super's int constructor, and so by default a no-arg
 * constructor call will be made from this class's constructor.
 */
public class Sub extends Super {
    public Sub(int x) {
        System.out.println("Sub: " + x);
    }
}
