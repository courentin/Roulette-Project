package logic;

import java.util.ArrayList;

public class Column extends TypeOfBet {
	private ArrayList<Integer>column1;
	private ArrayList<Integer>column2;
	private ArrayList<Integer>column3;


	public Column() {
		super();
		column1=new ArrayList<Integer>();
		column2=new ArrayList<Integer>();
		column3=new ArrayList<Integer>();
		//ADD NUMBERS
	}



	public boolean isWinerNumber(int box,int column) {
		if(column==1)return column1.contains(column);
		else if(column==2)return column2.contains(column);
		else if(column==3)return column3.contains(column);
		else return false;	


	}




}
