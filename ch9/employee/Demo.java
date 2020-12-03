public class Demo {
    public static void main(String[] args) {
        String[] names = {"Devon", "Bob", "Joe", "Sally", "Jill",
                          "Billy", "Sue", "Amy", "Kevin", "Thad", 
                          "Harry", "Pam", "Liz", "Kelly", "Fred"};
        ProductionWorker[] workers = new ProductionWorker[names.length];
        for(int i=0; i<names.length; i++)
            workers[i] = new ProductionWorker(names[i]);

        for(int i=0; i<workers.length; i++) {
            System.out.println(workers[i]);
        }
    }
}
