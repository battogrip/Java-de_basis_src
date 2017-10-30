package h05;

import java.awt.event.*;
import javax.swing.*;

public class KleurenstrookBediening extends JPanel implements ActionListener
{
	private JButton tekenKnop;
	KleurenstrookTeken tekenpaneel;
	
	// maak paneel met tekenknop
	public KleurenstrookBediening(KleurenstrookTeken tekenpaneel)
	{ 
		this.tekenpaneel = tekenpaneel;
		tekenKnop = new JButton("Teken kleurvlakken");
		tekenKnop.addActionListener(this);
		add(tekenKnop);
	}
	
	// teken opnieuw bij klik op de knop
	public void actionPerformed(ActionEvent e)
	{
		tekenpaneel.repaint();
	}
}
