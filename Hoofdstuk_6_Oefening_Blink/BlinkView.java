package h06;

import java.awt.*; // voor de graphics
import javax.swing.JPanel;

/**
 * Paneel waarop de rechthoeken worden getekend in een van twee 
 * kleuren. De rechthoeken zijn genummerd van 0 tot en met 8
 * .-----------.------------.-----------.
 * |     0     |     1      |     2     |
 * |-----------|------------|-----------|
 * |     3     |     4      |     5     |
 * |-----------|------------|-----------|
 * |     6     |     7      |     8     |
 * '-----------'------------'-----------'
 * 
 * @author andree hollander
 * @version 1.0 - 20080815
 */
public class BlinkView extends JPanel
{
	BlinkModel spelStatus;
	final int AANTALVLAKKEN = 9; // aantal delen van het speelveld

	/**
	 * Ontvangt de status van het spel.
	 * 
	 * @param spelStatus
	 *            de stand van de vlakken en het aantal klikken
	 * @see BlinkModel
	 */
	public BlinkView(BlinkModel spelStatus)
	{
		this.spelStatus = spelStatus;
	}

	/**
	 * Geeft het aantal pixels van het derde deel van de breedte van het scherm
	 * 
	 * @return breedte van elk deelvlak
	 */
	public int getDerdeDeelX()
	{
		return getWidth() / 3;
	}

	/**
	 * Geeft het aantal pixels van het derde deel van de hoogte van het scherm
	 * 
	 * @return hoogte van elk deelvlak
	 */
	public int getDerdeDeelY()
	{
		return getHeight() / 3;
	}

	/**
	 * Tekent de negen rechthoeken in een van de twee kleuren. De breedte van
	 * elk deelvlak is een derde deel van de paneelbreedte; de hoogte van elk
	 * deelvlak is een derde deel van de paneelhoogte. De x-cošrdinaat van de
	 * linkerbovenhoek van een deelvlak is 0, 1 keer de breedte van een deel of
	 * 2 keer de breedte van een deel. De y-cošrdinaat van de linkerbovenhoek
	 * van een deelvlak is 0, 1 keer de hoogte van een deel of 2 keer de hoogte
	 * van een deel. De index loopt van 0 tot en met 8. Uit de index kunnen de
	 * x-cošrdinaat en de y-cošrdinaat worden berekend. Bepaal de rest van de
	 * deling index / 3 en je krijgt steeds opnieuw 0, 1, 2 en weer opnieuw 0,
	 * 1, 2. De x-cošrdinaat wordt steeds opnieuw 0 keer de breedte van een
	 * deelvlak, 1 keer de breedte van een deelvlak en 2 keer de breedte van een
	 * deelvlak. Deel de index door 3 (integerdeling) en je krijgt 0, 0, 0, 1,
	 * 1, 1, 2, 2, 2. Vermenigvuldig die getallen met de hoogte van een deelvlak
	 * en je hebt de y-cošrdinaat.
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		int breedteDeel = getDerdeDeelX();
		int hoogteDeel = getDerdeDeelY();
		Color aan = new Color(200, 60, 60); // rood
		Color uit = new Color(60, 120, 120); // groen
		for (int index = 0; index < AANTALVLAKKEN; index++)
		{
			if (spelStatus.getStatus(index))
			{
				g.setColor(aan);
			} else
			{
				g.setColor(uit);
			}
			int xLoc = ((index) % 3) * breedteDeel;
			int yLoc = ((index) / 3) * hoogteDeel;
			g.fillRect(xLoc, yLoc, breedteDeel, hoogteDeel);
		}
	}
}
