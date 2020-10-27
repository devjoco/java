import java.text.DecimalFormat;

public class RetailItem {
    private String description;
    private int itemNumber;
    private CostData cost;

    public RetailItem(String desc, int itemNum, 
            double wholesale, double retail) {
        description = desc;
        itemNumber = itemNum;
        cost = new CostData(wholesale, retail);
    }

    public double getRetail()    { return cost.retail; }
    public double getWholesale() { return cost.wholesale; }

    public void setRetail(double r)    { cost.retail = r; }
    public void setWholesale(double w) { cost.wholesale = w; }

    public String toString() {
        String str;

        DecimalFormat dollar = new DecimalFormat("#,##0.00");

        str = "Description: " + description
            + "\nItem Number: " + itemNumber
            + "\nWholesale Cost: $" 
            + dollar.format(cost.wholesale)
            + "\nRetail Price: $"
            + dollar.format(cost.retail);

        return str;
    }

    private class CostData {
        public double wholesale, retail;

        public CostData(double w, double r) {
            wholesale = w;
            retail = r;
        }
    }
}
