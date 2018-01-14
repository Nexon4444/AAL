package mainFunctions;
import java.util.ArrayList;
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
	static TreeMap<Point, Vektor> BTree = new TreeMap<Point, Vektor>();
	static LinkedList<Point> eventQ = new LinkedList<Point>();
	static Integer lastGroupNumber = -1 ;
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
	
	static Point checkIfBelongsOLD(Vektor vec1, Vektor vec2, Double x, Double y)
	{
		if (x > Math.max(vec1.getKonX(), vec1.getPoczX())
				|| x < Math.min(vec1.getKonX(), vec1.getPoczX())) return null;
		if (y > Math.max(vec1.getKonY(), vec1.getPoczY()) || y < Math.min(vec1.getKonY(), vec1.getPoczY())) return null;
		return new Point(x, y, 0, null, vec1, vec2);
	}
	
	static Point checkIfBelongs(Vektor vec1, Vektor vec2, Double x, Double y)
	{
		Point point = new Point(y, x, 0, null, vec1, vec2);
		if ((point.compareTo(vec1.getLeft())<0) || (point.compareTo(vec2.getLeft())<0)) return null;
		if ((point.compareTo(vec1.getRight())>0) || (point.compareTo(vec2.getRight())>0)) return null;
		return new Point(x, y, 0, null, vec1, vec2);
	}
	
	static ArrayList <ArrayList <Integer>> primitiveFamilyCheckOLD(ArrayList<Vektor> listOfVektors)
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

		System.out.println(family.toString());
		return null;
	}
	static void primitiveFamilyCheck(ArrayList<Vektor> listOfVektors)
	{
//		family.add(ArrayList<Vektor> = new ArrayList<Vektor> listOfVektors.get(0));
		for (int i = 0, max = listOfVektors.size(); i<max; i++)
			{
			 Vektor vekPoz = listOfVektors.get(i);
			 for (int j = i+1;  j != listOfVektors.size() ; j++)
				{
				 Vektor vekPion = listOfVektors.get(j);				  
				 mark(vekPion,vekPoz);
				 }
			}
//		return null;
	}
	
	static void fillTree(ArrayList<Vektor> data) //fill the tree with values
	{
		for (Vektor vek : data)
		{
			BTree.put(vek.getLeft(), vek);
			BTree.put(vek.getRight(), vek);
		}
	}
	
	static Point mark(Vektor vec1, Vektor vec2)
	{
		Point point=checkIfIntersect(vec1, vec2);
		if (point!=null)
		{	if(vec1.group==-1&&vec2.group==-1)
			{
				lastGroupNumber++;
				vec2.group=vec1.group=lastGroupNumber;
			}
			else
			{
				if (vec1.group== -1) //sprawwdzi� czy nie ma b��du !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				{
					vec1.group=vec2.group;
				}
			
				else vec2.group=vec1.group;
				
			}
			return point;
		}
		else return null;
	}
	
	static void inputBTree(Point element)
	{
		System.out.println(element.toString());
		System.out.println(element.getVek().toString());
		BTree.put(element, element.getVek());
	}
	
	static void processLeftPoint(Point element)
	{
		Vektor vek1=null;
		Vektor vek2=null;
		if (BTree.higherEntry(element)!=null)
			vek1 = BTree.higherEntry(element).getValue();
		if (BTree.lowerEntry(element)!=null)
			vek2 = BTree.lowerEntry(element).getValue();
		Point p1 = mark(vek1, element.getVek());
		Point p2 = mark(vek2, element.getVek());
		if (p1!=null) inputQ(p1);
		if (p2!=null) inputQ(p2);
	}
	static void processIntersection(Point element)
	{
		Point p1 = null;
		Point p2 = null;
		System.out.println(BTree); 
//		System.out.println("element.vekInter1.getLeft(): " + element.vekInter1.getLeft() + "for: " + element.vekInter2);
//		System.out.println("element.vekInter2.getLeft(): " + element.vekInter2.getLeft() + "for: " + element.vekInter1);
		BTree.replace(element.vekInter1.getLeft(), element.vekInter2);
		BTree.replace(element.vekInter2.getLeft(), element.vekInter1);
		System.out.println(BTree);
		
		if(element.vekInter1.getRight().getY()>element.vekInter2.getRight().getY()) // if inter1 > inter2, higher end
		{																			//a co je�li "=="???????????????????????????????????????????????????????????????????
			Point higher = element.vekInter2.getLeft();
			Point lower = element.vekInter1.getLeft();
			
			System.out.println("powinno byc (0,2): " + higher);
			System.out.println("powinno byc (0,0): " + lower);
			if (BTree.higherEntry(higher)!= null)
				p1 = mark(BTree.get(higher), BTree.higherEntry(higher).getValue());
			if (BTree.lowerEntry(lower)!= null)
				p2 = mark(BTree.get(lower), BTree.lowerEntry(lower).getValue());
		}
		
		else
		{
			Point higher = element.vekInter1.getLeft();
			Point lower = element.vekInter2.getLeft();
			if (BTree.higherEntry(higher)!= null)
				p1 = mark(BTree.get(higher), BTree.higherEntry(higher).getValue());
			if (BTree.lowerEntry(lower)!= null)
				p2 = mark(BTree.get(lower), BTree.lowerEntry(lower).getValue());
		}
		if (p1!=null)
			inputQ(p1);
		if (p2!=null) 
			inputQ(p2);
	}
	static void processRightPoint(Point element)
	{
		Point point = null;
		if(BTree.higherKey(element)!=null && BTree.lowerKey(element)!=null) point = mark(BTree.higherKey(element).getVek(), BTree.lowerKey(element).getVek());
		if (point != null) inputQ(point);
		BTree.remove(element.getVek().getLeft());
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
	
	static void showGroups(ArrayList<Vektor> data)
	{
		ArrayList <ArrayList <Vektor>> result = new ArrayList <ArrayList <Vektor>>();
		ArrayList <Vektor> aux = new ArrayList <Vektor>();
		int i =0;
		for (Vektor vek : data)
		{
			System.out.print(i + ": ");
			System.out.println(vek.group);
			i++;
		}
	}
	
	static void sweepAlgorithm(ArrayList<Vektor> data)
	{
		fillQ(data);
//		System.out.println(eventQ.toString());
		Point p;
		for (int i = 0; i<eventQ.size();i++)
		{	p = eventQ.get(i);
			switch (p.getSide()) {
			case -1:
				inputBTree(p);
				processLeftPoint(p);
				break;
			case 0:
				processIntersection(p);
				break;
			case 1:
				processRightPoint(p);
				break;
			default:
				break;
			}
			
		}
		System.out.println("leco grupy");
		System.out.println(data.toString());
		showGroups(data);

	}
	
	
}
