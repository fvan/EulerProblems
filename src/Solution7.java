import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

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
	public void test_that_we_determine_the_4th_prime() {
		assertThat(determineNthPrime(4), equalTo(7));
	}

	@Test
	public void test_that_we_determine_the_10000th_prime() {
		assertThat(determineNthPrime(10000), equalTo(new Primes().calculateOrderedPrimesAtleastTo(1000000).get(9999)));
	}
}
