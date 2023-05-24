import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Raisingplate extends Material {
    public Raisingplate(double length) {
        super(5, length * 20, 10);
    }

    @Override
    public Geometry3D create(JavaCSG csg) {
        Geometry3D raisingplate;

        // Main box
        Geometry3D mainBox = csg.box3D(this.getWidth(), this.getLength(), this.getHeight(), false);


        // Stops at each end
        double stopWidth = this.getWidth() * 2;
        double stopLength = 5;
        double translateAmount = this.getLength() / 2 + stopLength / 2;

        // Negative end
        Geometry3D stop1 = csg.box3D(stopWidth, stopLength, this.getHeight(), false);

        stop1 = csg.translate3DY(translateAmount * -1).transform(stop1);

        // Postitive end
        Geometry3D stop2 = csg.box3D(stopWidth, stopLength, this.getHeight(), false);

        stop2 = csg.translate3DY(translateAmount).transform(stop2);


        // Attaching stops to main box
        raisingplate = csg.union3D(mainBox, stop1);
        raisingplate = csg.union3D(raisingplate, stop2);

        return raisingplate;
    }
}
