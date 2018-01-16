package mainFunctions;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import mainClasses.Point;
import mainClasses.Vektor;
import view.Visualization;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
//		tester();
		int width = 500;
		int height = 500;
		int amount = 10;
		int length = 400;
		Generator gen = new Generator(length, 0, 5, amount, width, height);
		gen.generate();
		//gen.showGenerated();
		Segments segment2 = new Segments();
		segment2.sweepAlgorithm(gen.getData());
//		segment2.showGroups();
		Segments segment1 = new Segments();
		ArrayList<Vektor> test = createArray();
		segment1.primitiveFamilyCheck(gen.getData());
//		segment1.showGroups();
//		segment2.sweepAlgorithm(test);
//		segment2.showGroups();
		
		System.out.println("=============================================");
		System.out.println("                 " + segment1.getFamily().equals(segment2.getFamily()));
		System.out.println("=============================================");
		Visualization vis = new Visualization(segment1.getFamily(), width, height);
		vis.visualize();
//		segment2.sweepAlgorithm(ReadData.read("src/mainFunctions/test.txt"));

	}
	public static void tester()
	{
		Vektor vek1 = new Vektor(new Point(0.0, 3.0), new Point(3.0, 0.0));
		Vektor vek2 = new Vektor(new Point(0.0, 0.0), new Point(3.0, 0.0));
		Point point = Segments.checkIfIntersect(vek1, vek2);
		System.out.println(point);
	}
	 
	public static ArrayList<Vektor> createArray()
	{
		ArrayList<Vektor> vek = new ArrayList<Vektor>();
		vek.add(new Vektor(new Point(0.0, 0.0), new Point(3.0, 3.0)));
		vek.add(new Vektor(new Point(0.0, 3.0), new Point(3.0, 0.0)));
		vek.add(new Vektor(new Point(0.0, 2.0), new Point(3.0, 2.0)));
		return vek;
	}
}
