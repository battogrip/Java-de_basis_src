package h02;

import  javax.swing.*; // voor JFrame

/* 
 * Hoofdstuk 2, voorbeeld: Paraplu
 * Teken een paraplu in een door de gebruiker op te geven kleur.
 * De paraplu heeft een vaste grootte, maar moet horizontaal in
 * het midden staan (links en rechts even veel ruimte). 
 */

public class Paraplu extends JFrame
{
	// maak een venster met een paneel als inhoud
	public Paraplu() 
	{
		JFrame venster = new JFrame();
		// ruim genoeg voor paraplu
		venster.setSize(500,500); 
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Een gekleurde paraplu");
		venster.setLocation(100,100); // niet helemaal linksboven
		venster.add( new Paraplupaneel() );
		venster.setVisible(true);
	}

	public static void main( String[ ] args)
	{
		new Paraplu();
	}
}
