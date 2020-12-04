public class Ship {
    private String name;
    private String year;

    /* Constructor */
    public Ship(String name, String year) {
        this.name = name;
        this.year = year;
    }

    /* Getters */
    public String getName() { return name; } 
    public String getYear() { return year; }
    
    /* Setters */
    public void setName(String name) { this.name = name; } 
    public void setYear(String year) { this.year = year; }

    @Override
    public String toString() {
        return super.toString()
            + "\nShip"
            + "\n\tName: " + name
            + "\n\tYear: " + year;
    }
}
