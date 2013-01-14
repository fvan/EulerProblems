import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Solution4 {

	public static void main(String ... args) throws Exception {
		System.out.println(new Solution4().largestEvenPalindromFromDigits(3));
		System.out.println("expected Answer:906609");
	}
	
	@Test
	public void test_that_we_can_determine_the_largest_palindrom_of_2_digit_numbers() throws Exception {
		assertThat(largestEvenPalindromFromDigits(2), equalTo(9009));
	}

	@Test
	public void test_that_we_can_determine_the_largest_palindrom_of_3_digit_numbers() throws Exception {
		assertThat(largestEvenPalindromFromDigits(3), equalTo(906609));
	}
	
	private int largestEvenPalindromFromDigits(int digits) throws Exception {
		int[] palindromDigitValues = new int[digits];
		Arrays.fill(palindromDigitValues, 9);
		while(true) {
			int proposedPalindrome = buildPalindrom(palindromDigitValues);
			if(hasProductOfDigitSize(proposedPalindrome, digits)) {
				return proposedPalindrome;
			}
			decreaseToNextPalindromRepresentation(palindromDigitValues);
		}
	}

	private void decreaseToNextPalindromRepresentation(int[] palindromDigitValue) {
		for(int i = 0; i < palindromDigitValue.length ; i++) {
			if(palindromDigitValue[i] == 0) {
				palindromDigitValue[i] = 9;
			} else {
				palindromDigitValue[i] = palindromDigitValue[i] - 1;
				return;
			}
		}
	}

	private int buildPalindrom(int[] palindromDigitValue) {
		int palindrom = 0;
		for(int i = 0; i < palindromDigitValue.length ; i ++) {
			palindrom += palindromDigitValue[i] * Math.pow(10, palindromDigitValue.length - 1 - i);
			palindrom += palindromDigitValue[i] * Math.pow(10, palindromDigitValue.length + i); 
		}
		return palindrom;
	}

	private boolean hasProductOfDigitSize(int proposedPalindrome, int digits) {
		for(int divisor = (int) Math.pow(10, digits) - 1 ; divisor >= Math.pow(10, digits - 1); divisor-- ) {
			if(isDivisibleByWithAndHasDigits(proposedPalindrome, divisor, digits)) {
				return true;
			}
		}
		return false;
	}

	private boolean isDivisibleByWithAndHasDigits(int proposedPalindrome, int divisor, int digits) {
		return proposedPalindrome % divisor == 0 && proposedPalindrome / divisor < Math.pow(10, digits) &&  proposedPalindrome / divisor >= Math.pow(10, digits - 1);
	}

	private int nextSmallestProductPalindromeInner(int currentInner, int digits) {
		int rightMostDigit = currentInner % 10;
		currentInner = currentInner - 11;
		return currentInner;
	}
}