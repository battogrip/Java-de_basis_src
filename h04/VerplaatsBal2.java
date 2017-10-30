package h04;

import javax.swing.*; // voor JFrame en JButton
import java.awt.*; // voor de BorderLayout
import java.awt.event.*; // voor knopafhandeling

/*
 * Dit programma tekent een bal met een vaste grootte, 
 * bijvoorbeeld 100 pixels. De bal staat bij het begin van het 
 * programma ongeveer in het midden van het scherm. 
 * Er zijn twee knoppen (naarLinks en naarRechts genoemd) 
 * waarmee de gebruiker de bal naar links en naar rechts kan 
 * bewegen. Met een vast aantal pixels per klik, bijvoorbeeld 
 * een verplaatsing van 13 pixels. De bal beweegt alleen naar 
 * links en rechts, niet naar boven of beneden.
 */

public class VerplaatsBal2 extends JFrame implements ActionListener
{
	private JButton naarLinks, naarRechts; 
	VerplaatsBal2Paneel bal;

	// maak een venster met een paneel en knoppen als inhoud
	public VerplaatsBal2() 
	{
		JFrame venster = new JFrame();
		// venster.setLayout(new BorderLayout() ); // default
		venster.setSize(700,400); // veel ruimte voor de bal
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Verplaatsbare bal, versie 2");
		venster.setLocation(100,100); // niet helemaal linksboven
		bal = new VerplaatsBal2Paneel();
		venster.add( bal, BorderLayout.CENTER );
		naarLinks = new JButton("<");
		naarLinks.addActionListener(this);
		venster.add(naarLinks, BorderLayout.WEST );
		naarRechts = new JButton(">");
		naarRechts.addActionListener(this);
		venster.add(naarRechts, BorderLayout.EAST );
		venster.setVisible(true);		
	}

	// bij een klik de horizontale plaats aanpassen en opnieuw tekenen
	public void actionPerformed(ActionEvent e)
	{
		final int VERPLAATSING = 13; // opschuiving per klik
		if ( e.getSource() == naarLinks)
		{
			bal.setHorPlaats( bal.getHorPlaats() - VERPLAATSING );
		}
		else // naar rechts
		{
			bal.setHorPlaats( bal.getHorPlaats() + VERPLAATSING );
		}
		bal.repaint();
	}

	public static void main( String[ ] args)
	{
		new VerplaatsBal2();
	}
}