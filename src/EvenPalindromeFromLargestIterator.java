import java.util.Arrays;
import java.util.Iterator;

public class EvenPalindromeFromLargestIterator implements Iterator<Integer> {

	private int[] palindromDigitValues;

	public EvenPalindromeFromLargestIterator(int digits) {
		palindromDigitValues = buildPalindromeRepresentation(digits/2);
	}
	
	@Override
	public boolean hasNext() {
		return buildPalindrom() != 0;
	}

	@Override
	public Integer next() {
		int valueOfCurrent = buildPalindrom();
		decreaseToNextPalindromRepresentation();
		return valueOfCurrent;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	private int[] buildPalindromeRepresentation(int digits) {
		int[] palindromDigitValues = new int[digits];
		Arrays.fill(palindromDigitValues, 9);
		return palindromDigitValues;
	}

	private void decreaseToNextPalindromRepresentation() {
		for (int i = 0; i < palindromDigitValues.length; i++) {
			if (palindromDigitValues[i] == 0) {
				palindromDigitValues[i] = 9;
			} else {
				palindromDigitValues[i] = palindromDigitValues[i] - 1;
				return;
			}
		}
	}

	private int buildPalindrom() {
		int palindrome = 0;
		for (int i = 0; i < palindromDigitValues.length; i++) {
			palindrome += palindromDigitValues[i] * Math.pow(10, palindromDigitValues.length - 1 - i);
			palindrome += palindromDigitValues[i] * Math.pow(10, palindromDigitValues.length + i);
		}
		return palindrome;
	}
}
