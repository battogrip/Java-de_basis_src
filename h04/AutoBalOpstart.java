package h04;

import javax.swing.*; // voor JFrame
import java.awt.*; // voor de BorderLayout

/*
 * Programma: Automatische bal
 * Auteur: Andree Hollander, 2008
 * 
 * Dit programma tekent een bal met een vaste grootte, 
 * bijvoorbeeld 100 pixels. De bal staat bij het begin van het 
 * programma ongeveer in het midden van het scherm en beweegt
 * automatisch naar rechts. 
 * Er zijn knoppen waarmee de gebruiker de richting van de bal
 * kan omkeren en de bal omhoog of omlaag kan brengen.
 */

public class AutoBalOpstart extends JFrame 
{
	// maak een venster met twee panelen als inhoud
	public AutoBalOpstart() 
	{
		JFrame venster = new JFrame();
		// venster.setLayout(new BorderLayout() ); // default
		venster.setSize(700,400); // veel ruimte voor de bal
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Automatische bal");
		venster.setLocation(100,100); // niet helemaal linksboven

		AutoBal bal; // de bal die uit zichzelf beweegt	
		bal = new AutoBal();
		venster.add( bal, BorderLayout.CENTER );
		
		AutoBalBediening bedieningspaneel; // knoppen
		bedieningspaneel = new AutoBalBediening(bal);
		venster.add(bedieningspaneel, BorderLayout.SOUTH );
		
		venster.setVisible(true);
	}

	public static void main( String[ ] args)
	{
		new AutoBalOpstart();
	}
}
