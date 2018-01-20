package mainFunctions;

import java.util.ArrayList;

import mainClasses.Vektor;

public class Test {
	
	
	int actionAmount = 10;
	int vekAmountMin = 1000;
	int vekAmountMax = 10000;
	int vekAmountStep = 1000;
	int width = 1000;
	int height = 1000;
	int length = 40;
	static int MaxCharAmountPerLine = 25;

	ArrayList <Long> results = new ArrayList<Long>();
	Segments segm;
	Generator gen;

	ArrayList<Vektor> data;
	ArrayList<ArrayList <ArrayList <Vektor>>> blackhole = new ArrayList<ArrayList<ArrayList <Vektor>>>();
	public long primitiveEstimated;
	public long sweepEstimated;
	private int variance;
	
	public Test(Segments segm, Generator gen, Integer warmUpAmount) {
		super();
		this.segm = segm;
		this.gen = gen;
		this.actionAmount = warmUpAmount;
		this.data = gen.getData();

	}

	public Test(int vekAmountMin, int vekAmountMax, int vekAmountStep, int length, int variance) {
		super();
		this.vekAmountMin = vekAmountMin;
		this.vekAmountMax = vekAmountMax;
		this.vekAmountStep = vekAmountStep;
		this.length = length;
		this.variance = variance;
	}

	public Test() {
		super();
	}

	void warmupPrimitive ()
	{System.out.println("warming up primitive =========================");
		for (int i=0; i < actionAmount; i++)
		{
			segm = new Segments();
			gen = new Generator(length, 5, vekAmountMax/2, width, height);
			try {
				segm.brutalCheck(gen.getData());
				blackhole.add(segm.getFamily());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("warmup: " + (i+1) + " completed");
		}
	}
	
	void warmupSweepLine ()
	{System.out.println("warming up sweeplLine =========================");
	for (int i=0; i < actionAmount; i++)
	{
		segm = new Segments();
		gen = new Generator(length, 5, vekAmountMax/2, width, height);
		try {
			segm.sweepAlgorithm(gen.getData());
			blackhole.add(segm.getFamily());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("warmup: " + (i+1) + " completed");
	}
	}
	
	long measurePrimitive(int amount)
	{
		
		long startime = System.nanoTime();
		for (int i=0; i < actionAmount; i++)
		{
			gen = new Generator(length, variance, amount, width, height);
			gen.generate();
			try {
				segm.brutalCheck(gen.getData());
				blackhole.add(segm.getFamily());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		primitiveEstimated = (System.nanoTime() - startime)/actionAmount;
		blackhole.add(segm.getFamily());
		return primitiveEstimated;
		
	}
	
	
	long measureSweepLine(int amount)
	{
		long startime = System.nanoTime();
		for (int i=0; i < actionAmount; i++)
		{
			gen = new Generator(length, 10, amount, width, height);
			gen.generate();
			try {
				segm.sweepAlgorithm(gen.getData());
				blackhole.add(segm.getFamily());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		primitiveEstimated = (System.nanoTime() - startime)/actionAmount;
		blackhole.add(segm.getFamily());
		return primitiveEstimated;
		
	}

	
	void testBoth()
	{

		System.out.println("primitve to sweep" + primitiveEstimated/sweepEstimated);
	}
	
	double logn(int medianN)
	{
		return Math.log10(vekAmountMin+(medianN-1)*vekAmountStep);
	}
	
	void viewSweepLine()
	{
		System.out.println("generator settings: " + gen.toString());
		int medianIndx = (results.size()+1)/2-1;
		Long medianTime = results.get(medianIndx);
		int medianN = vekAmountMin+(medianIndx)*vekAmountStep;
		double T = ((double) medianN*(logn(medianN)));
		double c = medianTime/T;
		
		
		System.out.println("Algorithm: SweepLine");
		print("n");
		print("t(n)[ms]");
		print("q(n)");
		System.out.println();
		System.out.println("=========================|=========================|=========================|");
		
		for (int i = 0; i<results.size(); i++)
		{
			Integer n = new Integer (vekAmountMin+i*vekAmountStep);
			print(n.toString());
			
			Long y = results.get(i);
			Long x = results.get(i)/100000 ;
			
			print(x.toString());
			Double q = new Double(y/(c*n*logn(n)));
			print(q.toString());
			System.out.println();
		}
		
		
	}
	void viewPrimitive()
	{
		System.out.println("generator settings: " + gen.toString());
		int medianIndx = (results.size()+1)/2-1;
		Long medianTime = results.get(medianIndx);
		int medianN = vekAmountMin+(medianIndx)*vekAmountStep;
		double T = ((double) medianN*medianN);
		double c = medianTime/T;
		System.out.println("Algorithm: Primitive");
		print("n");
		print("t(n)[ms]");
		print("q(n)");
		System.out.println();
		System.out.println("=========================|=========================|=========================|");
		
		for (int i = 0; i<results.size(); i++)
		{
			Integer n = new Integer (vekAmountMin+i*vekAmountStep);
			print(n.toString());
			
			Long y = results.get(i);
			Long x = results.get(i)/100000;
			
			print(x.toString());
			Double q = new Double(y/(c*n*n));

			print(q.toString());
			System.out.println();
		}
		
		
	}
	
	void conductTest()
	{
		warmupSweepLine();
		for (int amount = vekAmountMin; amount<vekAmountMax; amount += vekAmountStep)
		{
			System.out.println("measuring for n = " + amount);
			segm = new Segments();
			results.add(measureSweepLine(amount));
			
		}
		viewSweepLine();
		results.clear();
		warmupPrimitive();
	for (int amount = vekAmountMin; amount<vekAmountMax; amount += vekAmountStep)
	{
		System.out.println("measuring for n = " + amount);
		segm = new Segments();
		
		results.add(measurePrimitive(amount));

	}
	
	viewPrimitive();
	}
	
	public static void print(String str)
	{
		jumpDistance((MaxCharAmountPerLine-str.length())/2);
		System.out.print(str);
		jumpDistance(MaxCharAmountPerLine-(MaxCharAmountPerLine-str.length())/2-str.length());
		System.out.print("|");

	}

	public static void jumpDistance(Integer toJump)
	{
		for (int j = 0; j < toJump; j++) System.out.print(" ");
	}



	@Override
	public String toString() {
		return "Test [vekAmountMin=" + vekAmountMin + ", vekAmountMax=" + vekAmountMax + ", vekAmountStep="
				+ vekAmountStep + "]";
	}
	
	
}
