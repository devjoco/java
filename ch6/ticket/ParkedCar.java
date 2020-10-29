public class ParkedCar {
    private String make;
    private String model;
    private String color;
    private String license;
    private int minutes;

    public ParkedCar(String ma, String mo, String co, String li, int mi) {
        make = ma;
        model = mo;
        color = co;
        license = li;
        minutes = mi;
    }

    public String getMake()    { return make;    }
    public String getModel()   { return model;   }
    public String getColor()   { return color;   }
    public String getLicense() { return license; }
    public int    getMinutes() { return minutes; }
}
