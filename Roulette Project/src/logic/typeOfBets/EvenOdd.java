package logic.typeOfBets;

import logic.Number;

public class EvenOdd extends TypeOfBet {
	
	public static final int EVEN = 1;
	public static final int ODD  = 2;

	private int type;

	public EvenOdd(int type) throws IllegalArgumentException {
		if(type != EVEN && type != ODD) throw new IllegalArgumentException();
		this.type = type;
		this.coeficient = 1;
	}

	public EvenOdd() {
		// TODO Auto-generated constructor stub
	}

	public boolean isWinnerNumber(Number box) {
		int value = box.getValue();

		if(value == 0) return false;
		if(type == EVEN)
			return value%2 == 0;
		else
			return value%2 != 0;
	}
}