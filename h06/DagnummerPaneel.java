package h06;

import java.awt.event.*;
import javax.swing.*;

public class DagnummerPaneel extends JPanel implements ActionListener
{
	private JButton startKnop;
	private JTextField dagVeld, maandVeld, JaarVeld;
	private JTextField resultaatVeld;
	private KalenderPlus vraagbaak;
	
	// maak paneel met invoervelden, knop en uitvoerveld
	public DagnummerPaneel() // constructor
	{ 
		add( new JLabel("Dag") );
		dagVeld = new JTextField("13",2);
		add(dagVeld);
		
		add( new JLabel("Maand") );
		maandVeld = new JTextField("10",2);
		add(maandVeld);
		
		add( new JLabel("Jaar") );
		JaarVeld = new JTextField("2009",4);
		add(JaarVeld);
		
		startKnop = new JButton("Bereken dagnummer");
		startKnop.addActionListener(this);
		add(startKnop);
		
		resultaatVeld = new JTextField(35);
		add(resultaatVeld);
		
		vraagbaak = new KalenderPlus();
	}
		
	// haal invoer op en laat uitvoer berekenen
	public void actionPerformed(ActionEvent e)
	{
		int dag = Integer.parseInt( dagVeld.getText() );
		int maand = Integer.parseInt( maandVeld.getText() );
		int jaar = Integer.parseInt( JaarVeld.getText() );
		int dagnummer = vraagbaak.dagnummerInJaar(dag,maand,jaar);
		resultaatVeld.setText("Dag " + dag + " van maand " + maand +
			" heeft dagnummer " + dagnummer + " in jaar " + jaar);
	}
}