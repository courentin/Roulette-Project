package logic;

import java.awt.Color;

public class Box {
	private int number;
	private int column;
	private Color color;
	private boolean isBetted;
	public Box(int number,Color color,int column){
		this.number=number;
		this.color=color;
		this.column=column;
		isBetted=false;
		
		
	
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	

}
