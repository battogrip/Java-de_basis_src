package h09;

import javax.swing.*;

public class Zuigers extends JFrame
{
	// maak een venster en stel enkele eigenschappen ervan in;
	// geef het venster een enkele panelen als inhoud
	public Zuigers() 
	{
		JFrame venster = new JFrame();
		venster.setSize(760,400); // ruimte voor 4 zuigers
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Bewegende zuigers");
		venster.setLocation(100,100); // niet helemaal linksboven
		venster.setLayout(null);
		// plaats 4 zuigers in het venster
		final int PANEELBREEDTE = 182; // twee pixels tussenruimte
		final int BOVENMARGE = 20; // 
		for (int tel=0; tel <= 3; tel++  )
		{
			Zuiger zuiger = new Zuiger(60,300);
			zuiger.setBounds(tel * PANEELBREEDTE, BOVENMARGE, 180,400);
			venster.add( zuiger );
		}
		
		venster.setVisible(true);		
	}

	public static void main( String[ ] args)
	{
		new Zuigers();
	}
}