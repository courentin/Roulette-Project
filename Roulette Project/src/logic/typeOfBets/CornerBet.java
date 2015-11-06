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
	
	public void setBetBoxes(int one, int two, int three, int four) throws IllegalArgumentException {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(one);
		numbers.add(two);
		numbers.add(three);
		numbers.add(four);
		this.setBetBoxes(numbers);
	}
	
	public void setBetBoxes(List<Integer> numbers) throws IllegalArgumentException {
		Collections.sort(numbers);

		if(numbers.get(0)+1 == numbers.get(1) && numbers.get(1)+2 == numbers.get(2) && numbers.get(2)+1 == numbers.get(3)) {
			this.numbers = numbers;
		} else {
			throw new IllegalArgumentException("Theses values are incorrect");
		}
	}

	@Override
	public boolean isWinnerNumber(Number box) {
		return numbers.contains(box.getValue());
	}

	@Override
	public String printInfo() {
		return numbers.get(0) + " - " + numbers.get(1) + " - " + numbers.get(2) + " - " + numbers.get(3);
	}
}
