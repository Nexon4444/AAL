package mainFunctions;

public class Vektor {
	private Integer Ordinal;
	private Integer poczX;
	private Integer poczY;
	private Integer konX;
	private Integer konY;
	private Boolean IsGrouped=false;
	
	Vektor()
	{
	}
	
	Vektor(Integer poczX, Integer poczY, Integer konX, Integer konY)
	{
		setPoczX(poczX);
		setPoczY(poczY);
		setKonX(konX);
		setKonY(konY);
	}
	
	public Integer getPoczX() {
		return poczX;
	}

	public void setPoczX(Integer poczX) {
		this.poczX = poczX;
	}


	public Integer getPoczY() {
		return poczY;
	}


	public void setPoczY(Integer poczY) {
		this.poczY = poczY;
	}


	public Integer getKonX() {
		return konX;
	}


	public void setKonX(Integer konX) {
		this.konX = konX;
	}


	public Integer getKonY() {
		return konY;
	}


	public void setKonY(Integer konY) {
		this.konY = konY;
	}


	public String toString()
	{
		return ("{(" + poczX.toString() + " " + poczY.toString() + "), ("
				+ konX.toString() + " " + konY.toString() + ")}");
				
		
	}

	public Integer getOrdinal() {
		return Ordinal;
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
	
}
