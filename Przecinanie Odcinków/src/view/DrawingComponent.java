package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;

import mainClasses.Vektor;



public class DrawingComponent extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList <ArrayList<Vektor>> family = new ArrayList <ArrayList<Vektor>>();
	ArrayList<Color> colours;
	Random random = new Random();
	
	public void paintComponent(Graphics g)
	{
		createColorArray();
		Graphics2D g2d = (Graphics2D) g;
		drawFamily(g2d);
	}

	public DrawingComponent(ArrayList<ArrayList<Vektor>> family) {
		super();
		this.family = family;
	}
	
	private void createColorArray()
	{
	
	}
	private Color generateColor(int npw)
	{
//		if (npw<colours.size())
//		{
//			return colours.get(npw);
//		}
		
		return new Color((float)random.nextDouble()%128, (float)random.nextDouble()%128, (float)random.nextDouble()%128);
		
	}
	private void drawFamily(Graphics2D g2d)
	{
		for (int i=0; i < family.size(); i++)
		{
			ArrayList<Vektor> vekArr = family.get(i);
			g2d.setPaint(generateColor(i)); 
			for(Vektor vek : vekArr)
			{
				Line2D.Double line = new Line2D.Double(vek.getPoczX()*Visualization.ratio, vek.getPoczY()*Visualization.ratio, vek.getKonX()*Visualization.ratio, vek.getKonY()*Visualization.ratio);
				
				g2d.draw(line);
			}
		}
	}
	
}
