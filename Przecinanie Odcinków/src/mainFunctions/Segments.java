package mainFunctions;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.math3.analysis.function.Max;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularMatrixException;

import mainFunctions.Vektor;

/**
 * @author Nexon
 *
 */
public class Segments {
	
	ArrayList<ArrayList<Vektor>> arrayOfData;
	ArrayList<ArrayList<Vektor>> arrayOfGroups;
	
	static boolean checkIfIntersect(Vektor vec1, Vektor vec2)
	{	
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
			return false;
		}
		return checkIfBelongs(vec1, vec2, solution.getEntry(0), solution.getEntry(1));

	}
	
	static boolean checkIfBelongs(Vektor vec1, Vektor vec2, Double x, Double y)
	{
		if (x > Math.max(vec1.getKonX(), vec1.getPoczX()) || x < Math.min(vec1.getKonX(), vec1.getPoczX())) return false;
		if (y > Math.max(vec1.getKonY(), vec1.getPoczY()) || y < Math.min(vec1.getKonY(), vec1.getPoczY())) return false;
		return true;
	}
	
	static ArrayList <ArrayList <Integer>> primitiveFamilyCheck(ArrayList<Vektor> listOfVektors)
	{
		int ArrayList;
		ArrayList <ArrayList<Vektor>> family = new ArrayList <ArrayList<Vektor>>();
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
					if(checkIfIntersect(vekPoz, vekPion)) 
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

	
	
}
