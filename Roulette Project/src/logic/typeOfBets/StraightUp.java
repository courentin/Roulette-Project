package logic.typeOfBets;

import logic.Number;

public class StraightUp extends TypeOfBet {

	private int number;

	public StraightUp(int number) throws IllegalArgumentException {
		if(number < 0 || number > 36) throw new IllegalArgumentException();
		this.number = number;
		this.coeficient = 35;
	}

	public boolean isWinnerNumber(Number box) {
		return box.getValue() == number;
	}
}
