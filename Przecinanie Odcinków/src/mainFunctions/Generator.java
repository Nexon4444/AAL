package mainFunctions;

import java.util.ArrayList;
import java.util.Random;
import mainClasses.Vektor;

public class Generator {
	int s;
	int mean;
	int variance;
	int amount;
	int width; 
	int height;
	Random random = new Random();
	ArrayList<Vektor> data = new ArrayList<Vektor>();
	
	public Generator(int s, int mean, int variance, int amount, Random random, int width, int height) {
		super();
		this.s = s;
		this.mean = s/2;
		this.variance = variance;
		this.amount = amount;
		this.random = random;
		this.width = width;
		this.height = height;
	}



	public void generate()
	{
		for (int i=0; i<amount; i++)
		{
//			 RandomGaussian gaussian = new RandomGaussian();
		}
	}
	
	private double getGaussian(){
	    return mean + random.nextGaussian() * variance;
	  }
	
	private int generateLength()
	{
		double length = getGaussian();
		if (s<length) length = s;
		System.out.format("%.0f%n", length);
		return (int)length;
	}
	
	private int genarateFirstPoint()
	{
		random.nextInt();
	}
	
}
