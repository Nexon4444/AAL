package mainFunctions;

import java.util.ArrayList;
import java.util.Scanner;

import mainClasses.Point;
import mainClasses.Vektor;
import view.Visualization;

public class Main {
		static int width = 5000;
		static int height = 5000;
		int amount = 1000;
		int length = 400;
	public static void main(String[] args) {
		control();
	}
	
//		tester();
		
//		Generator gen = new Generator(length, 0, 10, amount, width, height);
//		gen.generate();
//		Segments segment1 = new Segments();
//		Segments segment2 = new Segments();
//
////		System.out.println(test.testPrimitive());
////		System.out.println(test.testSweepLine());
//
//
////		ArrayList<Vektor> test = createArray();
////		segment1.primitiveFamilyCheck(gen.getData());
//		segment1.sweepAlgorithm(createArray());
//		
////		segment2.sweepAlgorithm(test);
////		segment2.showGroups();
//		
//		Visualization vis = new Visualization(segment1.getFamily(), width, height);
//		segment1.showGroups();
////		vis.visualize();
////		segment2.sweepAlgorithm(ReadData.read("src/mainFunctions/test.txt"));
////		return segment1;
//
//	}
//	public static void tester()
//	{
//		Vektor vek1 = new Vektor(new Point(0.0, 3.0), new Point(3.0, 0.0));
//		Vektor vek2 = new Vektor(new Point(0.0, 0.0), new Point(3.0, 0.0));
//		Point point = Segments.checkIfIntersect(vek1, vek2);
//		System.out.println(point);
//	}
//	 
	public static ArrayList<Vektor> createArray1()
	{
		ArrayList<Vektor> vek = new ArrayList<Vektor>();

		vek.add(new Vektor(new Point(300.0, 300.0), new Point(1000.0, 100.0)));
		vek.add(new Vektor(new Point(500.0, 400.0), new Point(700.0, 100.0)));
		vek.add(new Vektor(new Point(900.0, 300.0), new Point(1000.0, 100.0)));
		return vek;
	}

	public static ArrayList<Vektor> createArray2()
	{
		ArrayList<Vektor> vek = new ArrayList<Vektor>();

		vek.add(new Vektor(new Point(300.0, 300.0), new Point(1000.0, 100.0)));
		vek.add(new Vektor(new Point(500.0, 400.0), new Point(700.0, 0.0)));
		vek.add(new Vektor(new Point(900.0, 300.0), new Point(1000.0, 500.0)));
		vek.add(new Vektor(new Point(200.0, 500.0), new Point(1000.0, 300.0)));
		vek.add(new Vektor(new Point(500.0, 600.0), new Point(700.0, 1000.0)));
		vek.add(new Vektor(new Point(1000.0, 1200.0), new Point(1100.0, 1300.0)));
		return vek;
	}


	static void control()
	{
		while (true)
		{
			System.out.println("choose option:\n 0 - visualize 1st example,\n 1 - visiualize second example,\n 2 - run test for Generator [s=400, mean=20, variance=10, width=1000, height=1000], Test [vekAmountMin= 100, vekAmountMax= 1000, vekAmountStep= 100]\n" +
					" 3 - run test for Generator [s=40, mean=20, variance=20, width=10000, height=10000], Test [vekAmountMin= 1000, vekAmountMax= 10000, vekAmountStep= 1000],\n other - exit");
			Scanner scanner  = new Scanner(System.in);
			switch(scanner.nextInt())
			{
			case 0:
				Segments segment1 = new Segments();
				segment1.sweepAlgorithm(createArray1());
				Visualization vis1 = new Visualization(segment1.getFamily(), width, height);
				segment1.showGroups();
				vis1.visualize();
				
				break;
			case 1:
				Segments segment2 = new Segments();
				segment2.sweepAlgorithm(createArray2());
				Visualization vis2 = new Visualization(segment2.getFamily(), width, height);
				segment2.showGroups();
				vis2.visualize();
			
				break;
			case 2:
				Test test1 = new Test(100, 1000, 100, 10, 400);
				test1.conductTest();
				break;
			case 3:
				Test test2 = new Test(1000, 10000, 1000, 20, 40);
				test2.conductTest();
				break;
			default:
				return;
			}
			
				
		}
	}
}
//vek.add(new Vektor(new Point(0.0, 7.0), new Point(8.0, 7.0)));
//vek.add(new Vektor(new Point(1.0, 13.0), new Point(3.0, 11.0)));
//vek.add(new Vektor(new Point(4.0, 10.0), new Point(4.0, 13.0)));
//vek.add(new Vektor(new Point(5.0, 9.0), new Point(7.0, 9.0)));
//vek.add(new Vektor(new Point(6.0, 8.0), new Point(6.0, 10.0)));

//vek.add(new Vektor(new Point(7.0, 6.0), new Point(11.0, 4.0)));
//vek.add(new Vektor(new Point(10.0, 5.0), new Point(11.0, 2.0)));
