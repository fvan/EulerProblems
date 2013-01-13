import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {
	public List<Integer> calculateOrderedPrimesUpTo(int primesTo) {
		return extendOrderedPrimeList(new ArrayList<Integer>(), 2, primesTo);
	}


	public List<Integer> extendOrderedPrimeList(List<Integer> orderedPrimes, int startAt, int primesUpTo) {
		int valuesBetweenStartAndEnd = 1 + primesUpTo - startAt;
		boolean[] booleanArray = booleanArray(valuesBetweenStartAndEnd);
		
		for (int existingPrime : orderedPrimes) {
			if(existingPrime > Math.sqrt(primesUpTo)) {
				break;
			}
			for (int valueToEliminate = existingPrime * existingPrime; valueToEliminate <= primesUpTo; valueToEliminate = valueToEliminate + existingPrime) {
				int arrayIndex = valueToEliminate - startAt;
				if(arrayIndex < 0) {
					continue;
				}
				booleanArray[arrayIndex] = false;
			}
		}
		
		for (int currentArrayPosition = 0; currentArrayPosition < booleanArray.length; currentArrayPosition++) {
			int currentValue = currentArrayPosition + startAt;
			if(currentValue > Math.sqrt(primesUpTo)) {
				break;
			}
			if(!booleanArray[currentArrayPosition]) {
				continue;
			}
			for (int i = currentValue * currentValue - startAt; i < booleanArray.length; i = i + currentValue) {
				booleanArray[i] = false;
			}
		}
		
		orderedPrimes.addAll(convertToInOrderIncludeValuesWithOffset(booleanArray, startAt));
		return orderedPrimes;
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
