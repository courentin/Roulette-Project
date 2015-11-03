package logic.typeOfBets;

import java.util.HashSet;

public class CornerBet extends TypeOfBet {
	
	
	public boolean isWinnerNumber(HashSet<Integer> betBoxes,int box) {
		return betBoxes.contains(box);
	}
	

}
