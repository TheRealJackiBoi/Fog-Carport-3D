import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Raft extends Material {

    private double cutoutWidth;
    private double spacing;


    public Raft(double width, double cutoutWidth, double spacing) {
        super(width * 20, 5, 10);
        this.cutoutWidth = cutoutWidth;
        this.spacing = spacing;
    }

    @Override
    public Geometry3D create(JavaCSG csg) {

        double translateAmount = getWidth() / 2 - cutoutWidth / 2 + spacing;
        double blockWidth = 2.5;
        double blockTranslateAmount = getWidth() / 2 + blockWidth / 2;

        // Main box
        Geometry3D raft = csg.box3D(getWidth(), getLength(), getHeight(), false);

        // Cutouts
        // Negative cutout
        Geometry3D cutout1 = csg.box3D(cutoutWidth + spacing * 2, getLength(), getHeight() / 4 * 3, false);
        cutout1 = csg.translate3DX(translateAmount * -1).transform(cutout1);

        // Positive cutout
        Geometry3D cutout2 = csg.box3D(cutoutWidth + spacing * 2, getLength(), getHeight() / 4 * 3, false);
        cutout2 = csg.translate3DX(translateAmount).transform(cutout2);


        // End blocks
        // Negative block
        Geometry3D endBlock1 = csg.box3D(blockWidth, getLength(), getHeight(), false);
        endBlock1 = csg.translate3DX(blockTranslateAmount * -1).transform(endBlock1);

        // Positive block
        Geometry3D endBlock2 = csg.box3D(blockWidth, getLength(), getHeight(), false);
        endBlock2 = csg.translate3DX(blockTranslateAmount).transform(endBlock2);


        // Attaching and cutouts
        raft = csg.union3D(raft, endBlock1);
        raft = csg.union3D(raft, endBlock2);

        raft = csg.difference3D(raft, cutout1);
        raft = csg.difference3D(raft, cutout2);

        return raft;
    }
}
