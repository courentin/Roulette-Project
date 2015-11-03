package logic.typeOfBets;

public class EvenOdd extends TypeOfBet {
	
	private boolean even;

	public EvenOdd(boolean type) {
		even = type;
	}

	public boolean isWinnerNumber(int box) {
		if(even)
			return box%2 == 0;
		else
			return box%2 != 0;
	}
}