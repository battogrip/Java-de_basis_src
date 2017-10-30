package h04;

import javax.swing.*;

/*
 * invoervelden: dag, maand, jaar in numerieke vorm
 * uitvoer: een tekst die meldt wat de volgende dag is
 */

public class VolgendeDag2  extends JFrame
{
	// maak een venster en stel enkele eigenschappen ervan in;
	// geef het venster een paneel als inhoud
	public VolgendeDag2() 
	{
		JFrame venster = new JFrame();
		venster.setSize(350,200); 
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Bepaal volgende dag");
		venster.setLocation(100,100); // niet helemaal linksboven
		venster.add( new VolgendeDag2Paneel() );
		venster.setVisible(true);		
	}

	public static void main( String[ ] args)
	{
		new VolgendeDag2();
	}
}
