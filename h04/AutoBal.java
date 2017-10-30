package h04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Klasse voor een bal op een paneel die uit zichzelf beweegt
 */ 

public class AutoBal extends JPanel implements ActionListener
{
	private int horizontalePlaats = 250; // x-locatie begint in het midden  
	private int verticalePlaats = 150; // y-locatie begint in het midden
	private int richtingEnSnelheid = +1; // begint naar rechts
	private final int WACHTTIJD = 500; // event eens per halve seconde
	
	public AutoBal() // constructor
	{
		// maak de timer en start hem
		javax.swing.Timer autoKlik = new javax.swing.Timer(WACHTTIJD,this);
		autoKlik.start();
	}
	
	 // geef de huidige x-positie
	public int getHorPlaats()
	{
		return horizontalePlaats;
	}
	
	 // geef de huidige y-positie
	public int getVerPlaats()
	{
		return verticalePlaats;
	}
	
	 // geef de huidige snelheid en richting
	public int getRichtingEnSnelheid()
	{
		return richtingEnSnelheid;
	}
	
	// stel de x-positie in zoals aangeleverd
	public void setHorPlaats(int nieuweHorPlaats) 
	{
		horizontalePlaats = nieuweHorPlaats;
	}
	
		// stel de y-positie in zoals aangeleverd
	public void setVerPlaats(int nieuweVerPlaats) 
	{
		verticalePlaats = nieuweVerPlaats;
	}
	
	// stel de richting en snelheid in zoals aangeleverd
	public void setRichtingEnSnelheid(int nieuweRichtingEnSnelheid) 
	{
		richtingEnSnelheid = nieuweRichtingEnSnelheid;
	}
	
	// bij elke automatische event de horizontale plaats aanpassen
	// en de bal opnieuw tekenen
	public void actionPerformed(ActionEvent e)
	{
		setHorPlaats( getHorPlaats() + richtingEnSnelheid );
		repaint();
	}

	// teken de bal, oranje met zwarte lijnen
	public void paintComponent(Graphics g)
	{
		super.paintComponent( g );
		final int BALDIAMETER = 100; // grootte van de bal

		g.setColor(Color.ORANGE);
		g.fillOval(horizontalePlaats, verticalePlaats, 
				BALDIAMETER, BALDIAMETER); // gekleurde bal
		g.setColor(Color.BLACK);
		g.drawOval(horizontalePlaats, verticalePlaats, 
				BALDIAMETER, BALDIAMETER); // omtrek van bal
		g.drawOval(horizontalePlaats + BALDIAMETER / 4 , verticalePlaats, 
				BALDIAMETER / 2, BALDIAMETER); // lijnen op de bal
	}
} 