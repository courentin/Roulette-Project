package logic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import logic.typeOfBets.Column;
import logic.typeOfBets.TypeOfBet;

public class Game {
	private Player player;
	private TypeOfBet[] betsAvailable;
	
	
	//ARRAY PLAYERS?
	//ArrayList<Player> players;
	//Make a bet(player,amount,typeOfBet)

	public Game(String playerName,Color color) {
		player=new Player(playerName,color);
		betsAvailable=new TypeOfBet[5];
		chargeBets();
		
	}

	private void chargeBets() {
		betsAvailable[0]=new Column();
//		betsAvailable[1]=("CornerBet");
//		betsAvailable[2]=("EvenOdd");
//		betsAvailable[3]=("RedBlack");
//		betsAvailable[4]=("StraightUp");		
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public TypeOfBet[] getBetsAvailable() {
		return betsAvailable;
	}

	public void setBetsAvailable(TypeOfBet[] betsAvailable) {
		this.betsAvailable = betsAvailable;
	}
	
	
	
}
