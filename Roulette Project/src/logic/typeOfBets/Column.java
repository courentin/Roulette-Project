package logic.typeOfBets;

import logic.Number;

public class Column extends TypeOfBet {
	private int columnBeted;

	public Column(int columnBeted) {
		super();
		this.columnBeted = columnBeted;
		this.coeficient = 2;
	}

	public boolean isWinnerNumber(Number box) {
		return columnBeted == box.getColumn();
	}	
}
