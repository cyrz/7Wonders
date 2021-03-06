package Structures.Cards;

import Structures.Structure;
import Structures.Effects.TradingPerks;
import Tokens.Resources;

public class Marketplace extends Structure {

	public static final int MarketplaceID = 55;
	
	public Marketplace()
	{
		super(new Resources(), MarketplaceID, "Marketplace", YELLOW_CARD, 1);
		effects.add(new TradingPerks(3, 1));
	}



}
