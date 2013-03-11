package Structures.Cards;

import Structures.Structure;
import Tokens.Resources;
import WonderBoards.WonderBoard;

public class Caravansery extends Structure {

	public static final int CaravanseryID = 57;
	
	public Caravansery()
	{
		super(new Resources(0, 0, 2, 0, 0, 0, 0, 0), CaravanseryID, "Caravansery", YELLOW_CARD, 2);
	}
	
	public boolean canBuildForFree(WonderBoard wb)
	{
		return wb.containsCard(Marketplace.MarketplaceID);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
