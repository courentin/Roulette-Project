package logic.typeOfBets;

abstract public class TypeOfBet {
	private String name;
	protected double coeficient;
	private int numbers;

	abstract public boolean isWinnerNumber(int box); 
	/**
	 * Calculate the gain resulting from the bet and adds the amount wagered
	 * @param amountBeted 
	 * @return the total amount
	 */
	public double calcEarnings(int amountBeted){
		return coeficient*amountBeted;
		
		
	}
	
}
