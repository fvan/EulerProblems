import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class PrimesTest {
	@Test
	public void test_that_we_calculate_the_first_prime() {
		assertThat(new Primes().calculateOrderedPrimesAtleastTo(2), hasItems(2));
	}

	@Test
	public void test_that_we_calculate_the_primes_up_to_a_composite() {
		assertThat(new Primes().calculateOrderedPrimesAtleastTo(20), hasItems(2, 3, 5, 7, 11, 13, 17, 19));
	}

	@Test
	public void test_that_we_calculate_the_primes_up_to_a_prime() {
		assertThat(new Primes().calculateOrderedPrimesAtleastTo(13), hasItems(2, 3, 5, 7, 11, 13));
	}

	@Test
	public void test_that_we_can_re_call_calculate_primes_when_the_max_is_a_composite() {
		Primes primes = new Primes();
		primes.calculateOrderedPrimesAtleastTo(13);
		assertThat(primes.calculateOrderedPrimesAtleastTo(50), hasItems(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47));
	}
	
	@Test
	public void test_that_we_can_re_call_to_calculate_primes_when_the_max_is_a_prime() {
		Primes primes = new Primes();
		primes.calculateOrderedPrimesAtleastTo(13);
		assertThat(primes.calculateOrderedPrimesAtleastTo(47), hasItems(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47));
	}
	
	@Test
	public void test_that_we_can_re_call_to_calculate_primes_despite_already_having_calculated_larger_primes() {
		Primes primes = new Primes();
		primes.calculateOrderedPrimesAtleastTo(7);
		assertThat(primes.calculateOrderedPrimesAtleastTo(3), hasItems(2, 3));
	}
}
