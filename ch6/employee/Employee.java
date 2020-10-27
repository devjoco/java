public class Employee {
    private int    idNumber;
    private String name;
    private String department;
    private String position;

    public Employee(String newName, int id, String dept, String pos) {
        idNumber = id;
        name = newName;
        department = dept;
        position = pos;
    }

    public Employee(String newName, int id) {
        this(newName, id, "", "");
    }

    public Employee() {
        this("", 0, "", "");
    }

    public void setIdNumber(int newNum)       { idNumber   = newNum;  }
    public void setName(String newName)       { name       = newName; }
    public void setDepartment(String newDept) { department = newDept; }
    public void setPosition(String newPos)    { position   = newPos;  }

    public int    getIdNumber()   { return idNumber;   }
    public String getName()       { return name;       }
    public String getDepartment() { return department; }
    public String getPosition()   { return position;   }
}

