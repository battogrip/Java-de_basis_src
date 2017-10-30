package h04;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class VolgendeDag2Paneel  extends JPanel implements ActionListener
{
	private JTextField dagVeld;
	private JTextField maandVeld;
	private JTextField jaarVeld;
	private JButton berekenknop;
	private JTextField resultaatVeld;
	
	/* 
	 * maak paneel met invoervelden, berekenknop en een resultaatveld; 
	 * de invoervelden hebben een defaultwaarde die laat zien
	 * welke vorm van invoer van de gebruiker wordt verwacht
	 */
	public VolgendeDag2Paneel()
	{ 
		setLayout(new FlowLayout(FlowLayout.CENTER,0,0) );
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
		Kalendergegevens kalendervraagbaak = new Kalendergegevens();
		String resultaat = "De dag na " 
			+ dag + "-" + maand  + "-" + jaar + " is ";
		dag++;
		if ( dag > kalendervraagbaak.getAantalDagenInMaand(maand,jaar) )
		{	// nieuwe maand
			dag = 1;
			maand++;
			if (maand > 12)
			{	// nieuw jaar
				maand = 1;
				jaar++;
			}
		}
		return resultaat + + dag + "-" + maand  + "-" + jaar;
	}
		
	// haal gegevens op uit de velden en laat een resultaattekst
	// maken; toon die resultaattekst
	public void actionPerformed(ActionEvent e)
	{
		int invoerdag = Integer.parseInt(dagVeld.getText());
		int invoermaand = Integer.parseInt(maandVeld.getText());
		int invoerjaar = Integer.parseInt(jaarVeld.getText());
		String resultaat = maakResultaattekst(invoerdag,invoermaand,invoerjaar);
		resultaatVeld.setText(resultaat);
	}
}
