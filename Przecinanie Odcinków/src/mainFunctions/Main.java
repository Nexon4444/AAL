package mainFunctions;

import java.io.FileNotFoundException;

import mainClasses.Point;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Point p1 = new Point(1.0, 0.0, 0, null);
		Point p2 = new Point(1.0, 1.0, 0, null);
		System.out.println(p1.compareTo(p2));
		Segments.primitiveFamilyCheck(ReadData.read("src/mainFunctions/test.txt"));
		Segments.sweepAlgorithm(ReadData.read("src/mainFunctions/test.txt"));
	/*	Vektor vec1 = new Vektor(0, 0, 2, 2);
		Vektor vec2 = new Vektor(1, 4, 3, 1);
		System.out.println(Segments.checkIfIntersect(vec1, vec2));*/
	}

}
