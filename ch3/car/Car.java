public class Car {
    private String make;
    private int yearModel;

    public void setMake(String newMake) {
        make = newMake;
    }
    public void setYearModel(int newYear) {
        yearModel = newYear;
    }
    public String getMake() {
        return make; 
    }
    public int getYearModel() {
        return yearModel;
    }

    public static void main(String[] args) {
        Car limo = new Car();

        limo.setMake("Cadillac");

        String myLimoMake = limo.getMake();
        System.out.println(myLimoMake);
    }
}
