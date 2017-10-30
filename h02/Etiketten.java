package h02;

import  javax.swing.*;

/*
 * Hoofdstuk 2, voorbeeld 1: Etikettencalculator
 * 
 * Bereken benodigde etikettenbladen en het aantal
 * etiketten dat overblijft bij een bepaald aantal
 * benodige etiketten en een gegeven aantal
 * etiketten op een blad.
 */
public class Etiketten extends JFrame
{
	// maak een venster en stel enkele eigenschappen ervan in;
	// geef het venster een paneel als inhoud
	public Etiketten() 
	{
		JFrame venster = new JFrame();
		// 300 horizontaal ruimte voor label en tekstvak 
		// 250 verticaal: ruimte voor twee regels invoer,
		//                knop en tekstvak voor resultaat
		venster.setSize(350,250); 
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Etikettencalculator");
		venster.setLocation(100,100); // niet helemaal linksboven
		JPanel hoofdpaneel = new Etikettenpaneel();
		venster.add(hoofdpaneel);
		venster.setVisible(true);		
	}

	public static void main( String[ ] args)
	{
		new Etiketten();
	}
}
