package h09;

import javax.swing.JPanel; // voor JPanel
import java.awt.*; // voor paintComponent

public class Zuiger extends JPanel implements Runnable 
{
	private int zuigerHoogte, zuigerBreedte;
	private  int paneelBreedte; 
	private final int HOUDER_HOOGTE = 20; // voorbeeldwaarde
	private int paneelHoogte; 
	int bewegingsrichting = -1; // wisselt tussen +1 en -1
	int WACHTTIJD = 10; // milliseconden
	
	// Maak een zuiger met opgegeven breedte en hoogte
	// en start een thread voor de animatie
	public Zuiger(int breedte, int hoogte) // constructor
	{
		zuigerBreedte = breedte;
		zuigerHoogte = hoogte;
		paneelBreedte = 3 * zuigerBreedte;
		paneelHoogte = zuigerHoogte + HOUDER_HOOGTE;
		Thread beweging = new Thread(this);
		beweging.start();
	}
	
	// Eindeloze lus met aanpassing van de hoogte van de zuiger
	public void run()
	{
		while (true)
		{
			zuigerHoogte = zuigerHoogte + bewegingsrichting;
			// System.out.print(zuigerHoogte + "  "); // debug
			if (zuigerHoogte < paneelHoogte / 4 || 
					zuigerHoogte > paneelHoogte)
			{
				bewegingsrichting = bewegingsrichting * -1; // omkeren
			}
			repaint();
			try
			{
				Thread.sleep(WACHTTIJD);
			}
			catch (InterruptedException e) 	{ }
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		// teken de houder waarin de zuiger staat
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0,paneelHoogte - HOUDER_HOOGTE / 2, 
				paneelBreedte, HOUDER_HOOGTE);
		
		// teken de zuiger
		g.setColor(Color.GRAY);
		int yLoc = paneelHoogte - zuigerHoogte ;
		g.fillRect(zuigerBreedte,yLoc, zuigerBreedte, zuigerHoogte);
	}
}
