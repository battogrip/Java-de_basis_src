package h04;

import java.awt.event.*;
import javax.swing.*;

/*
 * Twee knoppen op een paneel om een AutoBal te bedienen
 */

public class AutoBalBediening extends JPanel implements ActionListener
{
	private JButton wisselRichting; // voor het verwisselen van richting 
	private JButton verticaal; // voor verticale verplaatsing
	AutoBal bal;

	public AutoBalBediening(AutoBal bal) // constructor
	{
		this.bal = bal;
		
		wisselRichting = new JButton("Wissel van richting");
		wisselRichting.addActionListener(this);
		add(wisselRichting);
		
		verticaal = new JButton("Verplaats verticaal");
		verticaal.addActionListener(this);
		add(verticaal);
	}
		
	// bij een klik de juiste actie ondernemen
	public void actionPerformed(ActionEvent e)
	{
		if ( e.getSource() == wisselRichting)
		{
			bal.setRichtingEnSnelheid( - bal.getRichtingEnSnelheid() );
		}
		else // knop Verplaats verticaal
		{
			bal.setVerPlaats( bal.getVerPlaats() + bal.getRichtingEnSnelheid() );
		}
	}
}

