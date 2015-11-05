package logic;

import logic.typeOfBets.TypeOfBet;

public class Bet {
	private int amount;
	private TypeOfBet typeOfBet;

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

	public double getMoneyExpected() {
		return amount + typeOfBet.calcEarnings(amount);
	}

	@Override
	public String toString() {
		return amount+"\u20ac "+typeOfBet+"-"+typeOfBet.printInfo()+"-Expected to win:"+typeOfBet.calcEarnings(amount)+"\n";
	}
	
}
