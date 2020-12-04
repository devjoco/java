import java.util.Scanner;
import java.text.DecimalFormat;

public class DemoRoomCarpet {
    public static void main(String[] args) {
        DecimalFormat money = new DecimalFormat("¤#,##0.00");
        DecimalFormat foot = new DecimalFormat("#,##0.##''");
        Scanner sc = new Scanner(System.in);
        double length, width, cost;

        System.out.println("What are the dimensions of your room?");
        System.out.print("Length in ft: ");
        length = sc.nextDouble();
        
        System.out.print("Width in ft: ");
        width = sc.nextDouble();

        System.out.println();
        System.out.println("How expensive is the carpet?");
        System.out.print("Price per ft²: $");
        cost = sc.nextDouble();

        RoomCarpet carpet = new RoomCarpet(
                new RoomDimension(length, width),
                cost);

        System.out.println();
        System.out.printf("That'll cost %s for a %s by %s room @ %s/ft²\n",
                money.format(carpet.getTotalCost()),
                foot.format(carpet.getSize().getLength()),
                foot.format(carpet.getSize().getWidth()),
                money.format(carpet.getCarpetCost())
                );
    }
}
