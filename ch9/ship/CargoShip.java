public class CargoShip extends Ship {
    private int capacity;

    /* Constructor */
    public CargoShip(String name, String year, int capacity) {
        super(name, year);
        this.capacity = capacity;
    }

    /* Getters */
    public int getCapacity() { return capacity; }

    /* Setters */
    public void setCapacity(int newCap) { capacity = newCap; }

    @Override
    public String toString() {
        return super.toString()
            + "\nCargoShip"
            + "\n\tCapacity: " + capacity;
    }
}
