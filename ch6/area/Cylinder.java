public class Cylinder {
    private double radius, height;
    public Cylinder(double r, double h) { 
        radius = r;
        height = h; 
    }
    public double getRadius() { return radius; }
    public double getHeight() { return height; }
    public String toString() { return "Cylinder{r="+radius+" h="+height+"}"; }
}
