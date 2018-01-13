package mainFunctions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeMap;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularMatrixException;

import mainClasses.Point;
import mainClasses.Vektor;

/**
 * @author Nexon
 *
 */
public class Segments {
	
	ArrayList<ArrayList<Vektor>> arrayOfData;
	ArrayList<ArrayList<Vektor>> arrayOfGroups;
	static ArrayList <ArrayList<Vektor>> family = new ArrayList <ArrayList<Vektor>>();
	static TreeMap<Point, Vektor> BTree;
	static LinkedList<Point> eventQ = new LinkedList<Point>();

	static Point checkIfIntersect(Vektor vec1, Vektor vec2)
	{	
		if (vec1 == null || vec2 == null) return null;
		double c1 = (double) vec1.getKonX()-vec1.getPoczX();
		double c2 = (double) vec1.getPoczY()-vec1.getKonY();
		double r1 = (double) vec1.getPoczX()*(vec1.getPoczY()-vec1.getKonY())-vec1.getPoczY()*(vec1.getPoczX()-vec1.getKonX());
		
		double c3 = (double) vec2.getKonX()-vec2.getPoczX();
		double c4 = (double) vec2.getPoczY()-vec2.getKonY();
		double r2 = (double) vec2.getPoczX()*(vec2.getPoczY()-vec2.getKonY())-vec2.getPoczY()*(vec2.getPoczX()-vec2.getKonX());
		
		RealMatrix coefficients = new Array2DRowRealMatrix(new double[][] {{ c1, c2}, {c3, c4}}, false);
		DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();
		RealVector constants = new ArrayRealVector(new double[] { r1, r2 }, false);
		RealVector solution;
		
		try {
			solution = solver.solve(constants);
//			System.out.println(solution.getEntry(0) + " " + solution.getEntry(1));
		} catch (SingularMatrixException e) {
			
//			e.printStackTrace();
			return null;
		}
		return checkIfBelongs(vec1, vec2, solution.getEntry(0), solution.getEntry(1));

	}
	
	static Point checkIfBelongs(Vektor vec1, Vektor vec2, Double x, Double y)
	{
		if (x > Math.max(vec1.getKonX(), vec1.getPoczX()) || x < Math.min(vec1.getKonX(), vec1.getPoczX())) return null;
		if (y > Math.max(vec1.getKonY(), vec1.getPoczY()) || y < Math.min(vec1.getKonY(), vec1.getPoczY())) return null;
		return new Point(x, y, 0, null);
	}
	
	static ArrayList <ArrayList <Integer>> primitiveFamilyCheck(ArrayList<Vektor> listOfVektors)
	{
		int ArrayList;
		ArrayList <Vektor> pom = new ArrayList<Vektor> ();
		pom.add(listOfVektors.get(0));
		family.add(pom);
			
		
//		family.add(ArrayList<Vektor> = new ArrayList<Vektor> listOfVektors.get(0));
		for (int i = 0, max = listOfVektors.size(); i<max; i++)
			{
			 Vektor vekPoz = listOfVektors.get(0);
			 listOfVektors.remove(0);
			 boolean flag = false;
			 for (int j = 0;  j != listOfVektors.size() ; j++)
				{
				  Vektor vekPion = listOfVektors.get(j);
					if(checkIfIntersect(vekPoz, vekPion)!=null) 
						{
							//listOfVektors.remove(vekPion);
							vekPion.setIsGrouped(true);
							family.get(i).add(vekPion);
							flag = true;
						}
				}
			 
			 if (flag == false && !vekPoz.getIsGrouped())
			 {
				pom = new ArrayList <Vektor>();
				vekPoz.setIsGrouped(false);
				pom.add(vekPoz);
				family.add(pom);
			 }
			}

//		System.out.println(family.toString());
		return null;
	}
	
	static void fillTree(ArrayList<Vektor> data) //fill the tree with values
	{
		for (Vektor vek : data)
		{
			BTree.put(vek.getLeft(), vek);
			BTree.put(vek.getRight(), vek);
		}
	}
	
	static void inputBTree(Point element)
	{
		BTree.put(element, element.getVek());
	}
	
	static void processLeftPoint(Point element)
	{
		Vektor vek1 = BTree.higherEntry(element).getValue();
		Vektor vek2 = BTree.lowerEntry(element).getValue();
		Point p1 = checkIfIntersect(vek1, element.getVek());
		Point p2 = checkIfIntersect(vek2, element.getVek());
		if (p1!=null) inputQ(p1);
		if (p2!=null) inputQ(p2);
	}
	
	static void processRightPoint(Point element)
	{
		
	}
	
	static void inputQ(Point element)
	{
		if (eventQ.isEmpty())
			{
				eventQ.add(element);
				return;
			}
		else for (ListIterator<Point> it = eventQ.listIterator(); it.hasNext();)
			{
				int index = it.nextIndex();
				if (it.next().compareTo(element) > 0)
				{
					eventQ.add(index, element);
					return;
				}
			};
		eventQ.add(element);
		return;
	}
	
	static void fillQ(ArrayList<Vektor> data)
	{
		for (Vektor vek : data)
		{
			inputQ(vek.getLeft());
			inputQ(vek.getRight());
		}
	}
	static void sweepAlgorithm(ArrayList<Vektor> data)
	{
		fillQ(data);
		System.out.println(eventQ.toString());
		
		for (Point p : eventQ)
		{
			switch (p.getSide()) {
			case -1:
				inputBTree(p);
				processLeftPoint(p);
				break;
			case 0:
				
				break;
			case 1:
				
				break;
			default:
				break;
			}
		}
	}
	
	
}
