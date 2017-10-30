package h03;

import java.awt.event.*;
import javax.swing.*;

public class VolgendeDagPaneel  extends JPanel implements ActionListener
{
	private JTextField dagVeld, maandVeld, jaarVeld;
	private JButton berekenknop;
	private JTextField resultaatVeld;
	
	/* 
	 * maak paneel met invoervelden, berekenknop en een resultaatveld; 
	 * de invoervelden hebben een defaultwaarde die laat zien
	 * welke vorm van invoer van de gebruiker wordt verwacht
	 */
	public VolgendeDagPaneel()
	{ 
		add(new JLabel("Dag"));
		dagVeld = new JTextField("14",2);   
		add(dagVeld);
		
		add(new JLabel("Maand"));
		maandVeld = new JTextField("9",2); 
		add(maandVeld);
		
		add(new JLabel("Jaar"));
		jaarVeld = new JTextField("2009",4); 
		add(jaarVeld);
		
		berekenknop = new JButton("Volgende dag");
		berekenknop.addActionListener(this);
		add(berekenknop);

		resultaatVeld = new JTextField(23); // geen defaulttekst
		add(resultaatVeld);
	}
	
	// bereken de volgende dag en maak een tekst
	public String maakResultaattekst(int dag, int maand, int jaar)
	{
		String resultaat = "De dag na " 
			+ dag + "-" + maand  + "-" + jaar + " is ";
		dag++;
		if ( dag > aantalDagenInMaand(maand, jaar) )
		{	// nieuwe maand
			dag = 1;
			maand++;
			if (maand > 12)
			{	// nieuw jaar
				maand = 1;
				jaar++;
			}
		}
		return resultaat + dag + "-" + maand  + "-" + jaar;
	}
	
	// geef het aantal dagen van de meegegeven maand
	// in het meegegeven jaar
	public int aantalDagenInMaand(int maand, int jaar)
	{
		final int APRIL=4, JUNI=6, SEPTEMBER=9, NOVEMBER=11;
		final int FEBRUARI=2;
		int aantalDagen = 31; // geldt voor de meeste maanden
		if (maand == APRIL || maand == JUNI 
				|| maand == SEPTEMBER || maand == NOVEMBER)
		{	
			aantalDagen = 30;
		}
		else if (maand == FEBRUARI)
		{	
			aantalDagen = 28;
			if (isSchrikkeljaar(jaar))
			{
				aantalDagen = 29;
			}
		}
		return aantalDagen;
	}
	
	// bepaal of het meegegeven jaartal een schrikkeljaar is
	public boolean isSchrikkeljaar(int jaartal)
	{
	      return ((jaartal % 4 == 0) && (jaartal % 100 != 0)) 
	      || (jaartal % 400 == 0);
	}
	
	// haal gegevens op uit de velden en laat een resultaattekst
	// maken; toon die resultaattekst
	public void actionPerformed(ActionEvent e)
	{
		int invoerdag = Integer.parseInt(dagVeld.getText());
		int invoermaand = Integer.parseInt(maandVeld.getText());
		int invoerjaar = Integer.parseInt(jaarVeld.getText());
		String resultaat = 
			maakResultaattekst(invoerdag,invoermaand,invoerjaar);
		resultaatVeld.setText(resultaat);
	}
}