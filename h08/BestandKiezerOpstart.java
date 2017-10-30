package h08;

import javax.swing.*;

/*
 * Programma BestandKiezer, Andree Hollander, 2008
 * 
 * Demonstratie van de klasse FileDialog om de gebruiker
 * een bestand te laten kiezen om te openen of te saven
 */

public class BestandKiezerOpstart extends JFrame
{
	// maak een venster en stel enkele eigenschappen ervan in;
	// geef het venster een paneel als inhoud
	public BestandKiezerOpstart() 
	{
		JFrame venster = new JFrame();
		venster.setSize(350,250); 
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Demonstratie bestandkiezer");
		venster.setLocation(100,100); // niet helemaal linksboven
		venster.add( new BestandKiezerPaneel(venster) );
		venster.setVisible(true);		
	}

	public static void main( String[ ] args)
	{
		new BestandKiezerOpstart();
	}
}