package logic.typeOfBets;

import java.util.HashSet;
import logic.Number;

public class CornerBet extends TypeOfBet {
	private HashSet<Integer> betBoxes;

	public CornerBet() {
		super();
		this.coeficient = 8;
	}
	
	public void setBetBoxes(HashSet<Integer> betBoxes) {
		this.betBoxes = betBoxes;
	}

	@Override
	public boolean isWinnerNumber(Number box) {
		return betBoxes.contains(box.getValue());	
	}

	@Override
	public String printInfo() {
		
		return betBoxes.toString();
	}
}
