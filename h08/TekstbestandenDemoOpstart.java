package h08;

import javax.swing.*;

/*
 * Programma TekstbestandenDemo, Andree Hollander, 2008
 * 
 * Demonstratie van het schrijven en lezen van tekstbestanden
 */

public class TekstbestandenDemoOpstart extends JFrame
{
	// maak een venster en stel enkele eigenschappen ervan in;
	// geef het venster een paneel als inhoud
	public TekstbestandenDemoOpstart() 
	{
		JFrame venster = new JFrame();
		venster.setSize(580,250); 
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Demonstratie tekstbestanden");
		venster.setLocation(100,100); // niet helemaal linksboven
		venster.add( new TekstbestandenDemoPaneel(venster) );
		venster.setVisible(true);		
	}

	public static void main( String[ ] args)
	{
		new TekstbestandenDemoOpstart();
	}
}