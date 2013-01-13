import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Solution2 {
	public static void main(String... args) {
		System.out.println(new Solution2().calculateSumOfEvenFibonachiUpTo(4000000));
	}

	public int calculateSumOfEvenFibonachiUpTo(int smallerThan) {

		int sumOfEven = 0;
		int valueBefore = 1;
		int nextValue = 2;
		while (nextValue < smallerThan) {
			if (nextValue % 2 == 0) {
				sumOfEven += nextValue;
			}
			int valueTwiceBefore = valueBefore;
			valueBefore = nextValue;
			nextValue = valueBefore + valueTwiceBefore;
		}

		return sumOfEven;
	}

	@Test
	public void test_that_we_can_calculate_then_values_before_3() {
		assertThat(calculateSumOfEvenFibonachiUpTo(3), is(2));
	}

	@Test
	public void test_that_we_can_calculate_then_values_before_9() {
		assertThat(calculateSumOfEvenFibonachiUpTo(9), is(2 + 8));
	}
}
