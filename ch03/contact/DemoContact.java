public class DemoContact {
    public static void main(String[] args) {
        Contact devonInfo = new Contact("Devon", "17 University Ct.",
                                        "(862)216-9965", 26);
        Contact morganInfo = new Contact("Morgan", "17 University Ct.",
                                        "(862)216-3733", 24);
        Contact momInfo = new Contact("Michele", "17 University Ct.",
                                        "(973)818-3831", 57);

        System.out.printf("%s: %s %s %s\n",
                          devonInfo.getName(),
                          devonInfo.getAddress(),
                          devonInfo.getPhone(),
                          devonInfo.getAge()
        );
        System.out.printf("%s: %s %s %s\n",
                          morganInfo.getName(),
                          morganInfo.getAddress(),
                          morganInfo.getPhone(),
                          morganInfo.getAge()
        );
        System.out.printf("%s: %s %s %s\n",
                          momInfo.getName(),
                          momInfo.getAddress(),
                          momInfo.getPhone(),
                          momInfo.getAge()
        );
    }
}
