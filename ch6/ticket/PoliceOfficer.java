public class PoliceOfficer {
    private String name;
    private int badgeNumber;

    public PoliceOfficer(String name, int badgeNumber) {
        this.name = name;
        this.badgeNumber = badgeNumber;
    }

    public String getName()        { return name;        }
    public int    getBadgeNumber() { return badgeNumber; }
}
