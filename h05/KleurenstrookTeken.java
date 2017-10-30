package h05;

import java.awt.*; // voor de graphics
import javax.swing.*; // voor het paneel
import java.util.Random;


public class KleurenstrookTeken extends JPanel
{
	Random generator = new Random();
	
	// kies drie kleuren en teken rechthoeken
	// afwisselend in deze kleuren 
	public void paintComponent(Graphics g)
	{
		super.paintComponent( g );
		
		final int BREEDTE_RECHTHOEK = 30; // smalle rechthoek
		int rechts = getWidth(); // breedte van scherm
		int beneden = getHeight(); // hoogte van scherm
		
		final int KLEURGRENS = 85; // een derde van 255
		Color[ ] kleuren = new Color[3];
		kleuren[0] = new Color(generator.nextInt(KLEURGRENS),
				generator.nextInt(KLEURGRENS),
				generator.nextInt(KLEURGRENS));
		kleuren[1] = new Color(generator.nextInt(KLEURGRENS) + KLEURGRENS,
				generator.nextInt(KLEURGRENS) + KLEURGRENS,
				generator.nextInt(KLEURGRENS) + KLEURGRENS);
		kleuren[2] = new Color(generator.nextInt(KLEURGRENS) + 2 * KLEURGRENS,
				generator.nextInt(KLEURGRENS) + 2 * KLEURGRENS,
				generator.nextInt(KLEURGRENS) + 2 *KLEURGRENS);
		
		int kleurnummer = 0; // beginnen met nul
		for (int xLoc=0; xLoc <= rechts; xLoc+=BREEDTE_RECHTHOEK) // hele scherm
		{
			g.setColor(kleuren[kleurnummer]);
			g.fillRect(xLoc, 0, BREEDTE_RECHTHOEK, beneden);
			kleurnummer = (kleurnummer + 1) % 3; // volgende kleur
		}
	}
}
