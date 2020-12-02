/**
 * Algorithm Workbench Ch9 p637.
 */

/**
 * 1.) Write the first line of the definition for a Poodle class.
 * The class should inherit from the Dog class.  */
public class Poodle extends Dog

/**
 * 2.) Look a the following code which is the first line of a class definition:
 *          public class Tiger extends Felis
 *     In what order will the class constructors execute?  */
Felis 1st and Tiger 2nd


/**
 * 3.) Write the declaration for a class B. The class's members should be:
 *      - m, an integer. This variable should not be accessible to code outside
 *        the class or to any class that inherits from class B.
 *      - n, an integer. This variable should be accessible only to classes 
 *        that inherit from class B or in the same package as class B.
 *      - setM, getM, setN, and getN. These are the mutator and accessor 
 *        methods for the member variables m and n. These methods should be 
 *        accessible to code outisde the class.
 *      - calc. This is a public abstract method.
 *
 *    Next write the ealation for class D, which inherits form class B. The 
 *    class's members should be:
 *      - q, a double. This variable should not be accessible to code outside 
 *        of the class.
 *      - r, a double. This variable hsould be accessible to any class that 
 *        extends class D or in the same package.
 *      - setQ, get!, setR, getR. These are the mutator and accessor emthods 
 *        for the member variables q and r. These methods should be accessible 
 *        to code outside the class.
 *      - calc, a public method that overrides the superclass's abstract calc 
 *        method. This mehtod should return the value of q times r.  */
public class B {
    private int m;
    protected int n;
    public void setM(int newM) { m = newM; }
    public void setN(int newN) { n = newN; }
    public int  getM()         { return m; }
    public int  getN()         { return n; }
    public abstract double calc();
}
public class D extends B {
    private double q;
    protected double r;
    public void setQ(int newQ) { q = newQ; }
    public void setR(int newR) { r = newR; }
    public int  getQ()         { return q; }
    public int  getR()         { return r; }
    @Override
    public double calc() { return q * r; }
}

/**
 * 4.) Write teh statement that calls a superclass constructor and passes the 
 *     arguments x, y, and z.  */
super(x,y,z);

/**
 * 5.) A superclass has teh following method:
 *          public void setValue(int v) {
 *              value = v;
 *          }
 *     Write a statment that can appear in a sublcass that calls this method, 
 *     passing 10 as an argument.  */
super.setValue(4);

/**
 * 6.) A superclass has the following abstract method:
 *          public abstract int getValue();
 *     Write an example of a getValue method that can appear in a subclass.  */
@Override
public int getValue() {
    return "Value";
}

/**
 * 7.) Write the first line of the definiton for a Stereo class. 
 * The class should inherit from the SoundSystem class, and it should implement
 * the CDplayable, TunerPlayable, and CassettePlayable interfaces.  */
public class Stereo extends SoundSystem 
    implements CDPlayable, TunerPlayable, CassettePlayable {
    return null;
}

/**
 * 8.) Write an interface named Nameable that specifies the following methods:
 *          public void setName(String n)
 *          public String getName() */
public interface Nameable {
    public void setName(String n);
    public String getName();
}
