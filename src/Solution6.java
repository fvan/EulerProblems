import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class Solution6 {

	@Test
	public void test_that_we_can_calculate_the_difference_of_square_of_sum_and_sum_of_of_squares_up_to_1() {
		Assert.assertThat(new Solution6().getDifferenceOfSquareOfSumAndSumOfSquare(1), Matchers.equalTo(0));
	}

	@Test
	public void test_that_we_can_calculate_the_difference_of_square_of_sum_and_sum_of_of_squares_up_to_2() {
		Assert.assertThat(new Solution6().getDifferenceOfSquareOfSumAndSumOfSquare(2), Matchers.equalTo(4));
	}

	public static void main(String... args) {
		System.out.println(new Solution6().getDifferenceOfSquareOfSumAndSumOfSquare(100));
		System.out.println("expected Answer:25164150");
	}

	private int getDifferenceOfSquareOfSumAndSumOfSquare(int value) {
		int sumUpToGiven = (value + 1) * value / 2;
		int sumOfSquares = (value * (value + 1) * (2 * value + 1)) / 6;
		return (int) Math.pow(sumUpToGiven, 2) - sumOfSquares;
	}
}
