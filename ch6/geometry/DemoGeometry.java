import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Tester for the Geometry class.
 */
public class DemoGeometry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;

        do {
            printOptions();
            choice = scan.nextInt();
            handleOption(choice);
        } while(choice != 4);
    }


    public static void handleOption(int choice) {
        switch (choice) {
            case 1:
                handleCircle();
                break;
            case 2:
                handleRectangle();
                break;
            case 3:
                handleTriangle();
                break;
            case 4:
                System.out.println("\nBye");
                break;
            default:
                System.err.println("\nInvalid choice!");
        }
        System.out.println();
    }
    
    /**
     * Handles the circle option.
     * Gets the length and width of the circle.
     * Calculates and displays the area.
     */
    private static void handleCircle() {
        double dim1, ans;
        Scanner scan = new Scanner(System.in);
        DecimalFormat area = new DecimalFormat("#,##0.00");
        System.out.println("\nWhat are the dimensions of the circle?");
        System.out.printf("Radius: "); 
        dim1 = scan.nextDouble();
        ans = Geometry.circleArea(dim1);
        System.out.printf("\nA circle with radius %s has area %s\n",
                area.format(dim1), area.format(ans));
    }
    
    /**
     * Handles the rectangle option.
     * Gets the length and width of the rectangle.
     * Calculates and displays the area.
     */
    private static void handleRectangle() {
        double dim1, dim2, ans;
        Scanner scan = new Scanner(System.in);
        DecimalFormat area = new DecimalFormat("#,##0.00");
        System.out.println("\nWhat are the dimensions of the rectangle?");
        System.out.printf("Length: "); 
        dim1 = scan.nextDouble();
        System.out.printf("Width:  ");
        dim2 = scan.nextDouble();
        ans = Geometry.rectangleArea(dim1, dim2);
        System.out.printf(
                "\nA rectangle with length %s and width %s has area %s\n",
                area.format(dim1), area.format(dim2), area.format(ans));
    }

    /**
     * Handles the triangle option.
     * Gets the base and height of the triangle.
     * Calculates and displays the area.
     */
    private static void handleTriangle() {
        double dim1, dim2, ans;
        Scanner scan = new Scanner(System.in);
        DecimalFormat area = new DecimalFormat("#,##0.00");
        System.out.println("\nWhat are the dimensions of the triangle?");
        System.out.printf("Base:   "); 
        dim1 = scan.nextDouble();
        System.out.printf("Height: ");
        dim2 = scan.nextDouble();
        ans = Geometry.triangleArea(dim1, dim2);
        System.out.printf(
                "\nA triangle with base %s and height %s has area %s\n",
                area.format(dim1), area.format(dim2), area.format(ans));
    }


    /**
     * Prints the options for the user.
     *
     * Geometry Calculator
     * 1. Calculate the Area of a Circle
     * 2. Calculate the Area of a Rectangle
     * 3. Calculate the Area of a Triangle
     * 4. Quit
     *
     * Enter your choice (1-4):
     */
    private static void printOptions() { 
        System.out.println("Geometry Calculator");
        System.out.println("1. Calculate the Area of a Circle");
        System.out.println("2. Calculate the Area of a Rectangle");
        System.out.println("3. Calculate the Area of a Triangle");
        System.out.println("4. Quit");
        System.out.println();
        System.out.print("Enter your choice (1-4): ");
    }
}
