import java.util.ArrayList;

public class Primes {
	public ArrayList<Long> calculatePrimesUpToWithout1(long number) {
		ArrayList<Long> remainingNumbers = allOddsNumbersNotOneToWith2(number);
		for (int i = 0; i < remainingNumbers.size(); i++) {
			removeMultipleOf(remainingNumbers, remainingNumbers.get(i), i + 1);
		}
		return remainingNumbers;
	}
	
	public ArrayList<Long> calculatePrimesUpTo(long number) {
		ArrayList<Long> remainingNumbers = calculatePrimesUpToWithout1(number);
		remainingNumbers.add(1L);
		return remainingNumbers;
	}
	
	private void removeMultipleOf(ArrayList<Long> remainingNumbers, long multipleOf, long startingAtIndex) {
		for (int i = remainingNumbers.size() - 1; i >= startingAtIndex; i--) {
			if (remainingNumbers.get(i) % multipleOf == 0) {
				remainingNumbers.remove(i);
			}
		}
	}

	private ArrayList<Long> allOddsNumbersNotOneToWith2(long largestNumber) {
		ArrayList<Long> remainingNumbers = new ArrayList<Long>();
		remainingNumbers.add(2L);
		for (long i = 3; i <= largestNumber; i = i+2) {
			remainingNumbers.add(i);
		}
		return remainingNumbers;
	}


}
