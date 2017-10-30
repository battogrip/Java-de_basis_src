package h05;

import javax.swing.*; // voor JFrame
import java.awt.*; // voor de BorderLayout

/*
 * Programma Kleurenstrook; Andree Hollander, 2008
 * 
 * Het programma moet rechthoeken tekenen op een vensterpaneel. 
 * Een bedieningsknop laat het tekenen opnieuw gebeuren. 
 * De kleuren moeten elke keer anders zijn, willekeurig. De eerste 
 * kleur moet donker zijn, de derde licht en de tweede ertussenin.
 */

public class KleurenstrookOpstart extends JFrame
{
	// maak een venster en stel enkele eigenschappen ervan in;
	// in het centrum komt het tekenpaneel
	// daaronder het bedieningspaneel
	public KleurenstrookOpstart() 
	{
		JFrame venster = new JFrame();
		venster.setSize(700,300); // langwerpig
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Afwisselende kleuren");
		venster.setLocation(100,100); // niet helemaal linksboven
		
		KleurenstrookTeken tekenpaneel = new KleurenstrookTeken();
		venster.add( tekenpaneel, BorderLayout.CENTER );
		
		KleurenstrookBediening knoppaneel = 
			new KleurenstrookBediening(tekenpaneel);
		venster.add( knoppaneel, BorderLayout.SOUTH );

		venster.setVisible(true);		
	}

	public static void main( String[ ] args )
	{
		new KleurenstrookOpstart();
	}
}