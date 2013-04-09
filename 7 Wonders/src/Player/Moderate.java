package Player;

import java.util.ArrayList;
import java.util.Collections;

import Structures.Structure;


public class Moderate implements Strategy{
	//Follows a specific structure strategy while also blocking neighbors
	public void strategicPick(AIPlayer p, ArrayList<Structure> discarded, Player leftNeighbor, Player rightNeighbor){
		boolean did = false;
		ArrayList<Integer> selectionNumbers = p.cardSelectionNumbers(leftNeighbor, rightNeighbor, 1);
		
		for ( int i = 0; i < p.cards.size(); ++i )
		{	
			if (Collections.max(selectionNumbers) == 0)
				break;
			int result;
			p.chooseCard(selectionNumbers.indexOf(Collections.max(selectionNumbers)));
			result = p.canBuild(leftNeighbor, rightNeighbor);
			switch ( result )
			{
			case 0: 
				selectionNumbers.remove(Collections.max(selectionNumbers));
				continue;
			
			case 1: 
				p.buildStructure();
				did = true;
				break;
			case 2:
				did = true;
				p.buildStructure(leftNeighbor, rightNeighbor, 2);
				break;
			}
			if ( result != 0 ) break;
		}
		if ( !did )
		{
			ArrayList<Integer> blockNumbers = p.blockSelectionNumbers(leftNeighbor, rightNeighbor);
			if (!p.cards.isEmpty())
				p.chooseCard(blockNumbers.indexOf(Collections.max(blockNumbers)));
			
			else{
				System.out.println("*****Deck Empty!*****");
				return;
			}
			int result = p.canBuildStage(leftNeighbor, rightNeighbor);
			switch ( result )
			{
			case 0: break;
			
			case 1: 
				did = true;
				p.buildStage(leftNeighbor, rightNeighbor, 2);
				break;
				
			case 2:
				did = true;
				p.buildStage(leftNeighbor, rightNeighbor, 2);
				break;
			}
		}
		if ( !did )
		{
			p.discard(discarded);
		}
		//else if (!p.cards.isEmpty())
		//	p.cards.remove(p.chosenCardIndex);
		else
			System.out.println("*****Deck Empty!*****");	
	}
}
