package h07;

import java.awt.*; // voor Color en Graphicss
import java.awt.event.*; // voor ActionListener en ActionEvent
import java.util.Random;
import javax.swing.*; // voor JPanel, JFrame en JButton

public class Balzwerm extends JFrame implements ActionListener
{
	private Random generator = new Random(); // maakt toevalsgetallen
	private JPanel balgebied = new JPanel(); // gebied voor de ballen
	
	public Balzwerm() 
	{
		JFrame venster = new JFrame();
		// venster.setLayout(new BorderLayout() ); // default
		venster.setSize(600,300); // rechthoekige ruimte 
		venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		venster.setTitle("Ballen");
		venster.setLocation(100,100); // niet helemaal linksboven
	
		balgebied.setLayout(null);
		balgebied.setBackground(Color.PINK);
		venster.add( balgebied, BorderLayout.CENTER );
		
		JPanel knopPaneel = new JPanel();
		knopPaneel.setLayout( new FlowLayout() );
		JButton nieuweBalKnop = new JButton("Bal toevoegen");
		nieuweBalKnop.addActionListener(this);
		knopPaneel.add(nieuweBalKnop);
		venster.add(knopPaneel, BorderLayout.SOUTH );
		
		venster.setVisible(true);		
	}

	public void actionPerformed( ActionEvent e)
	{
		// bal van willekeurige grootte (50-200)
		// op willekeurige plaats toevoegen
		int diameter = generator.nextInt(151) + 50;
		Bal bal = new Bal(diameter);
		int xLoc = generator.nextInt(balgebied.getWidth() - diameter);
		int yLoc = generator.nextInt(balgebied.getHeight() - diameter); 
		bal.setBounds(xLoc,yLoc,diameter+1,diameter+1);
		balgebied.add(bal);
		balgebied.repaint();
	}

	public static void main( String[ ] args)
	{
		new Balzwerm();
	}
}
