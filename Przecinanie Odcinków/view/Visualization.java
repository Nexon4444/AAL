package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import mainClasses.Vektor;

public class Visualization {
	ArrayList <ArrayList<Vektor>> family = new ArrayList <ArrayList<Vektor>>();
	 int width;
	 int height;

	public Visualization(ArrayList<ArrayList<Vektor>> family, int width, int height) {
		super();
		this.family = family;
		this.width = width;
		this.height = height;
	}

	public void visualize()
	{
		JFrame window = new JFrame();
		window.setBackground(Color.blue);
		setWindow(window);
		DrawingComponent DC = new DrawingComponent(family);
		window.add(DC);
	}
	
	private void setWindow(JFrame window)
	{
		window.setSize(width, height);
		window.setTitle("Przecinanie odcinkow");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	
}
