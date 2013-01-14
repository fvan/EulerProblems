import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class Solution10 {
	private long calculateSumOfPrimesUpTo(int primesBelow) {
		Primes prime = new Primes();
		return sumOf(prime.calculateOrderedPrimesAtleastTo(primesBelow - 1));
	}

	private long sumOf(List<Integer> calculateOrderedPrimesAtleastTo) {
		long total = 0;
		for (int value : calculateOrderedPrimesAtleastTo) {
			total += value;
		}
		return total;
	}

	public static void main(String... args) {
		System.out.println(new Solution10().calculateSumOfPrimesUpTo(2000000));
		System.out.println("expected Answer:142913828922");
	}

	@Test
	public void test_that_we_calculate_the_sum_of_primes_up_to_6() {
		assertThat(new Solution10().calculateSumOfPrimesUpTo(6), equalTo(2L + 3 + 5));
	}

}
