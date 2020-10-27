import java.text.DecimalFormat;

public class RoomCarpet {
    private RoomDimension size;
    private double carpetCost;

    public RoomCarpet(RoomDimension dim, double cost) {
        size = dim;
        carpetCost = cost;
    }

    public double getTotalCost() {
        return size.getArea() * carpetCost;
    }

    public String toString() {
        DecimalFormat fmt = new DecimalFormat("#,##0.00");
        return "carpet{"+size+", $"+getTotalCost()+" @ $"+carpetCost+"/ft²}";
    }
}
