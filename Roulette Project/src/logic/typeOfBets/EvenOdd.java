package logic.typeOfBets;

public class EvenOdd extends TypeOfBet {
	
	public static final int EVEN = 1;
	public static final int ODD  = 2;

	private int type;

	public EvenOdd(int type) throws IllegalArgumentException {
		if(type != EVEN && type != ODD) throw new IllegalArgumentException();
		this.type = type;
		this.coeficient = 1;
	}

	public boolean isWinnerNumber(int box) {
		if(type == EVEN)
			return box%2 == 0;
		else
			return box%2 != 0;
	}
}