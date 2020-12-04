public class DemoPet {
    public static void main(String[] args) {
        Pet p1 = Pet.DOG;
        Pet p2 = Pet.BIRD;
        Pet p3 = Pet.CAT;
        Pet p4 = Pet.HAMPSTER;

        System.out.printf("%s, %d\n", p1, p1.ordinal());
        System.out.printf("%s, %d\n", p2, p2.ordinal());
        System.out.printf("%s, %d\n", p3, p3.ordinal());
        System.out.printf("%s, %d\n", p4, p4.ordinal());
    }
}
