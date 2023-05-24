import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

import java.util.Scanner;

public class Test
{
	public static void main(String[] args)
	{

		double width;
		double length;
		double height;

		// Get user inputs width, height and length
		Scanner scn = new Scanner(System.in);


		// Intro
		System.out.println("Velkommen til Carport3D for Fog");
		System.out.println("Du vil nu skulle indtatste målene på carporten i meter");

		// Width
		System.out.println("Indtast bredde på carport");
		width = scn.nextDouble();
		scn.nextLine();

		// Length
		System.out.println("Indtast længde på carport");
		length = scn.nextDouble();
		scn.nextLine();

		// Height
		System.out.println("Indtast højde på carport");
		height = scn.nextDouble();
		scn.nextLine();

		// Outro
		System.out.println("-----------------------------------------------------------");
		System.out.println("Nu skal du finde de 3 '.scad' filer i OpenSCAD mappen og åbne dem i OpenSCAD");
		System.out.println("View0 (Rem), View1 (Spær), View2 (Stolpe)");
		System.out.println("Derefter skal du exportere de 3 filer som '.stl'");
		System.out.println("Duplikér nu hver fil så mange gange, som der står i styklisten, og træk dem ind i Cura");
		System.out.println("Du skal altid kun have 2 remme");
		System.out.println("Nu er du klar til at printe🥳");
		System.out.println("-----------------------------------------------------------");

		// Start up
		JavaCSG csg = JavaCSGFactory.createDefault();

		// Shapes
		Raisingplate raisingplate = new Raisingplate(length);
		Raft raft = new Raft(width);
		Post post = new Post(height);

		csg.view(raisingplate.create(csg), 0);
		csg.view(raft.create(csg), 1);
		csg.view(post.create(csg), 2);
	}
}
