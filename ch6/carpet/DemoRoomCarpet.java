import java.util.Scanner;

public class DemoRoomCarpet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double length, width, cost;

        System.out.println("What are the dimensions of your room?");
        System.out.print("Length: ");
        length = sc.nextDouble();
        
        System.out.print("Width: ");
        width = sc.nextDouble();

        System.out.println("How expensive is the carpet?");
        System.out.print("Price per ft²: ");
        cost = sc.nextDouble();

        RoomCarpet carpet = new RoomCarpet(
                new RoomDimension(length, width),
                cost);

        System.out.println(carpet);
    }
}
