package logic.typeOfBets;

import logic.Number;

public class FailedPassed extends TypeOfBet {
	
	public static final String FAILED = "Failed";
	public static final String PASSED = "Passed";

	private String type;
	
	public FailedPassed() {
		this.coeficient = 1;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isWinnerNumber(Number box) {
		int value = box.getValue();
		if(type == FAILED)
			return value >= 1 && value <= 18;
		else
			return value >= 19 && value <= 36;
	}
	
	public String printInfo() {
		return type;
	}
}
