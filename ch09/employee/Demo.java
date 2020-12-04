public class Demo {
    public static void main(String[] args) {
        // A list of names to make Employees from
        String[] names = {"Devon", "Bob", "Joe", "Sally", "Jill",
                          "Billy", "Sue", "Amy", "Kevin", "Thad", 
                          "Harry", "Pam", "Liz", "Kelly", "Fred"};

        // Create Employees and print them out.
        System.out.println("Printing Employee[Employee]");
        Employee[] emps = new Employee[names.length];
        for(int i=0; i<names.length; i++)
            emps[i] = new Employee(names[i]);
        for(int i=0; i<emps.length; i++) 
            System.out.println(emps[i]);
        System.out.println();

        // Create ProductionWorkers and print them out.
        System.out.println("Printing ProductionWorker[ProductionWorker]");
        ProductionWorker[] workers = new ProductionWorker[names.length];
        for(int i=0; i<names.length; i++)
            workers[i] = new ProductionWorker(names[i]);
        for(int i=0; i<workers.length; i++)
            System.out.println(workers[i]); 
        System.out.println();

        // Create polymorphic ProductionWorkers and print them out.
        System.out.println("Printing Employee[ProductionWorker]");
        Employee[] empWorkers = new Employee[names.length];
        for(int i=0; i<names.length; i++)
            empWorkers[i] = new ProductionWorker(names[i]);
        for(int i=0; i<empWorkers.length; i++)
            System.out.println(empWorkers[i]); 
        System.out.println();

        // Create ShiftSupervisors and print them out.
        System.out.println("Printing ShiftSupervisor[ShiftSupervisor]");
        ShiftSupervisor[] sups = new ShiftSupervisor[names.length];
        for(int i=0; i<names.length; i++)
            sups[i] = new ShiftSupervisor(names[i]);
        for(int i=0; i<sups.length; i++)
            System.out.println(sups[i]); 
        System.out.println();

        // Create TeamLeaders and print them out.
        System.out.println("Printing TeamLeader[TeamLeader]");
        TeamLeader[] leaders = new TeamLeader[names.length];
        for(int i=0; i<names.length; i++)
            leaders[i] = new TeamLeader(names[i]);
        for(int i=0; i<leaders.length; i++)
            System.out.println(leaders[i]); 
        System.out.println();
    }
}
