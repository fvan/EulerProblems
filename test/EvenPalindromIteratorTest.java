import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class EvenPalindromIteratorTest {

	@Test
	public void test_that_we_can_calculate_the_largest_but_shortest_even_palindrome() {
		EvenPalindromeFromLargestIterator evenPalindromeFromLargestIterator = new EvenPalindromeFromLargestIterator(2);
		assertThat(evenPalindromeFromLargestIterator.next(), equalTo(99));
	}

	@Test
	public void test_that_we_can_calculate_the_largest_even_palindrom_wiht_more_digits() {
		EvenPalindromeFromLargestIterator evenPalindromeFromLargestIterator = new EvenPalindromeFromLargestIterator(6);
		assertThat(evenPalindromeFromLargestIterator.next(), equalTo(999999));
	}

	@Test
	public void test_that_we_can_calculate_the_next_largest() {
		EvenPalindromeFromLargestIterator evenPalindromeFromLargestIterator = new EvenPalindromeFromLargestIterator(6);
		evenPalindromeFromLargestIterator.next();
		assertThat(evenPalindromeFromLargestIterator.next(), equalTo(998899));
	}

	@Test
	public void test_that_we_can_calculate_multiple_next_largest() {
		EvenPalindromeFromLargestIterator evenPalindromeFromLargestIterator = new EvenPalindromeFromLargestIterator(6);
		evenPalindromeFromLargestIterator.next();
		evenPalindromeFromLargestIterator.next();
		evenPalindromeFromLargestIterator.next();
		assertThat(evenPalindromeFromLargestIterator.next(), equalTo(996699));
	}

	@Test
	public void test_that_we_can_calculate_next_largest_such_that_a_second_digit_should_decrease() {
		EvenPalindromeFromLargestIterator evenPalindromeFromLargestIterator = new EvenPalindromeFromLargestIterator(6);
		for (int i = 0; i < 10; i++) {
			evenPalindromeFromLargestIterator.next();
		}
		assertThat(evenPalindromeFromLargestIterator.next(), equalTo(989989));
	}

	@Test
	public void test_that_we_can_calculate_next_largest_such_that_a_later_digit_should_decrease() {
		EvenPalindromeFromLargestIterator evenPalindromeFromLargestIterator = new EvenPalindromeFromLargestIterator(6);
		for (int i = 0; i < 100; i++) {
			evenPalindromeFromLargestIterator.next();
		}
		assertThat(evenPalindromeFromLargestIterator.next(), equalTo(899998));
	}

	@Test
	public void test_that_we_have_next_until_we_have_used_up_all_palindromes() {
		EvenPalindromeFromLargestIterator evenPalindromeFromLargestIterator = new EvenPalindromeFromLargestIterator(2);
		for (int expectedRemaining = 9; expectedRemaining > 0; expectedRemaining--) {
			assertThat("expected to have next and to then have next " + expectedRemaining + "more times", evenPalindromeFromLargestIterator.hasNext());
			evenPalindromeFromLargestIterator.next();
		}
		assertThat("expected to have used all values", !evenPalindromeFromLargestIterator.hasNext());
	}
}
