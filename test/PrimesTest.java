import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class PrimesTest {
	@Test
	public void test_that_it_calculates_the_primes_up_to_2() {
		assertThat(new Primes().calculatePrimesUpTo(2), containsInAnyOrder(1, 2));
	}

	@Test
	public void test_that_it_calculates_the_primes_up_to_10() {
		assertThat(new Primes().calculatePrimesUpTo(20), containsInAnyOrder(1, 2, 3, 5, 7, 11, 13, 17, 19));
	}
}
