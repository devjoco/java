/**
 * Checkpoint 2.27 - 2.31
 *
 * Deals with String methods length(), charAt(), toUpperCase(), toLowerCase()
 */
public class Strings {
    public static void main(String[] args) {
        String city = "San Francisco";
        int stringLength = city.length();
        char oneChar = city.charAt(0);
        String upperCity = city.toUpperCase();
        String lowerCity = city.toLowerCase();

        System.out.println(city);
        System.out.println(stringLength);
        System.out.println(oneChar);
        System.out.println(upperCity);
        System.out.println(lowerCity);
    }
}
