package Tokens;

public class ScientificSymbols {

	private int gears, compass, tablets;
	
	public ScientificSymbols()
	{
		gears = 0;
		compass = 0;
		tablets = 0;
	}
	
	//this constructor should not be used other than for testing
	public ScientificSymbols(int g, int t, int c)
	{
		gears = g;
		compass = c;
		tablets = t;
	}
	
	public int getGears()
	{
		return gears;
	}
	
	public int getCompass()
	{
		return compass;
	}
	
	public int getTablets()
	{
		return tablets;
	}
	
	public int getTotalSymbols()
	{
		return (gears + compass + tablets);
	}
	
	public int victoryPointsValue()
	{
		int min;
		if ( gears < compass ) min = Math.min(gears, tablets);
		else min = Math.min(compass, tablets);

		if ( min != 0 )
			return ((int)Math.pow(gears, 2) + (int)Math.pow(compass, 2) + (int)Math.pow(tablets,  2) + 7*min);
		return ((int)Math.pow(gears, 2) + (int)Math.pow(compass, 2) + (int)Math.pow(tablets,  2));
	}
	
	public void addGears(int amount)
	{
		gears += amount;
	}
	
	public void addCompass(int amount)
	{
		compass += amount;
	}
	
	public void addTablets(int amount)
	{
		tablets += amount;
	}

	public void addScientifcSymbols(ScientificSymbols symbs)
	{
		compass += symbs.getCompass();
		gears += symbs.getGears();
		tablets += symbs.getTablets();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScientificSymbols sym = new ScientificSymbols(3, 2, 4);
		System.out.println(sym.victoryPointsValue());
	}

}
