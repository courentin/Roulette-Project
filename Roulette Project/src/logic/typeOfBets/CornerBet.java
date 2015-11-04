package logic.typeOfBets;

import java.util.HashSet;

public class CornerBet extends TypeOfBet {
	HashSet<Integer>betBoxes;

	public CornerBet(HashSet<Integer> betBoxes) {
		super();
		this.betBoxes = betBoxes;
		this.coeficient = 8;
	}

	@Override
	public boolean isWinnerNumber(int box) {
		return betBoxes.contains(box);
		
	}
	

}
