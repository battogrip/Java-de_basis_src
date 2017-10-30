package h06;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 * Blink is een denkspel waarbij de speler eerst moet uitvogelen
 * hoe het spel werkt voordat hij over de oplossing kan nadenken.
 * De oplossing is in vijf klikken voor elkaar te krijgen, maar
 * mensen die het spel niet kennen, hebben er tientallen of
 * honderden klikken voor nodig.
 * 
 * Deze opstartklasse maakt een venster met het speelveld.
 * 
 * @author andree hollander
 * @version 1.0 20080815
 * @see BlinkModel
 * @see BlinkView
 * @see BlinkController
 */
public class BlinkOpstart extends JFrame
{
	/**
	 *  Maakt een venster met beginsituatie en uitleg en 
	 *  start een nieuw spel.
	 */
	public BlinkOpstart() 
	{
		JFrame venster = new JFrame();
		// venster.setLayout(new BorderLayout() ); // default
		venster.setSize(500,500); // vierkante ruimte 
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Blink");
		venster.setLocation(100,100); // niet helemaal linksboven
		
		// een zin uitleg, de rest moet de speler zelf uitzoeken
		JLabel uitleg = new JLabel
		(" Probeer met muisklikken het hele veld rood te maken");
		venster.add(uitleg, BorderLayout.SOUTH );
		
		// de klasse BlinkModel verzorgt de stand van het spel
		BlinkModel spelStatus = new BlinkModel();
		// de klasse BlinkView verzorgt het afbeelden op het scherm
		BlinkView weergave = new BlinkView(spelStatus);
		venster.add( weergave, BorderLayout.CENTER );
		// de klasse BlinkController reageert op muisklikken 
		// door de speler
		new BlinkController(spelStatus, weergave);
		
		venster.setVisible(true);		
	}

	public static void main( String[ ] args)
	{
		new BlinkOpstart();
	}

}
