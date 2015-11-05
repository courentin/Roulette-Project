package logic.typeOfBets;

import logic.Number;

public class TwoDozen extends TypeOfBet {

	private int firstDozen;
	
	public TwoDozen() {
		this.coeficient = 0.5;
	}

	public void setDozens(int first) throws IllegalArgumentException {
		if(first < 0 || first > 1) throw new IllegalArgumentException();
		this.firstDozen = first;
	}
	
	
	public boolean isWinnerNumber(Number box) {

		int value = box.getValue();
		switch(firstDozen) {
			case 0:
				return value >= 1 && value <= 24;
			case 1:
				return value >= 23 && value <= 36;
			default:
				return false;
		}
	}
	
	public String printInfo() {
		return String.valueOf(firstDozen) + " " + String.valueOf(firstDozen+1);
	}
}
