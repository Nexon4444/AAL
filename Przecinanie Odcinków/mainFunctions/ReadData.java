package mainFunctions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import mainClasses.Vektor;

public class ReadData {
	
	
	static public ArrayList<Vektor> read(String filePath) throws FileNotFoundException
	{
		FileReader file = new FileReader(filePath);
		Scanner reader = new Scanner(file);
		
		ArrayList<Vektor> arrayOfData = new ArrayList<Vektor>();
		
		try {
			int i=0;
			while (reader.hasNextInt())
			{
				Vektor pom = new Vektor();
				pom.setPoczX((double) reader.nextInt());
				//reader.nextInt();
				
				pom.setPoczY((double) reader.nextInt());
//				reader.nextInt();
				
				pom.setKonX((double) reader.nextInt());
//				reader.nextInt();
				
				pom.setKonY((double) reader.nextInt());
//				reader.nextInt();
				
				pom.setOrdinal(i);
				
				pom.setLeftRight();
				arrayOfData.add(pom);
				i++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		reader.close();
		//System.out.println(arrayOfData.toString());
		
		return arrayOfData;
		
	}
}
