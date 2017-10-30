package h06;

import javax.swing.JFrame;

/*
 * Testprogrammaatje voor de klasse KalenderPLus
 * dat een dagnummer in het jaar bepaalt
 */
public class DagnummerOpstart extends JFrame
{
	// maak een venster en stel enkele eigenschappen ervan in;
	// geef het venster een paneel als inhoud
	public DagnummerOpstart() 
	{
		JFrame venster = new JFrame();
		venster.setSize(600,200); // langwerpig
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Test voor berekening van het dagnummer");
		venster.setLocation(100,100); // niet helemaal linksboven
		venster.add( new DagnummerPaneel() );
		venster.setVisible(true);		
	}

	public static void main( String[ ] args )
	{
		new DagnummerOpstart();
	}
}