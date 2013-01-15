import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class Solution6 {
	private int getDifferenceOfSquareOfSumAndSumOfSquare(int value) {
		int sumUpToGiven = (value + 1) * value / 2;
		int sumOfSquares = (value * (value + 1) * (2 * value + 1)) / 6;
		return (int) Math.pow(sumUpToGiven, 2) - sumOfSquares;
	}
	
	@Test
	public void test_that_we_calculate_the_difference_of_square_of_sum_and_sum_of_of_squares_for_a_single_value() {
		assertThat(new Solution6().getDifferenceOfSquareOfSumAndSumOfSquare(1), equalTo(0));
	}

	@Test
	public void test_that_we_calculate_the_difference_of_square_of_sum_and_sum_of_of_squares_for_multiple_values() {
		assertThat(new Solution6().getDifferenceOfSquareOfSumAndSumOfSquare(2), equalTo(4));
	}

	public static void main(String... args) {
		System.out.println(new Solution6().getDifferenceOfSquareOfSumAndSumOfSquare(100));
		System.out.println("expected Answer:25164150");
	}
}
