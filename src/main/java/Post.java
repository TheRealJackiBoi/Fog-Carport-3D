import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Post extends Material {

    private double cutoutWidth;
    private double cutoutHeight;
    private double spacing;

    public Post(double height, double cutoutWidth, double cutoutHeight, double spacing) {
        super(10, 10, height * 20);

        this.cutoutWidth = cutoutWidth;
        this.cutoutHeight = cutoutHeight;
        this.spacing = spacing;
    }

    @Override
    public Geometry3D create(JavaCSG csg) {

        // Creating shapes
        Geometry3D post = csg.box3D(getWidth(), getLength(), getHeight(), false);

        Geometry3D cutout = csg.box3D(cutoutWidth + spacing * 2, getLength(), cutoutHeight, false);


        // Moving cutout to the top of the post
        cutout = csg.translate3DZ(getHeight() - cutoutHeight).transform(cutout);

        // Cutting the cutout out
        post = csg.difference3D(post, cutout);

        return post;
    }
}
