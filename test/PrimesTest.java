import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class PrimesTest {
	@Test
	public void test_that_it_calculates_the_primes_up_to_2() {
		assertThat(new Primes().calculatePrimesUpToWithout1(2), containsInAnyOrder(2L));
		assertThat(new Primes().calculatePrimesUpTo(2), containsInAnyOrder(1L, 2L));
	}

	@Test
	public void test_that_it_calculates_the_primes_up_to_10() {
		assertThat(new Primes().calculatePrimesUpToWithout1(20), containsInAnyOrder(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L));
		assertThat(new Primes().calculatePrimesUpTo(20), containsInAnyOrder(1L, 2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L));
	}
}
