class Contact {
    private String name;
    private String address;
    private String phone;
    private int    age;
    
    public Contact(String na, String ad, String ph, int ag) {
        name    = na;
        address = ad;
        phone   = ph;
        age     = ag;
    }

    public String getName()    { return name;    }
    public String getAddress() { return address; }
    public String getPhone()   { return phone;   }
    public int    getAge()     { return age;     }

    public void setName(String newName)       { name    = newName;    }
    public void setAddress(String newAddress) { address = newAddress; }
    public void setPhone(String newPhone)     { phone   = newPhone;   }
    public void setAge(int newAge)            { age     = newAge;     }
}
