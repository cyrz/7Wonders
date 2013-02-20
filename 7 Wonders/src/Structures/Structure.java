package Structures;

import Resources.Resources;

public class Structure {

	private static final int INVALID = 0x00;
	public static final int RED_CARD = 0x10;
	public static final int BLUE_CARD = 0x20;
	public static final int BROWN_CARD = 0x30;
	public static final int GREY_CARD = 0x40;
	public static final int YELLOW_CARD = 0x50;
	public static final int GREEN_CARD = 0x60;
	public static final int PURPLE_CARD = 0x70;
	
	protected Resources resourceCost;
	protected int ID;
	protected String Name;
	protected int Color;
	protected int Age;
	
	//Constructors
	public Structure()
	{
		resourceCost = new Resources();
		ID = 0;
		Name = "";
		Color = INVALID;
		Age = 0;
	}
	
	public Structure(Resources resourceCost, int id, String name, int color, int age)
	{
		this.resourceCost = resourceCost;
		ID = id;
		Name = name;
		Color = color;
		Age = age;
	}
	
	public Structure(Structure s)
	{
		resourceCost = s.resourceCost;
		ID = s.ID;
		Name = s.Name;
		Color = s.Color;
		Age = s.Age;
	}
	
	//getters
	public Resources GetResourceCost()
	{
		return resourceCost;
	}
	
	public int GetID()
	{
		return ID;
	}
	
	public String GetName()
	{
		return Name;
	}
	
	public int GetColor()
	{
		return Color;
	}
	
	public int GetAge()
	{
		return Age;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
