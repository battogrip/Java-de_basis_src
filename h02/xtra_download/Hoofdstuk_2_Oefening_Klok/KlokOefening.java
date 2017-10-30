package h02;
import javax.swing.JFrame;

/*
 * Dit programma vraagt van de gebruiker een tijdstip in uren
 * en minuten en tekent een analoge klok die het ingevulde
 * tijdstip aangeeft met een grote en kleine wijzer.
 * 
 * Het programma bestaat uit twee klassen
 * - deze klasse KlokOefening
 * - de klasse KlokOefeningPaneel
 * 
 * De klasse KlokOefeningPaneel is onvolledig; u moet
 * op aangegeven plaatsen een Java-statement invullen
 * 
 * Gemaakt door Andree Hollander in 2008
 * voor het boek Java, 'de basis' (isbn 978 90 430 1654 4)
 */

public class KlokOefening extends JFrame
{
	// maak een venster met een paneel als inhoud
	public KlokOefening() 
	{
		JFrame venster = new JFrame();
		// ruimte voor invullvakken, bedieningsknop en 
		// de getekende klok
		venster.setSize(400,500); 
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Klok met wijzers");
		venster.setLocation(100,100); // niet helemaal linksboven
		venster.add( new KlokOefeningPaneel() );
		venster.setVisible(true);		
	}

	public static void main( String[ ] args)
	{
		new KlokOefening();
	}
}
