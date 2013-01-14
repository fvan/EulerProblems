import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Solution2 {
	public static void main(String... args) {
		System.out.println(new Solution2().calculateSumOfEvenFibonachiUpTo(4000000));
		System.out.println("expected Answer: 4613732");
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
	public void test_that_we_calculate_the_even_fibonachi_sum_of_values_before_3() {
		assertThat(calculateSumOfEvenFibonachiUpTo(3), is(2));
	}

	@Test
	public void test_that_we_calculate_the_even_fibonachi_sum_of_values_before_9() {
		assertThat(calculateSumOfEvenFibonachiUpTo(9), is(2 + 8));
	}
}
