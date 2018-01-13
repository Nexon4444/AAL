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
	
	public Point(Double x, Double y, Integer side, Vektor vek) {
		super();
		this.x = x;
		this.y = y;
		this.side = side;
		this.vek = vek;
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
	public String toString()
	{
		return new String("(" + x + ", " + y + ")" );
		
	}
	@Override
	public int compareTo(Point point) {
		if (!this.x.equals(point.getX()))
			return Double.compare(this.x, point.getX());
		return Double.compare(this.y, point.getY());
	}
	
}
