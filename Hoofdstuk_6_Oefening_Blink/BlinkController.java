package h06;

import java.awt.event.*;
import javax.swing.*;

/**
 * Besturing van het puzzelspel Blink. De muisklikken van de speler
 * worden verwerkt. Het aantal klikken wordt geteld. Het deelvlak 
 * van de klik veroorzaakt ook verandering van een aantal andere
 * deelvlakken. Na een klik wordt gecontroleerd of het einddoel
 * is bereikt.
 * 
 * @author andree hollander
 * @version 1.0 20080815
 * @see BlinkModel
 * @see BlinkView
 */
public class BlinkController implements MouseListener
{
	BlinkModel spelStatus;
	BlinkView weergave;
	
	/**
	 * Koppelt een MouseListener aan het paneel van de weergave.
	 * 
	 * @param spelStatus de stand van de vlakken en het aantal klikken
	 * @param weergave het tekenen op het scherm
	 */
	public BlinkController(BlinkModel spelStatus, BlinkView weergave)
	{
		this.spelStatus = spelStatus;
		this.weergave = weergave;
		weergave.addMouseListener(this);
	}
	
	public void wijzigSatus(int deelnummer)
	{
		int[ ] flip = {130,4210,125,4630,41357,4258,367,4678,578};
		int delen = flip[deelnummer]; 
		// de varianele delen bevat nu een getal uit de array flip
		// System.out.print(delen + "   "); // debug

		while (delen > 0)
		{
			spelStatus.flipStatus(delen % 10);
			// System.out.print(delen % 10); debug
			delen = delen / 10;
		}
		// System.out.println(""); // debug
	}
	
	public void controleeerOpGelukt()
	{
		if (spelStatus.opgelost() )
		{
			// geef felicitatie
			JOptionPane.showMessageDialog(
					null, 
					"Met " + spelStatus.getAantalKlikken() + 
					" keer klikken heb je de puzzel opgelost.", 
					"Gefeliciteerd!", 
					JOptionPane.WARNING_MESSAGE);
			spelStatus.beginSpel();
			weergave.repaint();
		}
	}
	
	/*
	 * Vul op deze plaats de juiste regels in om 
	 * een werkend programma te krijgen
	 */
	{
		spelStatus.geklikt(); // verhoog klikkenteller
		int x = m.getX(); // x-cošrdinaat van klik
		int y = m.getY(); // y-cošrdinaat van klik
		// bepaal in welk deel de klik heeft plaatsgevonden
		// het speelveld is horizontaal en verticaal verdeeld
		// in drie gedeelten
		int deelX = x / weergave.getDerdeDeelX();
		int deelY = y / weergave.getDerdeDeelY();
		int deelnummer = (deelY) * 3 + deelX; // deel 0 tot 8
		wijzigSatus(deelnummer);
		weergave.repaint();
		controleeerOpGelukt();
	}
}
