package logic.typeOfBets;

import logic.Number;

public class Column extends TypeOfBet {
	private int columnBeted;

	public Column(int columnBeted) {
		this();
		this.columnBeted = columnBeted;

	}

	public Column() {
		super();
		this.coeficient = 2;
	}

	public boolean isWinnerNumber(Number box) {
		return columnBeted == box.getColumn();
	}	
}
