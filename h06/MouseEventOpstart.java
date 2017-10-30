package h06;

import java.awt.BorderLayout;
import javax.swing.*;

/*
 * Programma dat laat zien waar de muis wordt ingedrukt
 * waar hij omhoog gaat (als dat een ander plaats is)
 * en hoe vaak er wordt geklikt.
 */
public class MouseEventOpstart extends JFrame
{
	public MouseEventOpstart() 
	{
		JFrame venster = new JFrame();
		// venster.setLayout(new BorderLayout() ); // default
		venster.setSize(400,400); // vierkante ruimte 
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Demo Mouse Events");
		venster.setLocation(100,100); // niet helemaal linksboven
		
		JLabel uitleg = new JLabel();
		venster.add(uitleg, BorderLayout.SOUTH );
		
		venster.add( new MouseEventPaneel(uitleg) );
		
		venster.setVisible(true);		
	}

	public static void main( String[ ] args)
	{
		new MouseEventOpstart();
	}
}
