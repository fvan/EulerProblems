import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {

	private List<Integer> currentPrimes;
	private int currentMax;

	public Primes() {
		currentPrimes = new ArrayList<Integer>();
		currentMax = 1;
	}

	public List<Integer> calculateOrderedPrimesUpTo(int primesTo) {
		extendOrderedPrimeList(primesTo);
		return currentPrimes;
	}

	private void extendOrderedPrimeList(int primesUpTo) {
		int startValue = currentMax + 1;
		int valuesBetweenStartAndEnd = 1 + primesUpTo - startValue;
		boolean[] toIncludesAsPrime = booleanArray(valuesBetweenStartAndEnd);

		eliminateBasedOnPreexistingPrimes(toIncludesAsPrime, startValue, primesUpTo);
		eliminateBasedOnNewPrimes(toIncludesAsPrime, startValue, primesUpTo);

		currentPrimes.addAll(convertToInOrderIncludeValuesWithOffset(toIncludesAsPrime, startValue));
		currentMax = primesUpTo;
	}

	private void eliminateBasedOnNewPrimes(boolean[] toIncludesAsPrime, int startValue, int primesUpTo) {
		for (int currentValue = startValue; currentValue <= primesUpTo; currentValue++) {
			if (currentValue > Math.sqrt(primesUpTo)) {
				break;
			}
			if (toIncludesAsPrime[currentValue - startValue]) {
				for (int valueToEliminate = currentValue * currentValue; valueToEliminate <= primesUpTo; valueToEliminate = valueToEliminate + currentValue) {
					toIncludesAsPrime[valueToEliminate - startValue] = false;
				}
			}
		}
	}

	private void eliminateBasedOnPreexistingPrimes(boolean[] toIncludesAsPrime, int startValue, int primesUpTo) {
		for (int existingPrime : currentPrimes) {
			if (existingPrime > Math.sqrt(primesUpTo)) {
				break;
			}
			for (int valueToEliminate = calculateFirstValueToRemoveGreaterThan(existingPrime, startValue); valueToEliminate <= primesUpTo; valueToEliminate = valueToEliminate + existingPrime) {
				toIncludesAsPrime[valueToEliminate - startValue] = false;
			}
		}
	}

	private int calculateFirstValueToRemoveGreaterThan(int prime, int minimum) {
		return prime * prime + ((int) Math.ceil(minimum / ((double) prime)) - prime) * prime;
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
