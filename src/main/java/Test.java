import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test
{
	public static void main(String[] args)
	{

		// Constants
		// Spacing making it possible to slide the materials together without force
		double spacing = 0.2;
		double raisingplateWidth = 5;
		double raisingplateHeight = 10;

		// Dimensions for carport
		Map<String, Double> dimensions = getDimensions();

		// Start up
		JavaCSG csg = JavaCSGFactory.createDefault();

		// Shapes
		Raisingplate raisingplate = new Raisingplate(dimensions.get("length"), raisingplateWidth, raisingplateHeight);
		Raft raft = new Raft(dimensions.get("width"), raisingplateWidth, spacing);
		Post post = new Post(dimensions.get("height"), raisingplateWidth, raisingplateHeight, spacing);

		csg.view(raisingplate.create(csg), 0);
		csg.view(raft.create(csg), 1);
		csg.view(post.create(csg), 2);

		printOutro();
	}

	private static Map<String, Double> getDimensions() {

		Map<String, Double> dimensions = new HashMap<>();

		// Get user inputs width, height and length
		Scanner scn = new Scanner(System.in);


		// Intro
		System.out.println("-----------------------------------------------------------");
		System.out.println("Velkommen til Carport3D for Fog");
		System.out.println("Du vil nu skulle indtatste målene på carporten i meter");
		System.out.println("-----------------------------------------------------------");


		// Width
		System.out.println("Indtast bredde på carport");
		dimensions.put("width", scn.nextDouble());
		scn.nextLine();

		// Length
		System.out.println("Indtast længde på carport");
		dimensions.put("length", scn.nextDouble());

		scn.nextLine();

		// Height
		System.out.println("Indtast højde på carport");
		dimensions.put("height", scn.nextDouble());
		scn.nextLine();

		return dimensions;
	}

	private static void printOutro() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Nu skal du finde de 3 '.scad' filer i OpenSCAD mappen og åbne dem i OpenSCAD");
		System.out.println("View0 (Rem), View1 (Spær), View2 (Stolpe)");
		System.out.println("Derefter skal du exportere de 3 filer som '.stl'");
		System.out.println("Duplikér nu hver fil så mange gange, som der står i styklisten, og træk dem ind i Cura");
		System.out.println("Du skal altid kun have 2 remme");
		System.out.println("Nu er du klar til at printe🥳");
		System.out.println("-----------------------------------------------------------");
	}
}
