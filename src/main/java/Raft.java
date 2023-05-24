import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Raft extends Material {

    private double cutoutWidth;
    public Raft(double width, double cutoutWidth) {
        super(width * 20, 5, 10);
        this.cutoutWidth = cutoutWidth;
    }

    @Override
    public Geometry3D create(JavaCSG csg) {
        Geometry3D Raft;

        Raft = csg.box3D(this.getWidth(), this.getLength(), this.getHeight(), false);

        return Raft;
    }
}
