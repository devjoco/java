public class DemoEmployee {
    public static void main(String args[]) {
        final int NUM_EMPLOYEES = 5;
        Employee[] emps = new Employee[NUM_EMPLOYEES];
        Employee thisEmp;

        emps[0] = new Employee("Susan Meyers", 47899, 
                               "Accounting", "Vice President");
        emps[1] = new Employee("Mark Jones", 39119, 
                               "IT", "Programmer");
        emps[2] = new Employee("Joy Rogers", 81774, 
                               "Manufacturing", "Engineer");
        emps[3] = new Employee("Dayvaughn O'Connor", 49382);
        emps[4] = new Employee();

        for(int i = 0; i < emps.length; i += 1) {
            thisEmp = emps[i];
            System.out.printf("Employee #%d is %s, %s in %s\n",
                    thisEmp.getIdNumber(),
                    thisEmp.getName(),
                    thisEmp.getPosition(),
                    thisEmp.getDepartment()
            );
        }
    }
}
