package h06;

import java.awt.event.*; // voor muisacties
import java.awt.*; // voor achtergrondkleur
import javax.swing.*; // voor JPanel en JLabel

public class MouseEventPaneel extends JPanel implements MouseListener
{
	JLabel gebeurtenisverslag; // tekst onder het klikvlak
	
	// maak leeg paneel met gele achtergrond dat muisactiviteit hoort
	public MouseEventPaneel(JLabel uitleg) // constructor
	{ 
		gebeurtenisverslag = uitleg;
		setBackground(Color.YELLOW);
		this.addMouseListener(this);
		gebeurtenisverslag.setText(" Klik ergens in het gele gebied");
	}
		
	// twee niet gebruikte methoden
	public void mouseEntered (MouseEvent m) {}
	public void mouseExited (MouseEvent m) {}
	
	// drie gebruikte methoden
	public void mousePressed (MouseEvent m)
	{
		gebeurtenisverslag.setText( " Muis ingedrukt op " +
				m.getX() + "," + m.getY()	);
	}
	
	public void mouseReleased (MouseEvent m)
	{
		gebeurtenisverslag.setText( " Muis omhoog op " +
				m.getX() + "," + m.getY()	);
	}
	
	public void mouseClicked (MouseEvent m) 
	{
		gebeurtenisverslag.setText( m.getClickCount() + " keer geklikt op " +
				m.getX() + "," + m.getY()	);
	}
}