package h04;

import java.awt.*;
import javax.swing.*;

// Klasse voor de bal op een paneel 

public class VerplaatsBal2Paneel extends JPanel
{
	private int horizontalePlaats = 250; // x-locatie begint in het midden  

	 // geef de huidige x-positie
	public int getHorPlaats()
	{
		return horizontalePlaats;
	}
	
	// stel de x-positie in zoals aangeleverd
	public void setHorPlaats(int nieuweHorPlaats) 
	{
		horizontalePlaats = nieuweHorPlaats;
	}
	
	// teken de bal, oranje met zwarte lijnen
	public void paintComponent(Graphics g)
	{
		super.paintComponent( g );
		final int BALDIAMETER = 100; // grootte van de bal
		final int VERTICALE_PLAATS = 150; // y-locatie in het midden
		g.setColor(Color.ORANGE);
		g.fillOval(horizontalePlaats, VERTICALE_PLAATS, 
				BALDIAMETER, BALDIAMETER); // gekleurde bal
		g.setColor(Color.BLACK);
		g.drawOval(horizontalePlaats, VERTICALE_PLAATS, 
				BALDIAMETER, BALDIAMETER); // omtrek van bal
		g.drawOval(horizontalePlaats + BALDIAMETER / 4 , VERTICALE_PLAATS, 
				BALDIAMETER / 2, BALDIAMETER); // lijnen op de bal
	}
} 