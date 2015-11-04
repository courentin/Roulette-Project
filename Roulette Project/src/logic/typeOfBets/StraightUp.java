package logic.typeOfBets;

import logic.Number;

public class StraightUp extends TypeOfBet {

	private int number;

	public StraightUp() {
		super();
		this.coeficient = 35;
	}
	
	public void setNumber(int number) throws IllegalArgumentException {
		if(number < 0 || number > 36) throw new IllegalArgumentException();
		this.number = number;
	}

	public boolean isWinnerNumber(Number box) {
		return box.getValue() == number;
	}
}
