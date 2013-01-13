import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PrimesTest {
	@Test
	public void test_that_it_calculates_the_primes_up_to_2() {
		assertThat(new Primes().calculateOrderedPrimesUpTo(2), containsInAnyOrder(2));
	}

	@Test
	public void test_that_it_calculates_the_primes_up_to_20_which_is_composite() {
		assertThat(new Primes().calculateOrderedPrimesUpTo(20), containsInAnyOrder(2, 3, 5, 7, 11, 13, 17, 19));
	}

	@Test
	public void test_that_it_calculates_the_primes_up_to_13_which_is_composite() {
		assertThat(new Primes().calculateOrderedPrimesUpTo(13), containsInAnyOrder(2, 3, 5, 7, 11, 13));
	}

	@Test
	public void test_that_we_can_extend_a_prime_list_when_the_max_is_not_a_prime() {
		Primes primes = new Primes();
		List<Integer> primesTo13 = primes.calculateOrderedPrimesUpTo(13);
		assertThat(primes.extendOrderedPrimeList(primesTo13, 14, 50), containsInAnyOrder(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47));
	}
	
	@Test
	public void test_that_we_can_extend_a_prime_list_when_the_max_is_a_prime() {
		Primes primes = new Primes();
		List<Integer> primesTo13 = primes.calculateOrderedPrimesUpTo(13);
		assertThat(primes.extendOrderedPrimeList(primesTo13, 14, 47), containsInAnyOrder(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47));
	}
}
