package logic;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import logic.typeOfBets.StraightUp;
import logic.typeOfBets.TypeOfBet;

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
		bets = new ArrayList<Bet>();
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
	
	
	public DefaultTableModel getBetsTable() {
		String[] columnNames = {"Bet value","Type of bet","Expected to win"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		
		for(Bet bet : bets) {
			Object[] data = { bet.getAmount(), bet.getTypeOfBet().printInfo(), bet.getMoneyExpected()-bet.getAmount() };
			tableModel.addRow(data);
		}
		

		return tableModel;
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

	public void addMoney(double money) {
		this.money += money;
	}

	public void subMoney(double money) {
		this.money -= money;
	}
	public boolean doABet(int amount, TypeOfBet typeOfBet) { 
		if(amount<=money){ 
			Bet bet = new Bet(amount, typeOfBet); 
			bets.add(bet);
			
			money=money-amount; 
			return true; 
		} 
		else{ 
			return false;
		} 

	} 
	public void executeBets(Number number) {

		for(Bet bet : bets) {
			if(!(bet.getTypeOfBet() instanceof StraightUp) && number.getValue() == 0 && bet.getAmount() >= 10) {
				money += bet.getAmount()/2;
			} else if(bet.getTypeOfBet().isWinnerNumber(number)) {
				money += bet.getMoneyExpected();
			}
		}
		bets.clear();
	}
}

