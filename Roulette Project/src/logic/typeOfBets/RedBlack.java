package logic.typeOfBets;

import java.util.Arrays;
import java.util.HashSet;

public class RedBlack extends TypeOfBet {
	
	public static final int RED = 1;
	public static final int BLACK = 2;

	private int color;
	
	public RedBlack(int color) throws IllegalArgumentException {
		if(color != RED && color != BLACK) throw new IllegalArgumentException();
		this.color = color;
	}

	public boolean isWinnerNumber(int box) {
		HashSet<Integer> red   = new HashSet<Integer>(Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36));
		HashSet<Integer> black = new HashSet<Integer>(Arrays.asList(2, 4, 6, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35));
		
		if(color == RED)
			 return red.contains(box);
		else
		 	return black.contains(box);
	}
}
