package logic;

import java.awt.Color;
import java.util.ArrayList;

public class Player {
	public static final int INITAL_MONEY = 500;
	private String name;
	private Color color;
	ArrayList<Bet> bets;
	private double money;
	
	
	public Player(String name, Color color) {
		super();
		this.name = name;
		this.color = color;
		bets=new ArrayList<Bet>();
		this.money = INITAL_MONEY;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public ArrayList<Bet> getBets() {
		return bets;
	}


	public void setBets(ArrayList<Bet> bets) {
		this.bets = bets;
	}


	public double getMoney() {
		return money;
	}


	public void setMoney(double money) {
		this.money = money;
	}
	
	
	
	
}

