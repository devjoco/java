public class PoliceOfficer {
    private String name;
    private int badgeNumber;

    public PoliceOfficer(String name, int badgeNumber) {
        this.name = name;
        this.badgeNumber = badgeNumber;
    }

    public PoliceOfficer(PoliceOfficer po) {
        this(po.name, po.badgeNumber);
    }

    public String getName()        { return name;        }
    public int    getBadgeNumber() { return badgeNumber; }

    public void setName(String n)      { name        = n;  }
    public void setBadgeNumber(int bn) { badgeNumber = bn; }

}
