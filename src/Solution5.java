import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Solution5 {

	public static void main(String... args) {
		System.out.println(new Solution5().calculateLargestValueDivisibleByAllUpTo(20));
		System.out.println("expected Answer: 232792560");
	}

	private int calculateLargestValueDivisibleByAllUpTo(int largestDivisor) {
		List<Integer> valuesNeededToFormProduct = new ArrayList<Integer>();
		List<Integer> usedPrimes = new Primes().calculateOrderedPrimesUpTo(largestDivisor);
		
		for (int prime : usedPrimes) {
			int primeToAPower = prime;
			while(primeToAPower <= largestDivisor) {
				valuesNeededToFormProduct.add(prime);
				primeToAPower = primeToAPower * prime;
			}
		}
		
		return productOf(valuesNeededToFormProduct);
	}

	private int productOf(List<Integer> valuesNeededToFormProduct) {
		int product = 1;
		for(int value : valuesNeededToFormProduct) {
			product = product * value;
		}
		return product;
	}

	@Test
	public void test_that_we_can_calculate_value_divisible_by_all_up_to_4() {
		assertThat(new Solution5().calculateLargestValueDivisibleByAllUpTo(4), equalTo(2 * 2 * 3));
	}
	
	@Test
	public void test_that_we_can_calculate_value_divisible_by_all_up_to_18() {
		assertThat(new Solution5().calculateLargestValueDivisibleByAllUpTo(18), equalTo(2 * 2 * 2 * 2 * 3 * 3 * 5 * 7 * 11 * 13 * 17));
	}
}
