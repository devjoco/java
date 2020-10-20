public class Car {
    // Fields
    private int    yearModel;
    private int    speed;
    private String make;

    // Constructor
    public Car(int yrMdl, String mk) {
        yearModel = yrMdl;
        make      = mk;
        speed     = 0;
    }

    // Setters
    public void setMake(String newMake)   { make = newMake; }
    public void setYearModel(int newYear) { yearModel = newYear; }
    public void accelerate()              { speed += 5; }
    public void brake()                   { speed -= 5; }
    
    // Getters
    public String getMake()      { return make; }
    public int    getYearModel() { return yearModel; }
    public int    getSpeed()     { return speed; }
}
