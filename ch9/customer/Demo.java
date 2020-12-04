public class Demo {
    public static void main(String[] args) {
        /* Test Person Class */
        Person myP = new Person("Devon", "17 University Ct.", "(862)216-9965");
        System.out.println(myP);
        System.out.println();

        /* Test Customer Class */
        Customer myC = new Customer("Devon", "17 University Ct.", 
                "(862)216-9965", false);
        System.out.println(myC);
        System.out.println();

        /* Test PreferredCustomer Class */
        PreferredCustomer myPC = new PreferredCustomer("Devon", 
                "17 University Ct.", "(862)216-9965", false, 1292.53);
        System.out.println(myPC);
        System.out.println();
    }
}
