import java.util.ArrayList;
import java.util.Arrays;

public class Primes {
	public ArrayList<Integer> calculatePrimesUpTo(int number) {
		boolean[] numberInclusion = booleanArrayUpTo(number);
		for (int currentPrime = 2; currentPrime <= number; currentPrime++) {
			if(currentPrime > Math.sqrt(number)) {
				break;
			}
			sieveBasedOnPrime(numberInclusion, currentPrime);
		}
		return convertToIncludedValues(numberInclusion);
	}

	public ArrayList<Integer> calculatePrimesUpToWithout1(int number) {
		ArrayList<Integer> primes = calculatePrimesUpTo(number);
		primes.remove(new Integer(1));
		return primes;
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

	private void sieveBasedOnPrime(boolean[] numberInclusion, int currentPrime) {
		for (int i = currentPrime * currentPrime - 1; i < numberInclusion.length; i = i + currentPrime) {
			numberInclusion[i] = false;
		}
	}

	private boolean[] booleanArrayUpTo(int largestNumber) {
		boolean[] booleans = new boolean[largestNumber];
		Arrays.fill(booleans, true);
		return booleans;
	}
}
