package client;

import java.util.ArrayList;


import Resources.Match;
import Resources.Packet.*;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;

@SuppressWarnings("unused")
public class NetworkListener extends Listener{

	private final boolean VERBOSE = true;
	
	Client c;
	MClient mclient;
	ArrayList<Match> list;
	ArrayList<Object> fredsShittyList = new ArrayList<Object>();
	int matchChunksReceived = 0;
	int startMatchChunks = 0;
	
	public NetworkListener(MClient m){
		mclient = m;
	}
	
	public void init(Client c){
		this.c = c;
	}
	
	public void connected(Connection arg0) {
		System.out.println("[CLIENT] Connected");
		//c.sendTCP(new Packet0LoginRequest());
		//super.connected(arg0);
	}
	
	@Override
	public void disconnected(Connection arg0) {
		System.out.println("[CLIENT] Disconnected");
		System.exit(0);
		//super.disconnected(arg0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void received(Connection c, Object o) {
		if(VERBOSE) System.out.println("[CLIENT] RECEIVED PACKET");
		if(o instanceof Packet1LoginAnswer){
			if(!((Packet1LoginAnswer)o).getAccepted()){
				c.close();
				
			}
			mclient.setMatchList((ArrayList<Long>)((Packet1LoginAnswer)o).getObject());
			mclient.setID(((Packet1LoginAnswer)o).getIDValue());
			mclient.createUser();
		}
		//check if client has been able to join game
		//if yes, join lobby
		//if no stay at match list screen

		if(o instanceof Packet3Connection){
			System.out.println("Packet3Connection Received");
			if(((Packet3Connection)o).getAccepted()){
				//join match lobby
				mclient.setMID(((Packet3Connection)o).getIDValue());
				
				mclient.getLink().launchChatFrame();
				System.out.println("[CLIENT] JOINED GAME SUCCESSFULLY");
			}
			else{
				mclient.getLink().failedMatchLobby();
				System.out.println("GAME IS FULL");
		
			}
		}
		if(o instanceof Packet4Object){			
			mclient.getLink().updateLobby((ArrayList<Long>)((Packet4Object)o).getObject());
		}
		if(o instanceof Packet6ChatMsg){
			System.out.println("[CLIENT] Received msg packet");
			mclient.getLink().getChat().addChat(((Packet6ChatMsg)o).getMsg());
			//mclient.updateChat(((Packet6ChatMsg)o).getMsg());
		}

		if(o instanceof Packet7MatchFunction){
			System.out.println("[CLIENT] Received Match 2 Chunk");
			
//			++matchChunksReceived;
//			++startMatchChunks;
//			fredsShittyList.add(((Packet7MatchFunction)o).getObject());
//			if(matchChunksReceived==8){
//				//receive shitty list
//				mclient.getUser().receive(fredsShittyList);
//				
//				fredsShittyList.clear();
//				matchChunksReceived=0;
//				
//			}
			
		}
		if(o instanceof Packet8ClientResponse){
			
		}
		if(o instanceof Packet9StartMatch){			
			System.out.println("[CLIENT] Received start match request");
			
			//if delay in network and chunks received later than start request, ensures
			//chunks are received before start
			//mclient.startMatch();

			//eliminate countdown causing so many god damn errors.
			//mclient.getLink().getChat().run();
		}
		if(o instanceof Packet14HostCreateMatch){
			mclient.setMID(((Packet14HostCreateMatch)o).getMID());
			mclient.setHost(true);
			if(((Packet14HostCreateMatch)o).getnPlayer()>0){
				mclient.getLink().launchChatFrame();
			}
			
		}
		if( o instanceof Packet15MatchDisconnect){
			System.out.println("[CLIENT]  Graceful Disconnect");
			mclient.getLink().killMainFrame();
		}
		if(o instanceof Packet17PlayerObject){
			System.out.println("[CLIENT] Received Player Object");
//			for(Object p : (ArrayList)((Packet17PlayerObject)o).getPlayer())
//				System.out.println(p);
		}
		if(o instanceof Packet18DList){
			System.out.println("[CLIENT] Received Discarded List");
		}
	}

}
