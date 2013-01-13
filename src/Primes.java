import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {
	public List<Integer> calculateOrderedPrimesUpTo(int primesTo) {
		return extendOrderedPrimeList(new ArrayList<Integer>(), 2, primesTo);
	}

	public List<Integer> extendOrderedPrimeList(List<Integer> orderedPrimes, int startAt, int primesUpTo) {
		int valuesBetweenStartAndEnd = 1 + primesUpTo - startAt;
		boolean[] toIncludesAsPrime = booleanArray(valuesBetweenStartAndEnd);

		for (int existingPrime : orderedPrimes) {
			if (existingPrime > Math.sqrt(primesUpTo)) {
				break;
			}
			for (int valueToEliminate = calculateFirstValueToRemoveGreaterThan(existingPrime, startAt); valueToEliminate <= primesUpTo; valueToEliminate = valueToEliminate + existingPrime) {
				toIncludesAsPrime[valueToEliminate - startAt] = false;
			}
		}

		for (int currentValue = startAt; currentValue <= primesUpTo; currentValue++) {			
			if (currentValue > Math.sqrt(primesUpTo)) {
				break;
			}
			if (toIncludesAsPrime[currentValue - startAt]) {				
				for (int valueToEliminate = currentValue * currentValue; valueToEliminate <= primesUpTo; valueToEliminate = valueToEliminate + currentValue) {
					toIncludesAsPrime[valueToEliminate - startAt] = false;
				}
			}

		}

		orderedPrimes.addAll(convertToInOrderIncludeValuesWithOffset(toIncludesAsPrime, startAt));
		return orderedPrimes;
	}

	private int calculateFirstValueToRemoveGreaterThan(int prime, int minimum) {
		return prime * prime + ((int) Math.ceil(minimum/ ((double) prime)) - prime) * prime;
	}

	private List<Integer> convertToInOrderIncludeValuesWithOffset(boolean[] inclusionIndicator, int offset) {
		ArrayList<Integer> includedValues = new ArrayList<Integer>();
		for (int i = 0; i < inclusionIndicator.length; i++) {
			if (inclusionIndicator[i]) {
				includedValues.add(i + offset);
			}
		}
		return includedValues;
	}

	private boolean[] booleanArray(int size) {
		boolean[] booleans = new boolean[size];
		Arrays.fill(booleans, true);
		return booleans;
	}
}
