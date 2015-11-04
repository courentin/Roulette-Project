package logic.typeOfBets;

import java.awt.Color;
import logic.Number;

public class RedBlack extends TypeOfBet {

	private Color color;

	public RedBlack() {
		super();
		this.coeficient = 1;
	}

	public void setColor(Color color) throws IllegalArgumentException {
		if(color != Color.RED && color != Color.BLACK) throw new IllegalArgumentException();
		this.color = color;
	}

	public boolean isWinnerNumber(Number box) {
		if(color == Color.RED)
			return box.getColor() == Color.RED;
		else
			return box.getColor() == Color.BLACK;
	}

	@Override
	public String printInfo() {
		
		return color.toString();
	}
}
