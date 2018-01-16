/**
 * 
 */
package mainClasses;

/**
 * @author Nexon
 *
 */
public class Point implements Comparable <Point> {
	Double x;
	Double y;
	Integer side;
	Vektor vek;
	public Vektor vekInter1=null;
	public Vektor vekInter2=null;
	
	public Point(Double x, Double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point(Double x, Double y, Integer side, Vektor vek) {
		super();
		this.x = x;
		this.y = y;
		this.side = side;
		this.vek = vek;
	}
	

	public Point(Double x, Double y, Integer side, Vektor vek, Vektor vekInter1, Vektor vekInter2) {
		super();
		this.x = x;
		this.y = y;
		this.side = side;
		this.vek = vek;
		this.vekInter1 = vekInter1;
		this.vekInter2 = vekInter2;
	}


	public void setIntersectingVektors(Vektor vek1, Vektor vek2)
	{
		vekInter1=vek1;
		vekInter2=vek2;	
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	public Integer getSide() {
		return side;
	}
	public void setSide(Integer side) {
		this.side = side;
	}
	
	public Vektor getVek() {
		return vek;
	}
	public void setVek(Vektor vek) {
		this.vek = vek;
	}
//	public String toString()
//	{
//		return new String("(" + x + ", " + y + ")" );
//		
//	}
	
	
	@Override
	public int compareTo(Point point) {
		if (!this.x.equals(point.getX()))
			return Double.compare(this.x, point.getX());
		return Double.compare(this.y, point.getY());
	}

	@Override
	public String toString() {
		return "Point [" + x +" , "+ y +"]";
	}
	
}
