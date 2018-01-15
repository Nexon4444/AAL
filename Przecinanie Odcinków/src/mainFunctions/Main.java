package mainFunctions;

import java.io.FileNotFoundException;
import java.util.TreeMap;

import mainClasses.Point;
import mainClasses.Vektor;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Generator gen = new Generator(10, 5, 2, 10, 500, 500);
		gen.generate();
		gen.showGenerated();
//		Segments segment1 = new Segments();
//		Segments segment2 = new Segments();
//		segment1.primitiveFamilyCheck(ReadData.read("src/mainFunctions/test.txt"));
//		segment2.sweepAlgorithm(ReadData.read("src/mainFunctions/test.txt"));

	}

}
