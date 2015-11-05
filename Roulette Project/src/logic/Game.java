package logic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import logic.typeOfBets.Column;
import logic.typeOfBets.CornerBet;
import logic.typeOfBets.Dozen;
import logic.typeOfBets.EvenOdd;
import logic.typeOfBets.FailedPassed;
import logic.typeOfBets.RedBlack;
import logic.typeOfBets.StraightUp;
import logic.typeOfBets.TwoDozen;
import logic.typeOfBets.TypeOfBet;

public class Game {
	private Player player;
	private TypeOfBet[] betsAvailable;
	private ArrayList<Number> history;
	
	//ARRAY PLAYERS?
	//ArrayList<Player> players;
	//Make a bet(player,amount,typeOfBet)

	public Game(String playerName,Color color) {
		player=new Player(playerName,color);
		betsAvailable=new TypeOfBet[8];
		history = new ArrayList<>();
		chargeBets();
		
	}
	
	public Number turnTheWheel() {
		Number number = new Number();
		history.add(number);
		player.executeBets(number);
		return number;
	}

	/*
	public List<Number> getHotNumbers() {
		List<Number> ordered = history;
		for(Number number : history) {
			
		}
		
		Collections.sort(ordered);
		
		return ordered.subList(0, 3);
	}
	*/
	
	 /**
	  * 
	  * @return
	  * 0 -> RED
	  * 1 -> ZERO
	  * 2 -> BLACK
	  */
	 public List<Double> getRedBlackStatistics() {
		 List<Double> stat = new ArrayList<>();
		 stat.add(0.0);
		 stat.add(0.0);
		 stat.add(0.0);
		 for(Number number : history) {
			 if(number.getColor() == Color.RED) {
				 stat.set(0, 1+stat.get(0));
			 } else if(number.getColor() == Color.BLACK) {
				 stat.set(2, 1+stat.get(2));
			 } else {
				 stat.set(0, 1+stat.get(0));
			 }
		 }
		 int size = history.size();
		 stat.set(0, stat.get(0) / size);
		 stat.set(1, stat.get(1) / size);
		 stat.set(2, stat.get(2) / size);

		 return stat;
	 }

	 /**
	  * 
	  * @return
	  * 0 -> EVEN
	  * 1 -> ZERO
	  * 2 -> ODD
	  */
	 public List<Double> getEvenOddStatistics() {
		 List<Double> stat = new ArrayList<>();
		 stat.add(0.0);
		 stat.add(0.0);
		 stat.add(0.0);
		 for(Number number : history) {
			 if(number.getValue() == 0)
				 stat.set(0, 1+stat.get(0));
			 if(number.getValue()%2 == 0) {
				 stat.set(0, 1+stat.get(0));
			 } else {
				 stat.set(2, 1+stat.get(2));
			 }
		 }
		 int size = history.size();
		 stat.set(0, stat.get(0) / size);
		 stat.set(1, stat.get(1) / size);
		 stat.set(2, stat.get(2) / size);

		 return stat;
	 }

	private void chargeBets() {
		betsAvailable[0]=new Column();
		betsAvailable[1]=new CornerBet();
		betsAvailable[2]=new Dozen();
		betsAvailable[3]=new EvenOdd();
		betsAvailable[4]=new FailedPassed();
		betsAvailable[5]=new RedBlack();
		betsAvailable[6]=new StraightUp();
		betsAvailable[7]=new TwoDozen();
		
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
