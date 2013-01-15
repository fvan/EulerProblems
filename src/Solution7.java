import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class Solution7 {
	private Integer determineNthPrime(int nthPrime) {
		Primes primes = new Primes();
		return primes.getFirstPrimes(nthPrime).get(nthPrime - 1);
	}
	
	public static void main(String ... args) {
		System.out.println(new Solution7().determineNthPrime(10001));
		System.out.println("expected Answer: 104743");
	}
	
	@Test
	public void test_that_we_determine_the_1st_prime() {
		assertThat(determineNthPrime(1), equalTo(2));
	}

	@Test
	public void test_that_we_determine_a_later_prime() {
		assertThat(determineNthPrime(4), equalTo(7));
	}
}
