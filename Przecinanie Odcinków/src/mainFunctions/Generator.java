package mainFunctions;

import java.util.ArrayList;
import java.util.Random;

import mainClasses.Point;
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
	
	public Generator(int s, int mean, int variance, int amount, int width, int height) {
		super();
		this.s = s;
		this.mean = s/2;
		this.variance = variance;
		this.amount = amount;
		this.width = width;
		this.height = height;
	}



	public void generate()
	{
		for (int i=0; i<amount; i++)
		{
			Point pocz = genarateFirstPoint();
			Point kon = genarateSecondPoint(pocz);
			data.add(new Vektor(genarateFirstPoint(), genarateSecondPoint(pocz)));
		}
	}
	
	private double getGaussian(){
	    return mean + random.nextGaussian() * variance;
	  }
	
	private int generateLength()
	{
		double length = getGaussian();
		length =length%s;
		System.out.format("%.0f%n", length);
		return (int)length + 1;
	}
	
	private Point genarateFirstPoint()
	{
		return new Point((double)random.nextInt()%width, (double)random.nextInt()%height);
	}
	
	private Point genarateSecondPoint(Point point)
	{
		int l=generateLength();
		int x=random.nextInt()%l;
		int y=l-x; 
		return new Point(point.getX()+x, point.getY()+y);
	}

	public void showGenerated()
	{
		for (Vektor vek : data)
		{
			System.out.println(vek.toString());
		}
	}
	
	@Override
	public String toString() {
		return "Generator [s=" + s + ", mean=" + mean + ", variance=" + variance + ", amount=" + amount + ", width="
				+ width + ", height=" + height + ", random=" + random + ", data=" + data + "]";
	}	
	
	
}
