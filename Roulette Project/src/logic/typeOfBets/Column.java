package logic.typeOfBets;

import java.util.Arrays;
import java.util.HashSet;


public class Column extends TypeOfBet { 
	private HashSet<Integer>column1;
	private HashSet<Integer>column2;
	private HashSet<Integer>column3;
	private int columnBeted;

	public Column(int columnBeted) {
		super();
		this.columnBeted = columnBeted;
		this.coeficient = 2;
		column1=new HashSet<Integer>(Arrays.asList(1,4,7,10,13,16,19,22,25,28,31,34));
		column2=new HashSet<Integer>(Arrays.asList(2,5,8,11,14,17,20,23,26,29,32,35));		
		column3=new HashSet<Integer>(Arrays.asList(3,6,9,12,15,18,21,24,27,30,33,36));
	}



	public boolean isWinnerNumber(int box) {
		if(columnBeted==1)return column1.contains(box);
		else if(columnBeted==2)return column2.contains(box);
		else if(columnBeted==3)return column3.contains(box);
		else return false;
	}
}
