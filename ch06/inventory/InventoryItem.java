public class InventoryItem {
    private String description;
    private int units;

    public InventoryItem() {
        this("", 0);
    }
    
    public InventoryItem(String d) {
        this(d, 0);
    }
    
    public InventoryItem(InventoryItem i) {
        this(i.description, i.units);
    }

    public InventoryItem(String d, int u) {
        description = d;
        units = u;
    }

    public void setDescription(String d) {
        description = d;
    }

    public void setUnits(int u) {
        units = u;
    }

    public String getDescription() {
        return description;
    }

    public int getUnits() {
        return units;
    }

    public String toString() {
        return "{("+units+") "+description+"}";
    }

    public static void main(String[] args) {
        InventoryItem i1 = new InventoryItem();
        InventoryItem i2 = new InventoryItem("Rake");
        InventoryItem i3 = new InventoryItem("Shovel", 10);
        InventoryItem i4 = new InventoryItem(i3);

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
    }
}
