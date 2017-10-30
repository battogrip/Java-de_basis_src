package h08;

import javax.swing.*;

/*
 * Maak vijf buttons met een pictogram onder elkaar
 */

public class PictogramDemoPaneel extends JPanel
{
	private String[ ] pictogramNaam;

	public PictogramDemoPaneel() // constructor
	{
		// vul een array met de namen van de bestanden
		pictogramNaam = new String[5];
		pictogramNaam[0] = "GreenApple";
		pictogramNaam[1] = "Orange";
		pictogramNaam[2] = "Pear";
		pictogramNaam[3] = "RedApple";
		pictogramNaam[4] = "Strawberry";
		
		// zorg dat we de elementen zelf kunnen plaatsen
		setLayout( null ); // geen lay-outmanager
		
		// zet alle variabelen en constanten klaar
		String tekst; // tijdelijke opslag van de naam
		ImageIcon afbeelding;
		JButton knop;
		int MARGE = 20; // afstand vanaf de bovenrand
		int KNOP_BREEDTE = 200; // breedte in pixels
		int KNOP_HOOGTE = 56; // breedte in pixels
		int KNOP_AFSTAND = KNOP_HOOGTE + 4; // verschuiving
		int X_LOCATIE = 80; // linkerkant van de knop
		
		//voeg de afbeeldingen toe aan het paneel
		for (int x=0; x<pictogramNaam.length; x++)
		{
			tekst = pictogramNaam[x];
			afbeelding = new ImageIcon("Fruit/" + tekst + ".gif");
			knop = new JButton(tekst, afbeelding );
			knop.setBounds(X_LOCATIE, x * KNOP_AFSTAND + MARGE, 
					KNOP_BREEDTE, KNOP_HOOGTE);
			add( knop );
		}
	} // einde constructor
}

