public class Demo {
    public static void main(String[] args) {
        /* Test Person Class */
        Person myP = new Person("Devon", "17 University Ct.", "(862)216-9965");

        /* Test Customer Class */
        Customer myC = new Customer("Devon", "17 University Ct.", 
                "(862)216-9965", false);

        /* Test PreferredCustomer Class */
        PreferredCustomer myPC = new PreferredCustomer("Devon", 
                "17 University Ct.", "(862)216-9965", false, 1292.53);
    }
}
