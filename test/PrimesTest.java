import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PrimesTest {
	@Test
	public void test_that_it_calculates_the_primes_up_to_2() {
		assertThat(new Primes().calculatePrimesUpToWithout1(2), containsInAnyOrder(2));
	}

	@Test
	public void test_that_it_calculates_the_primes_up_to_20_which_is_composite() {
		assertThat(new Primes().calculatePrimesUpToWithout1(20), containsInAnyOrder(2, 3, 5, 7, 11, 13, 17, 19));
	}
	
	@Test
	public void test_that_it_calculates_the_primes_up_to_13_which_is_composite() {
		assertThat(new Primes().calculatePrimesUpToWithout1(13), containsInAnyOrder(2, 3, 5, 7, 11, 13));
	}
}
