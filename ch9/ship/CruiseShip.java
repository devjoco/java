public class CruiseShip extends Ship {
    private int maxPassengers;

    /* Constructor */
    public CruiseShip(String name, String year, int maxPassengers) {
        super(name, year);
        this.maxPassengers = maxPassengers;
    }

    /* Getters */
    public int getMaxPassengers() { return maxPassengers; }

    /* Setters */
    public void setMAxPassengers(int newMax) { maxPassengers = newMax; }

    @Override
    public String toString() {
        return super.toString() 
            + "\nCruiseShip" 
            + "\n\tMax Passengers: " + maxPassengers;
    }
}
