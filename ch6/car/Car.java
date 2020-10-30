public class Car {
    private FuelGauge fg;
    private Odometer  od;

    public Car(FuelGauge fg, Odometer od) {
        this.fg = new FuelGauge(fg);
        this.od = new Odometer(od);
    }
}
