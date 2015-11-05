package logic.typeOfBets;

import logic.Number;

public class Dozen extends TypeOfBet {

	private int betDozen;
	
	public Dozen() {
		this.coeficient = 2;
	}
	
	public void setDozen(int dozen) throws IllegalArgumentException {
		if(betDozen < 0 || betDozen > 2) throw new IllegalArgumentException();
		this.betDozen = dozen;
	}
	
	public boolean isWinnerNumber(Number box) {

		int value = box.getValue();
		switch(betDozen) {
			case 0:
				return value >= 1 && value <=12;
			case 1:
				return value >= 13 && value <=24;
			case 2:
				return value >= 25 && value <=36;
			default:
				return false;
		}
	}
	
	public String printInfo() {
		return String.valueOf(betDozen);
	}
}
