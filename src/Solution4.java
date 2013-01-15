import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class Solution4 {

	// WARNING : assumed an even sized solution exist, this is not the case when
	// digits == 1
	private int largestEvenPalindromFromDigits(int digits) throws NoSuchElementException {
		if (digits == 1) {
			throw new NoSuchElementException("there is no even sized solution when digits is 1");
		}
		for(int evenPalindrome : new EvenPalindromeFromLargestIterator(digits*2)) {
			if (hasProductOfDigitSize(evenPalindrome, digits)) {
				return evenPalindrome;
			}
		}
		throw new NoSuchElementException("unexpectedly no even palidrome");
	}

	private boolean hasProductOfDigitSize(int proposedPalindrome, int digits) {
		for (int divisor = maxDivisor(digits); divisor >= minDivisor(digits); divisor--) {
			if (isDivisibleWithAndHasDigits(proposedPalindrome, divisor, digits)) {
				return true;
			}
		}
		return false;
	}

	private double minDivisor(int digits) {
		return Math.pow(10, digits - 1);
	}

	private int maxDivisor(int digits) {
		return (int) Math.pow(10, digits) - 1;
	}

	private boolean isDivisibleWithAndHasDigits(int proposedPalindrome, int divisor, int digits) {
		return proposedPalindrome % divisor == 0 && proposedPalindrome / divisor < Math.pow(10, digits) && proposedPalindrome / divisor >= minDivisor(digits);
	}

	
	public static void main(String... args) throws Exception {
		System.out.println(new Solution4().largestEvenPalindromFromDigits(3));
		System.out.println("expected Answer:906609");
	}

	@Test
	public void test_that_we_determine_the_largest_even_palindrom_of_2_digit_numbers() throws Exception {
		assertThat(largestEvenPalindromFromDigits(2), equalTo(9009)); // WARNING : number originates from easily findable online sources
	}

	@Test
	public void test_that_we_determine_the_largest_even_palindrom_of_larger_digit_numbers() throws Exception {
		assertThat(largestEvenPalindromFromDigits(3), equalTo(906609)); // WARNING : number originates from easily findable online sources
	}

	@Test(expected = NoSuchElementException.class)
	public void test_that_we_cannot_determine_the_largest_even_palindrom_of_1_digit_numbers() throws Exception {
		largestEvenPalindromFromDigits(1);
	}
}