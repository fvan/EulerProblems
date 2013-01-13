import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Solution1 {

	public int calculateSumOfMultiplesOf3and5before(int beforeThis) {
		int maxValue = beforeThis - 1;
		return calculateSumOfMultiples(3, maxValue) + calculateSumOfMultiples(5, maxValue) - calculateSumOfMultiples(15, maxValue);
	}

	private int calculateSumOfMultiples(int multiplesOf, int maxValue) {
		int numberOfThreeMultiples = maxValue / multiplesOf;
		return numberOfThreeMultiples * (numberOfThreeMultiples + 1) * multiplesOf / 2;
	}

	public static void main(String... args) {
		System.out.println(new Solution1().calculateSumOfMultiplesOf3and5before(1000));
	}

	@Test 
	public void test_that_we_can_calculate_the_sum_of_all_multiples_of_3and5_before_4() {
		assertThat(calculateSumOfMultiplesOf3and5before(4), is(3));
	}

	@Test
	public void test_that_we_can_calculate_the_sum_of_all_multiples_of_3and5_before_6() {
		assertThat(calculateSumOfMultiplesOf3and5before(6), is(3 + 5));
	}

	@Test
	public void test_that_we_can_calculate_the_sum_of_all_multiples_of_3and5_before_16() {
		assertThat(calculateSumOfMultiplesOf3and5before(16), is(3 + 5 + 6 + 9 + 10 + 12 + 15));
	}
}
