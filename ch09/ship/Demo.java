import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        String[] names = {"Serendipity", "Liberty", "Escape", "Blue Moon",
                          "Spirit", "Destiny", "Carpe Diem", "Serendipity",
                          "Relentless", "Aquaholic"};
        Ship[] ships = new Ship[names.length];

        /* Randomly Generate some ships */
        Random rng = new Random();
        int type, year, passengers, capacity;
        for(int i=0; i<names.length; i++){
            type = rng.nextInt(3);
            year = 1700 + rng.nextInt(2020 - 1700);
            switch(type) {
                case 0:
                    ships[i] = new Ship(names[i], year);
                    break;
                case 1:
                    passengers = 150 + rng.nextInt(6318 - 150);
                    ships[i] = new CruiseShip(names[i], year, passengers);
                    break;
                case 2:
                    capacity = 15000 + rng.nextInt(35000 - 15000);
                    ships[i] = new CargoShip(names[i], year, capacity);
                    break;
            }
        }

        /* Print each ship */
        for(Ship s : ships)
            System.out.println(s + "\n");
    }
}
