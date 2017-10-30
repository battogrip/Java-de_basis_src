package h02;

import javax.swing.*;
import java.awt.event.*;

/*
 * Invoer: aantal benodigde etiketten
 *         aantal etiketten per blad
 * Melden: aantal benodigde bladen
 *         aantal etiketten dat ongebruikt blijft
 */

public class Etikettenpaneel extends JPanel implements ActionListener
{
	private JTextField aantalEtikettenVeld;
	private JTextField etikettenPerBladVeld;
	private JButton berekenknop;
	private JTextArea resultaatveld;
	
	/* 
	 * maak paneel met invoervelden en berekenknop
	 */
	public Etikettenpaneel()
	{ 
		berekenknop = new JButton("Bereken resultaat");
		berekenknop.addActionListener(this);
		// tekstvakken met willekeurige defaultwaarden
		// groot genoeg voor een getal van 5 cijfers
		aantalEtikettenVeld = new JTextField("100",5);   
		etikettenPerBladVeld = new JTextField("24",5); 
		// 6 regels van 25 tekens
		resultaatveld = new JTextArea(6,25); 
		// voeg de elementen toe aan het paneel
		add(new JLabel("Aantal etiketten dat u wilt afdrukken"));
		add(aantalEtikettenVeld);
		add(new JLabel("Aantal etiketten op een blad"));
		add(etikettenPerBladVeld);
		add(berekenknop);
		add(resultaatveld);
	}
	
	/*
	 * bereken de resultaten en meld de uitkomsten
	 */
	public void toonResultaat(int aantalEtiketten, int etikettenPerBlad)
	{
		int vellenNodig = ((aantalEtiketten - 1) / etikettenPerBlad) + 1;
		int over = vellenNodig * etikettenPerBlad - aantalEtiketten;
		String resultaat = "Aantal vellen nodig: " + vellenNodig + "\n"
		+ "Aantal etiketten onbedrukt: " + over;
		resultaatveld.setText(resultaat);	
	}
	
	/*
	 * haal gegevens op uit de velden en roep de methode
	 * toonResultaat aan
	 */
	public void actionPerformed(ActionEvent e)
	{
		int aantalEtiketten = Integer.parseInt(aantalEtikettenVeld.getText());
		int etikettenPerBlad = Integer.parseInt(etikettenPerBladVeld.getText());
		toonResultaat(aantalEtiketten,etikettenPerBlad);
	}
}