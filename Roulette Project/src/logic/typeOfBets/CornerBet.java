package logic.typeOfBets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import logic.Number;

public class CornerBet extends TypeOfBet {
	private List<Integer> numbers;

	public CornerBet() {
		super();
		this.coeficient = 8;
	}
	
	public void setBetBoxes(int one, int two, int three, int four) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(one);
		numbers.add(two);
		numbers.add(three);
		numbers.add(four);
		this.setBetBoxes(numbers);
	}
	
	public void setBetBoxes(List<Integer> numbers) throws IllegalArgumentException {
		Collections.sort(numbers, new Comparator<Integer>() {
			  public int compare(Integer c1, Integer c2) {
			    if (c1.intValue() > c2.intValue()) return -1;
			    if (c1.intValue() < c2.intValue()) return 1;
			    return 0;
		}});
		
		if(numbers.get(0)+1 == numbers.get(1) && numbers.get(1)+2 == numbers.get(2) && numbers.get(2)+1 == numbers.get(3)) {
			this.numbers = numbers;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public boolean isWinnerNumber(Number box) {
		return numbers.contains(box.getValue());	
	}

	@Override
	public String printInfo() {
		return numbers.toString();
	}
}
