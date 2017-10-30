package h08;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// maak een paneel met twee knoppen en een tekstvak
public class BestandKiezerPaneel extends JPanel implements ActionListener
{
	private JButton openKnop, saveKnop;
	private JTextArea tekstvak;
	private JFrame venster;

	public BestandKiezerPaneel(JFrame parentVenster) // constructor
	{
		venster = parentVenster;
		
		// maak een knop waarmee de gebruiker een bestand kan openen
		openKnop = new JButton("Openen...");
		openKnop.addActionListener(this);
		add(openKnop);
		
		// maak een knop waarmee de gebruiker een bestand kan opslaan
		saveKnop = new JButton("Bewaar als...");
		saveKnop.addActionListener(this);
		add(saveKnop);

		// maak een tekstvak
		tekstvak = new JTextArea(8,26);
		tekstvak.setLineWrap(true);
		tekstvak.setWrapStyleWord(true);
		add(tekstvak);
	} // einde constructor

	public void actionPerformed(ActionEvent e)
	{   
		FileDialog dialoogvenster;
		if (e.getSource() == openKnop)
		{
			dialoogvenster =
				new FileDialog( venster, "Open een bestand", FileDialog.LOAD );
		}
		else
		{
			dialoogvenster =
				new FileDialog( venster, "Bewaar een bestand", FileDialog.SAVE);
		}			
		dialoogvenster.setVisible( true );
		tekstvak.setText("Pad: " + dialoogvenster.getDirectory() 
				+ "\n\nBestandsnaam: " + dialoogvenster.getFile() );
	}
}

