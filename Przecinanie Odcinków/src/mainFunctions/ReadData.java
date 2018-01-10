package mainFunctions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

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
				pom.setPoczX(reader.nextInt());
				//reader.nextInt();
				
				pom.setPoczY(reader.nextInt());
//				reader.nextInt();
				
				pom.setKonX(reader.nextInt());
//				reader.nextInt();
				
				pom.setKonY(reader.nextInt());
//				reader.nextInt();
				
				pom.setOrdinal(i);
				
				arrayOfData.add(pom);
				i++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		reader.close();
		System.out.println(arrayOfData.toString());
		
		return arrayOfData;
		
	}
}
