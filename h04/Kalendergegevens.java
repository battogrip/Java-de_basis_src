package h04;

public class Kalendergegevens
{
	// geef het aantal dagen van de meegegeven maand
	// in het meegegeven jaar
	public int getAantalDagenInMaand(int maand, int jaar)
	{
		final int APRIL=4, JUNI=6, SEPTEMBER=9, NOVEMBER=11;
		final int FEBRUARI=2;
		int aantalDagen = 31; // geldt voor de meeste maanden
		if (maand == APRIL || maand == JUNI 
				|| maand == SEPTEMBER || maand == NOVEMBER)
		{	
			aantalDagen = 30;
		}
		else if (maand == FEBRUARI)
		{	
			aantalDagen = 28;
			if (isSchrikkeljaar(jaar))
			{
				aantalDagen = 29;
			}
		}
		return aantalDagen;
	}
	
	// bepaal of het meegegeven jaartal een schrikkeljaar is
	public boolean isSchrikkeljaar(int jaartal)
	{
	      return ((jaartal % 4 == 0) && (jaartal % 100 != 0)) 
	      || (jaartal % 400 == 0);
	}
}
