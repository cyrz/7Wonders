package Cards;

import Structures.*;
import Structures.Cards.Academy;
import Structures.Cards.Altar;
import Structures.Cards.Apothecary;
import Structures.Cards.Aqueduct;
import Structures.Cards.ArcheryRange;
import Structures.Cards.Arena;
import Structures.Cards.Arsenal;
import Structures.Cards.Barracks;
import Structures.Cards.Baths;
import Structures.Cards.Bazar;
import Structures.Cards.Brickyard;
import Structures.Cards.BuildersGuild;
import Structures.Cards.Caravansery;
import Structures.Cards.ChamberOfCommerce;
import Structures.Cards.Circus;
import Structures.Cards.ClayPit;
import Structures.Cards.ClayPool;
import Structures.Cards.Courthouse;
import Structures.Cards.CraftmensGuild;
import Structures.Cards.Dispensary;
import Structures.Cards.EastTradingPost;
import Structures.Cards.Excavation;
import Structures.Cards.ForestCave;
import Structures.Cards.Fortifications;
import Structures.Cards.Forum;
import Structures.Cards.Foundry;
import Structures.Cards.Gardens;
import Structures.Cards.Glassworks;
import Structures.Cards.Glassworks2;
import Structures.Cards.GuardTower;
import Structures.Cards.Haven;
import Structures.Cards.Laboratory;
import Structures.Cards.Library;
import Structures.Cards.Lighthouse;
import Structures.Cards.Lodge;
import Structures.Cards.Loom;
import Structures.Cards.Loom2;
import Structures.Cards.LumberYard;
import Structures.Cards.MagistratesGuild;
import Structures.Cards.Marketplace;
import Structures.Cards.Mine;
import Structures.Cards.MournersGuild;
import Structures.Cards.Observatory;
import Structures.Cards.OreVein;
import Structures.Cards.Palace;
import Structures.Cards.Pantheon;
import Structures.Cards.PawnShop;
import Structures.Cards.PhilosophersGuild;
import Structures.Cards.Press;
import Structures.Cards.Press2;
import Structures.Cards.Quarry;
import Structures.Cards.Sawmill;
import Structures.Cards.School;
import Structures.Cards.ScientistsGuild;
import Structures.Cards.Scriptorium;
import Structures.Cards.Senate;
import Structures.Cards.ShipownersGuild;
import Structures.Cards.SiegeWorkshop;
import Structures.Cards.SpiesGuild;
import Structures.Cards.Stables;
import Structures.Cards.Statue;
import Structures.Cards.Stockade;
import Structures.Cards.StonePit;
import Structures.Cards.StrategistsGuild;
import Structures.Cards.Study;
import Structures.Cards.Tavern;
import Structures.Cards.Temple;
import Structures.Cards.Theater;
import Structures.Cards.TimberYard;
import Structures.Cards.TownHall;
import Structures.Cards.TradersGuild;
import Structures.Cards.TrainingGround;
import Structures.Cards.TreeFarm;
import Structures.Cards.University;
import Structures.Cards.Vineyard;
import Structures.Cards.Walls;
import Structures.Cards.WestTradingPost;
import Structures.Cards.WorkersGuild;
import Structures.Cards.Workshop;
import WonderBoards.*;
import Player.Player;
import java.util.ArrayList;
import java.util.Collections;

public class CardHandler {

	public CardHandler()
	{
	}
	
	//This creates a deck with all the proper cards for the current age and the number of players in the match
	public static ArrayList<Structure> FilterCards(int numPlayers, int age)
	{
		ArrayList<Structure> deck = new ArrayList<Structure>();
		
		if ( age == 1 )
		{
			deck.add(new Stockade());
			deck.add(new Barracks());
			deck.add(new GuardTower());
			deck.add(new Altar());
			deck.add(new Theater());
			deck.add(new Baths());
			deck.add(new ClayPit());
			deck.add(new LumberYard());
			deck.add(new StonePit());
			deck.add(new TimberYard());
			deck.add(new OreVein());
			deck.add(new ClayPool());
			deck.add(new Press());
			deck.add(new Glassworks());
			deck.add(new Loom());
			deck.add(new WestTradingPost());
			deck.add(new Marketplace());
			deck.add(new EastTradingPost());
			deck.add(new Apothecary());
			deck.add(new Workshop());
			deck.add(new Scriptorium());
			if ( numPlayers >= 4 )
			{
				deck.add(new GuardTower());
				deck.add(new PawnShop());
				deck.add(new OreVein());
				deck.add(new Excavation());
				deck.add(new LumberYard());
				deck.add(new Tavern());
				deck.add(new Scriptorium());
			}
			if ( numPlayers >= 5 )
			{
				deck.add(new Barracks());
				deck.add(new Altar());
				deck.add(new ClayPit());
				deck.add(new StonePit());
				deck.add(new ForestCave());
				deck.add(new Tavern());
				deck.add(new Apothecary());
			}
			if ( numPlayers >= 6 )
			{
				deck.add(new Theater());
				deck.add(new TreeFarm());
				deck.add(new Mine());
				deck.add(new Loom());
				deck.add(new Press());
				deck.add(new Glassworks());
				deck.add(new Marketplace());
			}
			if ( numPlayers == 7 )
			{
				deck.add(new Stockade());
				deck.add(new Baths());
				deck.add(new PawnShop());
				deck.add(new WestTradingPost());
				deck.add(new EastTradingPost());
				deck.add(new Tavern());
				deck.add(new Workshop());
			}
		}
		else if ( age == 2 )
		{
			deck.add(new Walls());
			deck.add(new ArcheryRange());
			deck.add(new Stables());
			deck.add(new Statue());
			deck.add(new Courthouse());
			deck.add(new Aqueduct());
			deck.add(new Temple());
			deck.add(new Foundry());
			deck.add(new Brickyard());
			deck.add(new Sawmill());
			deck.add(new Quarry());
			deck.add(new Press2());
			deck.add(new Glassworks2());
			deck.add(new Loom2());
			deck.add(new Caravansery());
			deck.add(new Forum());
			deck.add(new Vineyard());
			deck.add(new Dispensary());
			deck.add(new Laboratory());
			deck.add(new Library());
			deck.add(new School());
			if ( numPlayers >= 4 )
			{
				deck.add(new TrainingGround());
				deck.add(new Quarry());
				deck.add(new Foundry());
				deck.add(new Sawmill());
				deck.add(new Brickyard());
				deck.add(new Bazar());
				deck.add(new Dispensary());
			}
			if ( numPlayers >= 5 )
			{
				deck.add(new Stables());
				deck.add(new Courthouse());
				deck.add(new Press2());
				deck.add(new Glassworks2());
				deck.add(new Loom2());
				deck.add(new Caravansery());
				deck.add(new Laboratory());
			}
			if ( numPlayers >= 6 )
			{
				deck.add(new TrainingGround());
				deck.add(new ArcheryRange());
				deck.add(new Temple());
				deck.add(new Forum());
				deck.add(new Vineyard());
				deck.add(new Caravansery());
				deck.add(new Library());
			}
			if ( numPlayers == 7 )
			{
				deck.add(new TrainingGround());
				deck.add(new Walls());
				deck.add(new Aqueduct());
				deck.add(new Statue());
				deck.add(new Bazar());
				deck.add(new Forum());
				deck.add(new School());
			}
		}
		else if ( age == 3 )
		{
			deck.add(new Fortifications());
			deck.add(new SiegeWorkshop());
			deck.add(new Arsenal());
			deck.add(new TownHall());
			deck.add(new Pantheon());
			deck.add(new Senate());
			deck.add(new Gardens());
			deck.add(new Palace());
			deck.add(new Haven());
			deck.add(new Arena());
			deck.add(new Lighthouse());
			deck.add(new Academy());
			deck.add(new University());
			deck.add(new Lodge());
			deck.add(new Observatory());
			deck.add(new Study());
			
			//Special handling for guild cards
			ArrayList<Structure> guilds = new ArrayList<Structure>();
			guilds.add(new CraftmensGuild());
			guilds.add(new MournersGuild());
			guilds.add(new BuildersGuild());
			guilds.add(new MagistratesGuild());
			guilds.add(new PhilosophersGuild());
			guilds.add(new WorkersGuild());
			guilds.add(new ShipownersGuild());
			guilds.add(new TradersGuild());
			guilds.add(new StrategistsGuild());
			guilds.add(new SpiesGuild());
			guilds.add(new ScientistsGuild());
			Collections.shuffle(guilds);
			for ( int i = 0; i < numPlayers + 2; ++i )
			{
				deck.add(guilds.get(i));
			}
			
			if ( numPlayers >= 4 )
			{
				deck.add(new Circus());
				deck.add(new Arsenal());
				deck.add(new Gardens());
				deck.add(new Haven());
				deck.add(new ChamberOfCommerce());
				deck.add(new University());
			}
			if ( numPlayers >= 5 )
			{
				deck.add(new SiegeWorkshop());
				deck.add(new Circus());
				deck.add(new TownHall());
				deck.add(new Senate());
				deck.add(new Arena());
				deck.add(new Study());
			}
			if ( numPlayers >= 6 )
			{
				deck.add(new Circus());
				deck.add(new TownHall());
				deck.add(new Pantheon());
				deck.add(new Lighthouse());
				deck.add(new ChamberOfCommerce());
				deck.add(new Lodge());
			}
			if ( numPlayers == 7 )
			{
				deck.add(new Fortifications());
				deck.add(new Arsenal());
				deck.add(new Palace());
				deck.add(new Arena());
				deck.add(new Academy());
				deck.add(new Observatory());
			}
		}
		
		Collections.shuffle(deck);
		
		return deck;
	}
	
	//This assigns a hand of cards to each player from the proper deck corresponding to the age
	public static void DistributeCards(ArrayList<Player> players, int age)
	{
		ArrayList<Structure> deck = FilterCards(players.size(), age);
		int index = 0;
		for ( Structure s: deck )
		{
			players.get(index).AssignCard(s);
			++index;
			if ( index == players.size() )
				index = 0;
		}
	}
	
	//This handles the assignment of random wonderboards to every player
	public static void DistributeRandomWonderBoards(ArrayList<Player> players, int side)
	{
		ArrayList<WonderBoard> boards = new ArrayList<WonderBoard>();
		boards.add(new TheColossusOfRhodes(side));
		boards.add(new TheHangingGardensOfBabylon(side));
		boards.add(new TheLighthouseOfAlexandria(side));
		boards.add(new TheMausoleumOfHalicarnassus(side));
		boards.add(new TheStatueOfZeusInOlympia(side));
		boards.add(new TheTempleOfArtemisInEphesus(side));
		boards.add(new ThePyramidsOfGiza(side));
		
		Collections.shuffle(boards);
		int index = 0;
		
		for ( Player p: players )
		{
			p.AssignWonderBoard(boards.get(index));
			++index;
		}
	}
	
	//the set of cards of each player is assigned to the neighbor on the left or on the right depending on the age
	public static void PassCardsToNeighbours(ArrayList<Player> players, int age)
	{
		ArrayList<Structure> hold = new ArrayList<Structure>();
		//cards are passed to the right in age 2
		if ( age == 2 )
		{
			hold.addAll(players.get(players.size()-1).GetCards());
			for ( int i = players.size()-1; i > 0; --i )
			{
				players.get(i).AssignCards(players.get(i-1).GetCards());
			}
			players.get(0).AssignCards(hold);
		}
		else //cards are passed to the left in ages 1 and 3
		{
			hold.addAll(players.get(0).GetCards());
			for ( int i = 0; i < players.size()-1; ++i )
			{
				players.get(i).AssignCards(players.get(i+1).GetCards());
			}
			players.get(players.size()-1).AssignCards(hold);
		}	
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		DistributeRandomWonderBoards(players, 1);
		DistributeCards(players, 2);
		for ( Player p : players )
		{
			System.out.println("\n" + p.GetWonderBoard().GetBoardName());
			for ( Structure s: p.GetCards() )
			{
				System.out.println(s.GetName());
			}
		}
		
		PassCardsToNeighbours(players, 2);
		
		for ( Player p : players )
		{
			System.out.println("\n" + p.GetWonderBoard().GetBoardName());
			for ( Structure s: p.GetCards() )
			{
				System.out.println(s.GetName());
			}
		}
		
	}

}
