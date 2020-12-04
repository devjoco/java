public class Person {
    private String name;
    private String address;
    private String telephone;

    /** Constructor */
    public Person(String name, String address, String telephone) {
        this.name      = name;
        this.address   = address;
        this.telephone = telephone;
    }

    /** Getters */
    public String getName()      { return name;      }
    public String getAddress()   { return address;   }
    public String getTelephone() { return telephone; }

    /** Setters */
    public void setName(String name)           { this.name      = name;      }
    public void setAddress(String address)     { this.address   = address;   }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    @Override
    public String toString() {
        return super.toString()
            + "\nPerson"
            + "\n\tName:      " + name
            + "\n\tAddress:   " + address
            + "\n\tTelephone: " + telephone;
    }
}
