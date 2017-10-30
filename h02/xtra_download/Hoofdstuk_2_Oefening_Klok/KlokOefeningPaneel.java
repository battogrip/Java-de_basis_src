package h02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Deze klasse tekent een analoge klok met wijzers die het
 * tijdstip aangeven dat de gebruiker via twee invoervakken
 * instelt. Het berekenen van de plaats van wijzers is
 * tamelijk ingewikkeld; deze berekening is correct.
 * 
 * Vul op de aangeven plaatsen het gevraagde in om de
 * klasse compleet te maken.
 */

public class KlokOefeningPaneel extends JPanel implements ActionListener
{
	private JTextField urenVeld, minutenVeld; //invoer-velden
	private JButton tekenknop; // om hertekenen te forceren
	// constanten
	//===========================================================
	// vul hier de constante in die bij het tekenen nodig is
	//===========================================================
	 ; // grootte van de klokcirkel 
	
	 
	// maak paneel met invoervelden en tekenknop
	public KlokOefeningPaneel()
	{ 
		// invulveld voor de uren
		add(new JLabel("Geef de uren (0-23)"));
		urenVeld = new JTextField("13",3);  
		urenVeld.addActionListener(this);
		add(urenVeld);
		
		// invulveld voor de minuten
		add(new JLabel("Geef de minuten (0-59)"));
		minutenVeld = new JTextField("13",3);   
		minutenVeld.addActionListener(this);
		add(minutenVeld);
		
		// knop om de klok opnieuw te laten tekenen
		tekenknop = new JButton("Teken klok opnieuw");
		tekenknop.addActionListener(this);
		//===========================================================
		// vul hier de opdracht in die de tekenknop
		// toevoegt aan het paneel
		//===========================================================
		 ;
	}
	
	// teken de achtergrond van de klok en de wijzers daarop
	public void paintComponent(Graphics g)
	{
		super.paintComponent( g );
		int middenX = getWidth() / 2; // halverwege scherm horizontaal
		int middenY = getHeight() / 2; // halverwege scherm verticaal
		final int HALVEKLOK = KLOKGROOTTE / 2; // helft voor rekenwerk
		
		//===========================================================
		// vul hier de opdracht in die de kleur oranje instelt
		// voor de cirkel waarop de wijzers worden getekend
		//===========================================================
		 ;
		g.fillOval(middenX - HALVEKLOK, middenY - HALVEKLOK, 
				KLOKGROOTTE, KLOKGROOTTE); // omtrek van de klok
		// minutenwijzer
		g.setColor(Color.BLUE);
		int minuten = Integer.parseInt(minutenVeld.getText()) % 60;
		double hoek = 2 * Math.PI * minuten / 60.0;
		int lengteMinutenWijzer = HALVEKLOK;
		int minutenX = (int) (middenX + Math.round(lengteMinutenWijzer * Math.sin(hoek)));
		int minutenY = (int) (middenY - Math.round(lengteMinutenWijzer * Math.cos(hoek)));
		g.drawLine(middenX,middenY,minutenX,minutenY);
		// urenwijzer (een kwart kleiner dan de minutenwijzer)
		int lengteUrenWijzer = HALVEKLOK - HALVEKLOK / 4; 
		int uren = Integer.parseInt(urenVeld.getText()) % 12;
		hoek = 2 * Math.PI * (uren + minuten / 60.0) / 12;
		int urenX = (int) (middenX + Math.round(lengteUrenWijzer * Math.sin(hoek)));
		int urenY = (int) (middenY - Math.round(lengteUrenWijzer * Math.cos(hoek)));
		g.drawLine(middenX,middenY,urenX,urenY);
	}
	
	// geklikt op de knop
	public void actionPerformed(ActionEvent e)
	{
		//===========================================================
		// vul hier de opdracht in die de kleur oranje instelt
		// voor de cirkel waarop de wijzers worden getekend
		//===========================================================
		 ; // opnieuw tekenen
	}
}