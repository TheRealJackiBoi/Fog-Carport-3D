import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public abstract class Material {

    private double width;
    private double length;
    private double height;


    public Material(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }


    // Implemented in subclasses to make the specific shape
    public abstract Geometry3D create(JavaCSG csg);

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }
}
