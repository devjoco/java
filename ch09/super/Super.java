/**
 * A Super class with a no-arg constructor, and an int constructor.
 * The sub class Sub does not call super() in its constructor, so a default
 * no-arg constructor is necessary in addition to the int constructor.
 */
public class Super {
    public Super() {
        System.out.println("Super");
    }
    public Super(int x) {
        System.out.println("Super" +x);
    }
}
