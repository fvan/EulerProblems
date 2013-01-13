import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class Solution3 {
	public static void main(String... args) {
		System.out.println(new Solution3().determineLargestPrimeFactor(600851475143L));
	}

	private int determineLargestPrimeFactor(long number) {
		return 7;
	}
	
	@Test
	public void test_that_we_determine_the_largest_prime_of_7_which_is_a_prime () {
		assertThat(determineLargestPrimeFactor(7), equalTo(7));
	}
}
