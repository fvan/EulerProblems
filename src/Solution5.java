import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;

public class Solution5 {

	public static void main(String... args) {
		System.out.println(new Solution5().calculateSmallestValueDivisibleByAllUpTo(20));
		System.out.println("expected Answer: 232792560");
	}

	private int calculateSmallestValueDivisibleByAllUpTo(int largestDivisor) {
		List<Integer> valuesNeededToFormProduct = new ArrayList<Integer>();
		List<Integer> usedPrimes = new Primes().calculateOrderedPrimesAtleastTo(largestDivisor);

		for (int prime : usedPrimes) {
			int primeToAPower = prime;
			while (primeToAPower <= largestDivisor) {
				valuesNeededToFormProduct.add(prime);
				primeToAPower = primeToAPower * prime;
			}
		}

		return productOf(valuesNeededToFormProduct);
	}

	private int productOf(List<Integer> valuesNeededToFormProduct) {
		int product = 1;
		for (int value : valuesNeededToFormProduct) {
			product = product * value;
		}
		return product;
	}

	
	@Test
	public void test_that_we_calculate_a_value_divisible_by_a_single_divisor() {
		assertThat(new Solution5().calculateSmallestValueDivisibleByAllUpTo(1), isDivisibleByAllUpTo(1));
	}

	@Test
	public void test_that_we_calculate_a_value_divisible_by_multiple_divisors() {
		assertThat(new Solution5().calculateSmallestValueDivisibleByAllUpTo(10), isDivisibleByAllUpTo(10));
	}

	@Test
	public void test_that_we_calculate_the_smallest_value_divisible_by_a_single_divisor() {
		assertThat(new Solution5().calculateSmallestValueDivisibleByAllUpTo(1), equalTo(1));
	}

	@Test
	public void test_that_we_calculate_the_smallest_value_divisible_by_multiple_divisors() {
		assertThat(new Solution5().calculateSmallestValueDivisibleByAllUpTo(4), equalTo(12));
	}

	private IsDivisibleByAllUpTo isDivisibleByAllUpTo(int upToDivisor) {
		return new IsDivisibleByAllUpTo(upToDivisor);
	}

	private class IsDivisibleByAllUpTo extends TypeSafeDiagnosingMatcher<Integer> {
		private int maxDivisor;

		public IsDivisibleByAllUpTo(int upToDivisor) {
			this.maxDivisor = upToDivisor;
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("Is Divisible By All Up To ");
			description.appendValue(maxDivisor);
		}

		@Override
		protected boolean matchesSafely(Integer valueToTest, Description mismatchDescription) {
			for (int i = 1; i <= maxDivisor; i++) {
				if (valueToTest % i != 0) {
					mismatchDescription.appendText(valueToTest + " was not divisible by " + i);
					return false;
				}
			}
			return true;
		}
	}
}