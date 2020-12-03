public class Demo {
    public static void main(String[] args) {
        // A list of names to make Employees from
        String[] names = {"Devon", "Bob", "Joe", "Sally", "Jill",
                          "Billy", "Sue", "Amy", "Kevin", "Thad", 
                          "Harry", "Pam", "Liz", "Kelly", "Fred"};

        // Create Employees and print them out.
        Employee[] emps = new Employee[names.length];
        for(int i=0; i<names.length; i++)
            emps[i] = new Employee(names[i]);
        for(int i=0; i<emps.length; i++) 
            System.out.println(emps[i]);
        System.out.println();

        // Create ProductionWorkers and print them out.
        ProductionWorker[] workers = new ProductionWorker[names.length];
        for(int i=0; i<names.length; i++)
            workers[i] = new ProductionWorker(names[i]);
        for(int i=0; i<workers.length; i++)
            System.out.println(workers[i]); 
        System.out.println();

        // Create polymorphic ProductionWorkers and print them out.
        Employee[] empWorkers = new Employee[names.length];
        for(int i=0; i<names.length; i++)
            empWorkers[i] = new ProductionWorker(names[i]);
        for(int i=0; i<empWorkers.length; i++)
            System.out.println(empWorkers[i]); 
        System.out.println();
    }
}
