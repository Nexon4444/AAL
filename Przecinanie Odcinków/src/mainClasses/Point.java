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
	
	public Point(Double x, Double y, Integer side) {
		super();
		this.x = x;
		this.y = y;
		this.side = side;
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
	@Override
	public int compareTo(Point point) {
		if (this.x!=point.getX())
			return Double.compare(this.x, point.getX());
		return Double.compare(this.y, point.getY());
	}
	
}
