package logic.typeOfBets;

import logic.Number;

public class Column extends TypeOfBet {
	private int columnBeted;

	public Column(int columnBeted) {
		super();
		this.columnBeted = columnBeted;
		this.coeficient = 2;
	}

	public Column() {
		// TODO Auto-generated constructor stub
		this.name="Column1";
	}

	public boolean isWinnerNumber(Number box) {
		return columnBeted == box.getColumn();
	}	
}
