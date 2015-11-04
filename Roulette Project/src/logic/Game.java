package logic;

import java.awt.Color;
import java.util.ArrayList;

public class Game {
	private Player player;
	//ARRAY PLAYERS?
	//ArrayList<Player> players;
	//Make a bet(player,amount,typeOfBet)

	public Game(String playerName,Color color) {
		player=new Player(playerName,color);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
}
