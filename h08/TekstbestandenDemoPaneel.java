package h08;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

// maak een paneel met twee knoppen en een tekstvak
public class TekstbestandenDemoPaneel extends JPanel implements ActionListener
{
	private JButton openKnop, saveKnop;
	private JTextArea tekstvak;
	private JFrame venster;
	private FileDialog dialoogvenster;

	public TekstbestandenDemoPaneel(JFrame parentVenster) // constructor
	{
		venster = parentVenster; // voor gebruik bij FileDialog
		
		// maak een knop waarmee de gebruiker een bestand kan openen
		openKnop = new JButton("Openen...");
		openKnop.addActionListener(this);
		add(openKnop);
		
		// maak een knop waarmee de gebruiker een bestand kan opslaan
		saveKnop = new JButton("Bewaar als...");
		saveKnop.addActionListener(this);
		add(saveKnop);

		// maak een tekstvak met schuifbalk
		tekstvak = new JTextArea(10,45);
		tekstvak.setLineWrap(true);
		tekstvak.setWrapStyleWord(true);
		JScrollPane schuifgebied = new JScrollPane(tekstvak);
		add(schuifgebied);
	} // einde constructor

	// lees de inhoud van een bestand en plaats die in het tekstvak
	public void bestandlezen()
	{
		dialoogvenster =
			new FileDialog( venster, "Open een bestand", FileDialog.LOAD );
		dialoogvenster.setVisible( true );
		String bestandsnaam = dialoogvenster.getFile();
		if (bestandsnaam != null)
		{
			String padEnBestand = dialoogvenster.getDirectory() + bestandsnaam;
			tekstvak.setText( "" ); // maak tekstgebied leeg
			String regel; // eenheid van inlezen
			try
			{
				BufferedReader invoer = 
					new BufferedReader( new FileReader(padEnBestand) );
				regel = invoer.readLine();
				while (regel != null)
				{
					tekstvak.append(regel + "\n");
					regel = invoer.readLine();
				}
				invoer.close();
			}
			catch (IOException ex)
			{
				JOptionPane.showMessageDialog(
						null, 
						"Er is een fout opgetreden bij het lezen.", 
						"Inlezen van het bestand is mislukt", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	// maakt een bestand met de inhoud van het tekstvak
	public void bestandschrijven()
	{
		dialoogvenster =
			new FileDialog( venster, "Bewaar een bestand", FileDialog.SAVE);
		dialoogvenster.setVisible( true );
		String bestandsnaam = dialoogvenster.getFile();
		if (bestandsnaam != null)
		{
			String padEnBestand = dialoogvenster.getDirectory() + bestandsnaam;
			try
			{
				PrintWriter uitvoer = 
					new PrintWriter( new FileWriter(padEnBestand) );
				uitvoer.print( tekstvak.getText() );
				uitvoer.close();
			}
			catch (IOException ex)
			{
				JOptionPane.showMessageDialog(
						null, 
						"Er is een fout opgetreden bij het schrijven.", 
						"Bewaren van bestand is mislukt", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{   
		if (e.getSource() == openKnop)
		{
			bestandlezen();
		}
		else
		{
			bestandschrijven();
		}			
	}
}