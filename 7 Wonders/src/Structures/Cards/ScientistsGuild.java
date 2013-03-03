package Structures.Cards;

import Resources.Resources;
import Structures.Structure;

public class ScientistsGuild extends Structure {

	public static final int ScientistsGuildID = 0x7B;
	
	public ScientistsGuild()
	{
		super(new Resources(2, 0, 2, 0, 0, 0, 1, 0), ScientistsGuildID, "Scientists Guild", PURPLE_CARD, 3);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}