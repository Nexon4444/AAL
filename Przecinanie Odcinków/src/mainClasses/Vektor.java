package mainClasses;

public class Vektor  {
	private Integer Ordinal;
	private Double poczX;
	private Double poczY;
	private Double konX;
	private Double konY;
	private Boolean IsGrouped=false;
	private Point left;
	private Point right;
	public Integer group = -1;
	
	public Vektor()
	{
		
	}
	
	public Vektor(Point pocz, Point kon)
	{
		setPoczX(pocz.getX());
		setPoczY(pocz.getY());
		setKonX(kon.getX());
		setKonY(kon.getY());
		setLeftRight();
	}
	Vektor(Double poczX, Double poczY, Double konX, Double konY)
	{
		setPoczX(poczX);
		setPoczY(poczY);
		setKonX(konX);
		setKonY(konY);
		setLeftRight();
	}
	
	public void setLeftRight() {
		Point p1 = new Point (poczX, poczY, 0, this);
		Point p2 = new Point (konX, konY, 0, this);
		if (p1.compareTo(p2)<0) 
			{
				p1.setSide(-1);
				p2.setSide(1);
				setLeft (p1);
				setRight (p2);
			}
		else
		{
			p2.setSide(-1);
			p1.setSide(1);
			setLeft (p2);
			setRight (p1);
		}
	}

	public Double getPoczX() {
		return poczX;
	}

	public void setPoczX(Double poczX) {
		this.poczX = poczX;
	}


	public Double getPoczY() {
		return poczY;
	}


	public void setPoczY(Double poczY) {
		this.poczY = poczY;
	}


	public Double getKonX() {
		return konX;
	}


	public void setKonX(Double konX) {
		this.konX = konX;
	}


	public Double getKonY() {
		return konY;
	}


	public void setKonY(Double konY) {
		this.konY = konY;
	}


//	public String toString()
//	{
//		return ("{(" + poczX.toString() + " " + poczY.toString() + "), ("
//				+ konX.toString() + " " + konY.toString() + ")}");
//	}
	
	

	public Integer getOrdinal() {
		return Ordinal;
	}

	public Integer getGroup() {
		return group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Vektor [(" + poczX + ", " + poczY + "), (" + konX + ", " + konY + "), group=" + group
				+ "]";
	}

	public void setOrdinal(Integer ordinal) {
		Ordinal = ordinal;
	}

	public Boolean getIsGrouped() {
		return IsGrouped;
	}

	public void setIsGrouped(Boolean isGrouped) {
		IsGrouped = isGrouped;
	}

	public Point getLeft() {
		return left;
	}

	public void setLeft(Point left) {
		this.left = left;
	}

	public Point getRight() {
		return right;
	}

	public void setRight(Point right) {
		this.right = right;
	}

	
	
}
