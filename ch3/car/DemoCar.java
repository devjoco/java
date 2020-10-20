public class DemoCar {
    public static void main(String[] args) {
        Car myCar = new Car(2001, "Ford");
        
        for(int i=0; i<5; i+=1) {
            myCar.accelerate();
            System.out.printf("Current Speed: %d\n", myCar.getSpeed());
        }
        for(int i=0; i<5; i+=1) {
            myCar.brake();
            System.out.printf("Current Speed: %d\n", myCar.getSpeed());
        }
    }
}
