package mainFunctions;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import mainClasses.Point;
import mainClasses.Vektor;
import view.Visualization;

public class Main {
		static int width = 1000;
		static int height = 1000;
		int amount = 1000;
		int length = 400;
	public static void main(String[] args) {
		control();
	}

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
					" 3 - run test for Generator [s=40, mean=20, variance=20, width=10000, height=10000], Test [vekAmountMin= 1000, vekAmountMax= 10000, vekAmountStep= 1000],\n 4 - read data from test.txt,\n 5 - visualize generated data,\n other - exit");
			@SuppressWarnings("resource")
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
			case 4:
				Segments segment3 = new Segments();
				try {
					segment3.sweepAlgorithm(ReadData.read("src/test.txt"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(segment3.getFamily().toString());
				Visualization vis3 = new Visualization(segment3.getFamily(), width, height);
				
				vis3.visualize();
				break;
			case 5:
				Generator gen = new Generator(1000, 0, 10, 1000, 1000);
				gen.generate();
				Segments segment5 = new Segments();
				Segments segment6 = new Segments();
				ArrayList<Vektor> data = new ArrayList<Vektor>();
				//data.addAll(gen.getData().clone());
				data.addAll(gen.getData());
//				segment5.primitiveFamilyCheck(gen.getData());
				segment6.sweepAlgorithm(data);
				Visualization vis5 = new Visualization(segment5.getFamily(), width, height);
				Visualization vis6 = new Visualization(segment6.getFamily(), width, height);
				System.out.println(segment5.getFamily());
				segment5.showGroups();
				vis5.visualize();
				vis6.visualize();
				
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
