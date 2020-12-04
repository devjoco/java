public class Ship {
    private String name;
    private int    year;

    /* Constructor */
    public Ship(String name, int year) {
        this.name = name;
        this.year = year;
    }

    /* Getters */
    public String getName() { return name; } 
    public int    getYear() { return year; }
    
    /* Setters */
    public void setName(String name) { this.name = name; } 
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return "Ship"
            + "\n  - Name: " + name
            + "\n  - Year: " + year;
    }
}
