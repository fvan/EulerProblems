import java.util.ArrayList;

public class Primes {
	public ArrayList<Integer> calculatePrimesUpToWithout1(int largestDivisor) {
		ArrayList<Integer> remainingNumbers = allNumbersNotOneTo(largestDivisor);
		for (int i = 0; i < remainingNumbers.size(); i++) {
			removeMultipleOf(remainingNumbers, remainingNumbers.get(i), i + 1);
		}
		return remainingNumbers;
	}
	
	public ArrayList<Integer> calculatePrimesUpTo(int largestDivisor) {
		ArrayList<Integer> remainingNumbers = calculatePrimesUpToWithout1(largestDivisor);
		remainingNumbers.add(1);
		return remainingNumbers;
	}
	
	private void removeMultipleOf(ArrayList<Integer> remainingNumbers, int multipleOf, int startingAtIndex) {
		for (int i = remainingNumbers.size() - 1; i >= startingAtIndex; i--) {
			if (remainingNumbers.get(i) % multipleOf == 0) {
				remainingNumbers.remove(i);
			}
		}
	}

	private ArrayList<Integer> allNumbersNotOneTo(int largestNumber) {
		ArrayList<Integer> remainingNumbers = new ArrayList<Integer>(largestNumber - 1);
		for (int i = 2; i <= largestNumber; i++) {
			remainingNumbers.add(i);
		}
		return remainingNumbers;
	}


}
