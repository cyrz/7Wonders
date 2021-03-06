package Structures.Cards;

import Structures.Structure;
import Structures.Effects.CardVictoryPointBonus;
import Tokens.Resources;

public class PhilosophersGuild extends Structure {

	public static final int PhilosophersGuildID = 21;
	
	public PhilosophersGuild()
	{
		super(new Resources(0, 0, 0, 3, 0, 1, 1, 0), PhilosophersGuildID, "Philosophers Guild", PURPLE_CARD, 3);
		effects.add(new CardVictoryPointBonus(1, true, GREEN_CARD));
	}



}
