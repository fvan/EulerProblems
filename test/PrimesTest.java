import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PrimesTest {
	@Test
	public void test_that_it_calculates_the_primes_up_to_2() {
		assertThat(new Primes().calculateOrderedPrimesAtleastTo(2), containsInAnyOrder(2));
	}

	@Test
	public void test_that_it_calculates_the_primes_up_to_20_which_is_composite() {
		assertThat(new Primes().calculateOrderedPrimesAtleastTo(20), containsInAnyOrder(2, 3, 5, 7, 11, 13, 17, 19));
	}

	@Test
	public void test_that_it_calculates_the_primes_up_to_13_which_is_composite() {
		assertThat(new Primes().calculateOrderedPrimesAtleastTo(13), containsInAnyOrder(2, 3, 5, 7, 11, 13));
	}

	@Test
	public void test_that_we_can_extend_a_prime_list_when_the_max_is_not_a_prime() {
		Primes primes = new Primes();
		primes.calculateOrderedPrimesAtleastTo(13);
		assertThat(primes.calculateOrderedPrimesAtleastTo(50), containsInAnyOrder(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47));
	}
	
	@Test
	public void test_that_we_can_extend_a_prime_list_when_the_max_is_a_prime() {
		Primes primes = new Primes();
		primes.calculateOrderedPrimesAtleastTo(13);
		assertThat(primes.calculateOrderedPrimesAtleastTo(47), containsInAnyOrder(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47));
	}
}
