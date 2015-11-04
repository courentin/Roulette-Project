package logic.typeOfBets;

import logic.Number;

abstract public class TypeOfBet {
	private String name;
	protected double coeficient;

	public TypeOfBet() {
		this.name = this.getClass().getName();
	}

	abstract public boolean isWinnerNumber(Number box); 
	/**
	 * Calculate the gain resulting from the bet and adds the amount wagered
	 * @param amountBeted 
	 * @return the total amount
	 */
	public double calcEarnings(int amountBeted){
		return coeficient*amountBeted;
	}
	
	public String toString() {
		return this.name;
	}
}
