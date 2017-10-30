package h07;

import java.awt.Color; 
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * Klasse voor een bal van variabele grootte op een paneel
 */ 

public class Bal extends JPanel
{
	private int diameter; // grootte van de bal
	private final int X_LOC = 0, Y_LOC = 0; // linksboven
	
	public Bal(int grootte) // constructor
	{
		diameter = grootte;
	}
	
	// teken de bal, oranje met zwarte lijnen
	public void paintComponent(Graphics g)
	{
		super.paintComponent( g );

		g.setColor(Color.ORANGE);
		g.fillOval(X_LOC, Y_LOC, diameter, diameter); // bal zelf
		g.setColor(Color.BLACK);
		g.drawOval(X_LOC, Y_LOC, diameter, diameter); // omtrek 
		g.drawOval(X_LOC + diameter / 4 , Y_LOC, 
				diameter / 2, diameter); // lijnen 
	}
} 