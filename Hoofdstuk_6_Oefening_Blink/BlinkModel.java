package h06;

/**
 * Bewaart de gegevens van het spel dat bezig is.
 * Een boolean-array met voor elk deelvlak de status
 * plus een klikteller die telt hoe vaak de speler klikt.	
 */
public class BlinkModel
{
	boolean[ ] status = new boolean[9];
	int aantalKlikken;
	
	/**
	 * Zet alle velden uit en de klikteller op nul
	 */
	public void beginSpel()
	{
		for (int index=0; index<status.length; index++)
		{
			status[index] = false;
		}
		aantalKlikken = 0;
	}
	
	/**
	 * Verhoogt het aantal klikken als de speler heeft geklikt.
	 */
	public void geklikt()
	{
		aantalKlikken++;
	}
	
	/**
	 * Geeft het aantal klikken.
	 */
	public int getAantalKlikken()
	{
		return aantalKlikken;
	}
	
	/**
	 * Bepaalt of de puzzel is opgelost.
	 * 
	 * @return true als de puzzel is opgelost, anders false
	 */
	public boolean opgelost()
	{
		for (int index=0; index<status.length; index++)
		{
			if ( ! status[index] )
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Levert de status van een deelvlak in de puzzel.
	 * 
	 * @param index van het deelvlak waarover informatie wordt gevraagd
	 * @return is het deelvlak true of false
	 */
	public boolean getStatus(int index)
	{
		return status[index];
	}
	
	/**
	 * Wisselt de stand van een deelvlak in de puzzel.
	 * 
	 * @param index een van de deelvlakken 0 tot en met 8
	 */
	public void flipStatus(int index)
	{
		status[index] = ! status[index];
	}
}
