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

    public static void main(String[] args) {
        InventoryItem i1 = new InventoryItem();
        System.out.println(i1);
    }
}
