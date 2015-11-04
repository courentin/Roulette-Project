package logic.typeOfBets;

import logic.Number;

public class EvenOdd extends TypeOfBet {
	
	public static final int EVEN = 0;
	public static final int ODD  = 1;

	private int type;

	public EvenOdd() {
		super();
		this.coeficient = 1;
	}
	
	public void setType(int type) throws IllegalArgumentException {
		if(type != EVEN && type != ODD) throw new IllegalArgumentException();
		this.type = type;
	}

	public boolean isWinnerNumber(Number box) {
		int value = box.getValue();

		if(value == 0) return false;
		if(type == EVEN)
			return value%2 == 0;
		else
			return value%2 != 0;
	}

	@Override
	public String printInfo() {
		if(type==0)return "even";
		else if(type==1) return "odd";		
		return null;
	}
}