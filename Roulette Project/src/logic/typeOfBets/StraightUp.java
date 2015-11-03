package logic.typeOfBets;

public class StraightUp {

	private int number;

	public StraightUp(int number) throws IllegalArgumentException {
		if(number < 0 || number > 36) throw new IllegalArgumentException();
		this.number = number;
	}

	public boolean isWinnerNumber(int box) {
		return box == number;
	}
}
