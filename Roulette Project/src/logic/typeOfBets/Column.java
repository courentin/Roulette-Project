package logic.typeOfBets;

import logic.Number;

public class Column extends TypeOfBet {
	private int columnBeted;

	public Column() {
		super();
		this.coeficient = 2;
	}

	public void setColomnBeted(int columnBeted) throws IllegalArgumentException {
		if(columnBeted < 0 || columnBeted > 2) throw new IllegalArgumentException();
		this.columnBeted = columnBeted;
	}
	
	public boolean isWinnerNumber(Number box) {
		return columnBeted == box.getColumn();
	}

	
	
}
