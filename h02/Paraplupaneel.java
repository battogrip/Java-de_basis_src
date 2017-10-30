package h02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paraplupaneel extends JPanel implements ActionListener
{
	private JTextField kleurRVeld, kleurGVeld, kleurBVeld; //RGB-velden
	private JButton tekenknop; // om opnieuw tekenen te forceren
	private Color huidigeKleur; // om de kleur op te slaan
	// constanten
	private final int Y_BEGIN = 100; // verticale positie op het scherm 
	private final int BALEINEN_BREEDTE = 300; // breedte van het regenscherm 
	private final int BALEINEN_HOOGTE = BALEINEN_BREEDTE / 2; // hoogte van het regenscherm
	private final int PARAPLU_HOOGTE = 250; // van top tot handgreep
	private final int PUNTJE_BOVENOP_HOOGTE = 20; // stukje bovenop
	private final int DIAMETER_HANDGREEP = 50; // grootte van handgreep
	
	/* 
	 * maak paneel met drie invoervelden en tekenknop
	 */
	public Paraplupaneel()
	{ 
		tekenknop = new JButton("Teken paraplu");
		tekenknop.addActionListener(this);
		// donkere kleur als defaultwaarde
//		kleurRVeld = new JTextField("13",3);  
//		kleurGVeld = new JTextField("39",3);   
//		kleurBVeld = new JTextField("130",3);   
		kleurRVeld = new JTextField("13",3);  
		kleurRVeld.addActionListener(this);
		kleurGVeld = new JTextField("39",3);   
		kleurGVeld.addActionListener(this);
		kleurBVeld = new JTextField("130",3);   
		kleurBVeld.addActionListener(this);
		bepaalIngesteldeKleur(); // voor eerste keer tekenen
		// voeg onderdelen toe aan paneel
		add(new JLabel("Geef de waarden van R G en B  (0-255)"));
		add(kleurRVeld);
		add(kleurGVeld);
		add(kleurBVeld);
		add(tekenknop);
		double fahrenheit;
		int celsius = Integer.parseInt(kleurRVeld.getText());
		fahrenheit = 1.8 * celsius + 32;
		System.out.println(fahrenheit);
		kleurBVeld.setText(fahrenheit+"");
		celsius = (int) ((5/9.0) * (fahrenheit - 32));
		fahrenheit= celsius;
		//celsius = fahrenheit;
}
	
	/*
	 * bereken het huidige midden en teken de paraplu
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent( g );
		g.setColor(huidigeKleur);
		int midden = getWidth() / 2; // halverwege scherm
		g.drawLine(midden, Y_BEGIN, 
				midden, Y_BEGIN + PARAPLU_HOOGTE); // middenbuis
		g.drawLine(midden+1, Y_BEGIN, 
				midden+1, Y_BEGIN + PARAPLU_HOOGTE); // middenbuis
		g.drawArc(midden, Y_BEGIN + PARAPLU_HOOGTE - DIAMETER_HANDGREEP/2, 
				DIAMETER_HANDGREEP, DIAMETER_HANDGREEP,
				0,-180); // handgreep onderaan
//		g.drawArc(midden+1, Y_BEGIN + PARAPLU_HOOGTE - DIAMETER_HANDGREEP/2, 
//				DIAMETER_HANDGREEP-2, DIAMETER_HANDGREEP-1,
//				0,-180); // handgreep onderaan
		g.fillArc(midden - BALEINEN_BREEDTE/2, Y_BEGIN + PUNTJE_BOVENOP_HOOGTE,
				BALEINEN_BREEDTE, BALEINEN_HOOGTE,
				0,180); // baleinen
		g.fillArc(midden - BALEINEN_BREEDTE/2, Y_BEGIN + PUNTJE_BOVENOP_HOOGTE,
				BALEINEN_BREEDTE, BALEINEN_HOOGTE,
				0,180); // baleinen
	}
	
	/*
	 * haal de drie getallen uit de invulvakken en maak er een 
	 * nieuwe kleur mee (maximaal 255)
	 */
	public void bepaalIngesteldeKleur()
	{
		int kleurR = Integer.parseInt(kleurRVeld.getText());
		int kleurG = Integer.parseInt(kleurGVeld.getText());
		int kleurB = Integer.parseInt(kleurBVeld.getText());
		huidigeKleur = new Color(kleurR % 256, kleurG % 256,kleurB % 256);
	}

	// geklikt op de knop
	public void actionPerformed(ActionEvent e)
	{
		bepaalIngesteldeKleur(); // nieuwe kleur vastleggen
		repaint(); // opnieuw tekenen
	}
}