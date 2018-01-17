package mainFunctions;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import mainClasses.Point;
import mainClasses.Vektor;
import view.Visualization;

public class Main {

	public static void main(String[] args) throws Exception {
//		tester();
		int width = 500;
		int height = 500;
		int amount = 10;
		int length = 400;
		Generator gen = new Generator(length, 0, 5, amount, width, height);
		gen.generate();
		//gen.showGenerated();
		Segments segment2 = new Segments();
//		segment2.sweepAlgorithm(gen.getData());
//		segment2.showGroups();
		Segments segment1 = new Segments();
		ArrayList<Vektor> test = createArray();
//		segment1.primitiveFamilyCheck(gen.getData());
//		segment1.sweepAlgorithm(gen.getData());
		segment2.sweepAlgorithm(test);
//		segment2.showGroups();
		
		System.out.println("=============================================");
		System.out.println("                 " + segment1.getFamily().equals(segment2.getFamily()));
		System.out.println("=============================================");
		Visualization vis = new Visualization(segment2.getFamily(), width, height);
		segment2.showGroups();
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

		vek.add(new Vektor(new Point(3.0, 3.0), new Point(10.0, 1.0)));
		vek.add(new Vektor(new Point(5.0, 4.0), new Point(7.0, 0.0)));
		vek.add(new Vektor(new Point(9.0, 3.0), new Point(10.0, 0.0)));
		return vek;
	}
}

//vek.add(new Vektor(new Point(0.0, 7.0), new Point(8.0, 7.0)));
//vek.add(new Vektor(new Point(1.0, 13.0), new Point(3.0, 11.0)));
//vek.add(new Vektor(new Point(4.0, 10.0), new Point(4.0, 13.0)));
//vek.add(new Vektor(new Point(5.0, 9.0), new Point(7.0, 9.0)));
//vek.add(new Vektor(new Point(6.0, 8.0), new Point(6.0, 10.0)));

//vek.add(new Vektor(new Point(7.0, 6.0), new Point(11.0, 4.0)));
//vek.add(new Vektor(new Point(10.0, 5.0), new Point(11.0, 2.0)));
