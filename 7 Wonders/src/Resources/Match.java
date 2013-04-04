package Resources;

import java.util.ArrayList;

//import server.MServer;



import Controls.CommandMessage;
import Controls.Match2;
import Player.User;
import Resources.Packet.Packet10EndMatch;
import Resources.Packet.Packet7MatchFunction;
import Resources.Packet.Packet8ClientResponse;
import Resources.Packet.Packet9StartMatch;


import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;

public class Match {
	
	ArrayList<Connection> connected;
	//ArrayList<Long> userIDList;
	ArrayList<User> userList;
    private long match_id;
    private static long counter = 1000;
    private int MAX_PLAYER_COUNT = 7 ;
    private int connection_count;
    private int receivedEvents = 0;
    ArrayList<CommandMessage> cmdMsgList;
    private boolean inProgress;
    

    ///////////////////////////////////////////
    //    handle ai creation
    
    
    /////FIX///////////////////////////////////
    //freds new class
    private Match2 controller;
    
    public Match(int h,int ai){
    	//userIDList = new ArrayList<Long>();
    	userList = new ArrayList<User>();
    	connected = new ArrayList<Connection>();
		match_id = ++counter;
		cmdMsgList = new ArrayList<CommandMessage>();
		inProgress = false;
		MAX_PLAYER_COUNT = h+ai;		
    }
    public int getMaxPlayerCount() {return MAX_PLAYER_COUNT;}
    public boolean get_inProgress(){return inProgress;}
	public ArrayList<Connection> getConnections(){return connected;}	
	public void addConnection(Connection c, Object o){
		userList.add((User)o);
		//userIDList.add(o);
		connected.add(c);
		update();
	}
	public void removeConnection(Connection c, Object o) {
		userList.remove((User)o);
		connected.remove(c);
		update();
	}
	public void removeConnectionOnly(Connection c){
		connected.remove(c);
		update();
	}
	public long getMatch_ID(){return match_id;}
	public int getConnectionCount(){return connection_count;}
	public void update(){
		connection_count = connected.size();
		System.out.println(connection_count);
		if(connection_count==MAX_PLAYER_COUNT){
			System.out.println("Starting Game!");
			startMatch();
		}
	}

	public void generateAI(long ID){
		//new AI(ID)
		//add something to sending something to AI
		
	}

	public boolean contains(Connection c){
		if(connected.contains(c))
			return true;
		return false;
	}
	
	//public void activateController
	//getters and setters for controller
	
//	public void setServerMatchCommunication(Server s){server = s;}
	public void sendMatchInfo(Object o){
		Packet7MatchFunction gamePacket = new Packet7MatchFunction(); 
		gamePacket.setObject(o);
		
		for(Connection c: connected){
			c.sendTCP(gamePacket);
		}
	}
	
	//control.play 
	
	public void receiveEvent(CommandMessage m, long cID){
		cmdMsgList.add(m);
		receivedEvents++;
		if(receivedEvents==connection_count){
			/***************************************/			

			/***************************************/
			//hand off info to game controller
			//waiting
			//okay game returned
			
			
			sendMatchInfo(controller.dispatch(cmdMsgList));
			
			
		}
	}
	
	public void handOff(Packet8ClientResponse receivedPacket){		
		receiveEvent((CommandMessage)receivedPacket.getObject(), receivedPacket.getCID());
	}	
	public void startMatch(){
		controller = new Match2(userList);
		inProgress = true;
		sendStartMatchRequest();
	}
	
	public void endMatch(){
		sendEndMatchRequest();
	}
	public void sendStartMatchRequest(){
		Packet9StartMatch start = new Packet9StartMatch();
		start.setObject(new Match2(userList));
		
			for(Connection c: connected){
				c.sendTCP(start);
			}
	
	}
	
	public void sendEndMatchRequest(){
		Packet10EndMatch end = new Packet10EndMatch();
		for(Connection c: connected){
			c.sendTCP(end);
		}
	}
}
