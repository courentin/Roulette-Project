package logic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import logic.typeOfBets.Column;
import logic.typeOfBets.CornerBet;
import logic.typeOfBets.EvenOdd;
import logic.typeOfBets.RedBlack;
import logic.typeOfBets.StraightUp;
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
		betsAvailable[1]=new CornerBet();
		betsAvailable[2]=new EvenOdd();
		betsAvailable[3]=new RedBlack();
		betsAvailable[4]=new StraightUp();		
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
