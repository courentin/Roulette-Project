package logic.typeOfBets;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import logic.Number;

public class RedBlack extends TypeOfBet {

	private Color color;
	
	public RedBlack(Color color) throws IllegalArgumentException {
		if(color != Color.RED && color != Color.BLACK) throw new IllegalArgumentException();
		this.color = color;
		this.coeficient = 1;
	}

	public boolean isWinnerNumber(Number box) {
		if(color == Color.RED)
			return box.getColor() == Color.RED;
		else
			return box.getColor() == Color.BLACK;
	}
}
