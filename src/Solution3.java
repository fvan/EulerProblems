import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class Solution3 {
	public static void main(String... args) {
		System.out.println(new Solution3().determineLargestPrimeFactor(600851475143L));
		System.out.println("expected Answer: 6857");
	}

	private long determineLargestPrimeFactor(long number) {
		List<Integer> calculatedPrimesUpToWithout1 = (new Primes()).calculateOrderedPrimesAtleastTo((int) Math.sqrt(number));
		for (int i = calculatedPrimesUpToWithout1.size() - 1; i > 0; i--) {
			if(number % calculatedPrimesUpToWithout1.get(i) == 0) {
				return calculatedPrimesUpToWithout1.get(i);
			}
		}
		return number;
	}

	@Test
	public void test_that_we_determine_the_largest_prime_of_7_which_is_a_prime() {
		assertThat(determineLargestPrimeFactor(7), equalTo(7L));
	}

	@Test
	public void test_that_we_determine_the_largest_prime_of_18_which_is_a_composite() {
		assertThat(determineLargestPrimeFactor(18), equalTo(3L));
	}
}
