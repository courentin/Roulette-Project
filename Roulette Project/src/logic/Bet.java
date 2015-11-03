package logic;

public class Bet {
	private int amount;
	private TypeOfBet typeOfBet;
	private boolean isWinner;
	private double moneyExpected;
	public Bet(int amount, TypeOfBet typeOfBet, boolean isWinner,
			double moneyExpected) {
		super();
		this.amount = amount;
		this.typeOfBet = typeOfBet;
		this.isWinner = isWinner;
		this.moneyExpected = moneyExpected;
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
