package logic;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;

public class Number {
	private int value;
	
	public Number(int value) {
		this.value = value;
	}
	
	public Number() {
		this.value = (int) (Math.random()*37);
	}

	public Color getColor() {
		HashSet<Integer> red   = new HashSet<Integer>(Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36));
		HashSet<Integer> black = new HashSet<Integer>(Arrays.asList(2, 4, 6, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35));
		
		if(red.contains(value))
			return Color.RED;
		else if(black.contains(value))
			return Color.BLACK;
		else
			return null;
	}
	
	public int getColumn() {
		if(value == 0) return -1;
		return (value-1)%3;
	}

	public int getValue() {
		return value;
	}
}
