package h01;

import javax.swing.*;
import java.awt.event.*;

/*
 * Deze klasse maakt een paneel met twee tekstvakken en een
 * knop en reageert op de knop door veld2 gelijk maken aan veld1
 */

public class Kopieerpaneel extends JPanel implements ActionListener
{
	private JTextField veld1;
	private JTextField veld2;
	private JButton actieknop;
	
	/* 
	 * maak paneel met twee tekstvelden en een knop ertussen
	 */
	public Kopieerpaneel()
	{
		actieknop = new JButton(">Kopieer>");
		actieknop.addActionListener(this);
		veld1 = new JTextField(13); // ruimte voor 1 woord
		veld1.setToolTipText("Vul in dit vak een woord in");
		veld2 = new JTextField(13); // zelfde grootte als veld1
		add(veld1);
		add(actieknop);
		add(veld2);
	}
	
	/*
	 * veld2 krijgt de inhoud van veld1
	 */
	public void actionPerformed(ActionEvent e)
	{
		veld2.setText( veld1.getText() );
	}
}
