package h08;

import javax.swing.*;

/*
 * Programma PictogramDemoOpstart, Andree Hollander, 2008
 * 
 * Demonstratie van de klasse ImageIcon om een pictogram
 * bij een button te krijgen
 */

public class PictogramDemoOpstart extends JFrame
{
	// maak een venster en stel enkele eigenschappen ervan in;
	// geef het venster een paneel als inhoud
	public PictogramDemoOpstart() 
	{
		JFrame venster = new JFrame();
		venster.setSize(350,350); 
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Demonstratie ImageIcon");
		venster.setLocation(100,100); // niet helemaal linksboven
		venster.add( new PictogramDemoPaneel() );
		venster.setVisible(true);		
	}

	public static void main( String[ ] args)
	{
		new PictogramDemoOpstart();
	}
}