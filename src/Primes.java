import java.util.ArrayList;
import java.util.Arrays;

public class Primes {
	public ArrayList<Integer> calculatePrimesUpToWithout1(int number) {
		boolean[] numberInclusion = booleanArrayUpTo(number); 
		numberInclusion[0] = false; // WARN : 0 index thus number 1
		for (int currentPrime = 2; currentPrime <= number; currentPrime++) {
			if(currentPrime > Math.sqrt(number)) {
				break;
			}
			for (int i = currentPrime * currentPrime - 1; i < numberInclusion.length; i = i + currentPrime) {
				numberInclusion[i] = false;
			}
		}
		return convertToIncludedValues(numberInclusion);
	}

	private ArrayList<Integer> convertToIncludedValues(boolean[] inclusionIndicator) {
		ArrayList<Integer> includedValues = new ArrayList<Integer>();
		for (int i = 0; i < inclusionIndicator.length; i++) {
			if (inclusionIndicator[i]) {
				includedValues.add(i + 1);
			}
		}
		return includedValues;
	}

	private boolean[] booleanArrayUpTo(int largestNumber) {
		boolean[] booleans = new boolean[largestNumber];
		Arrays.fill(booleans, true);
		return booleans;
	}
}
