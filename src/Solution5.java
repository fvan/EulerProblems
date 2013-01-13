import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Solution5 {

	public static void main(String... args) {
		System.out.println(new Solution5().calculateLargestValueDivisibleByAllUpTo(20));
	}

	private int calculateLargestValueDivisibleByAllUpTo(int largestDivisor) {
		ArrayList<Integer> valuesNeededToFormProduct = new ArrayList<Integer>();
		for (int i = 2; i <= largestDivisor; i++) {
			addValuesToBeAbleToForm(i, valuesNeededToFormProduct);
		}
		return productOf(valuesNeededToFormProduct);
	}

	private int productOf(ArrayList<Integer> valuesNeededToFormProduct) {
		int product = 1;
		for(int value : valuesNeededToFormProduct) {
			product = product * value;
		}
		return product;
	}

	private void addValuesToBeAbleToForm(int toForm, ArrayList<Integer> existingValues) {
		for (int currentValues : existingValues) {
			if(toForm % currentValues == 0) {
				toForm = toForm / currentValues;
			}
		}
		if(toForm != 1) {
			existingValues.add(toForm);
		}
	}
	
	@Test
	public void test_that_we_can_calculate_value_divisible_by_all_up_to_4() {
		assertThat(new Solution5().calculateLargestValueDivisibleByAllUpTo(4), equalTo(2 * 2 * 3));
	}
	
	@Test
	public void test_that_we_can_calculate_value_divisible_by_all_up_to_18() {
		assertThat(new Solution5().calculateLargestValueDivisibleByAllUpTo(18), equalTo(2 * 2 * 2 * 2 * 3 * 3 * 5 * 7 * 11 * 13 * 17));
	}
}
