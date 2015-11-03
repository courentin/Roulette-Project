package logic.typeOfBets;

abstract public class TypeOfBet {
	private String name;
	private double coeficient;
	private int numbers;

	//abstract public boolean isWinnerNumber(int box); it cant be here because we need differents parameters
	
	/**
	 * Calculate the gain resulting from the bet and adds the amount wagered
	 * @param amountBeted 
	 * @return the total amount
	 */
	public double calcEarnings(int amountBeted){
		return coeficient*amountBeted;
		
		
	}
	
}
