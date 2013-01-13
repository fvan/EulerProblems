import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {
	public List<Integer> calculatePrimesUpTo(int primesTo) {
		return extendPrimeList(new ArrayList<Integer>(), 2, primesTo);
	}


	public List<Integer> extendPrimeList(List<Integer> currentPrimes, int startAt, int primesUpTo) {
		int valuesBetweenStartAndEnd = 1 + primesUpTo - startAt;
		boolean[] booleanArray = booleanArray(valuesBetweenStartAndEnd);
		
		for (int existingPrime : currentPrimes) {
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
		
		List<Integer> newPrimes = convertToIncludedValuesWithOffset(booleanArray, startAt);
		currentPrimes.addAll(newPrimes);
		return currentPrimes;
	}
	
	private List<Integer> convertToIncludedValuesWithOffset(boolean[] inclusionIndicator, int offset) {
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
