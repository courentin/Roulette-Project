package logic;

abstract public class TypeOfBet {
	private String name;
	private double coeficient;
	private int numbers;

	abstract public boolean isWinnerNumber(int box);
}
