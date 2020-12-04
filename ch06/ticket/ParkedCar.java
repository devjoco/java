/**
 * This class simulates a parked car.
 *
 * Responsibilities:
 *   - Know the car's make, model, color, plate number.
 *   - Know the number of minutes the car has been parked.
 */
public class ParkedCar {
    private String make;
    private String model;
    private String color;
    private String plate;
    private int    minutes;

    public ParkedCar(String ma, String mo, String co, String li, int mi) {
        make    = ma;
        model   = mo;
        color   = co;
        plate   = li;
        minutes = mi;
    }

    public ParkedCar(ParkedCar pc) {
        this(pc.make, pc.model, pc.color, pc.plate, pc.minutes);
    }

    public String getMake()    { return make;    }
    public String getModel()   { return model;   }
    public String getColor()   { return color;   }
    public String getPlate()   { return plate;   }
    public int    getMinutes() { return minutes; }

    public void setMake(String newMake)    { make    = newMake;    }
    public void setModel(String newModel)  { model   = newModel;   }
    public void setColor(String newColor)  { color   = newColor;   }
    public void setPlate(String newPlate)  { plate   = newPlate;   }
    public void setMinutes(int newMinutes) { minutes = newMinutes; }

}
