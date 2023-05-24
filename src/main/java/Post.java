import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Post extends Material {
    public Post(double height) {
        super(10, 10, height * 20);
    }

    @Override
    public Geometry3D create(JavaCSG csg) {
        Geometry3D post;

        post = csg.box3D(this.getWidth(), this.getLength(), this.getHeight(), false);

        return post;
    }
}
