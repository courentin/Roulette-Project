package logic;

import logic.typeOfBets.TypeOfBet;

public class Bet {
	private int amount;
	private TypeOfBet typeOfBet;
	private boolean isWinner;
	private double moneyExpected;

	public Bet(int amount, TypeOfBet typeOfBet) {
		super();
		this.amount = amount;
		this.typeOfBet = typeOfBet;
	}

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public TypeOfBet getTypeOfBet() {
		return typeOfBet;
	}
	public void setTypeOfBet(TypeOfBet typeOfBet) {
		this.typeOfBet = typeOfBet;
	}
	public boolean isWinner() {
		return isWinner;
	}
	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}
	public double getMoneyExpected() {
		return moneyExpected;
	}
	public void setMoneyExpected(double moneyExpected) {
		this.moneyExpected = moneyExpected;
	}
	
	
	

}
