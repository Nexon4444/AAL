package mainFunctions;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Segments.primitiveFamilyCheck(ReadData.read("E:/Users/Nexon/workspace/Przecinanie Odcinków - AAL/src/mainFunctions/test.txt"));
	/*	Vektor vec1 = new Vektor(0, 0, 2, 2);
		Vektor vec2 = new Vektor(1, 4, 3, 1);
		System.out.println(Segments.checkIfIntersect(vec1, vec2));*/
	}

}
