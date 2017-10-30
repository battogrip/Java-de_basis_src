package h06;

import h04.*;

/*	
 * KalenderPlus versie 1.0, 2008, Andree Hollander
 * 
 * Bepaalt het dagnummer in het jaar (1 - 366)
 * van de opgegeven dag, maand en jaar.
 * Deze methode gaat ervan uit dat de aangeleverde
 * gegevens correct zijn en controleert daar niet op
 */

public class KalenderPlus extends Kalendergegevens
{
	public int dagnummerInJaar(int dag, int maand, int jaar)
	{
		// begin met het aantal dagen van de huidige maand
		int dagnummer = dag; 
		
		// tel daarbij op het aantal dagen van elke
		// volle maand die verstreken is
		for (int m=1; m < maand; m++)
		{
			dagnummer = dagnummer + getAantalDagenInMaand(m, jaar);
		}
		return dagnummer;
	}
}
