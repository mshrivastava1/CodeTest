package mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import javafx.geometry.Side;

public class SumToZero {

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length < 3) {
			return result;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			if (i == 0 || (i > 0 && nums[i - 1] != nums[i])) {

				int low = i + 1;
				int hi = nums.length - 1;
				int sum = 0 - nums[i];

				while (low < hi) {

					if (nums[low] + nums[hi] == sum) {
						result.add(Arrays.asList(nums[i], nums[low], nums[hi]));
						while (low < hi && nums[low] == nums[low + 1]) {
							low++;
						}
						while (low < hi && nums[hi] == nums[hi - 1]) {
							hi--;
						}
						low++;
						hi--;
					}else if (nums[low] + nums[hi] < sum) {
						low++;
					} else {
						hi--;
					}
				}
			}
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { -1, 0, 1, 2, -1, -4 };

		SumToZero obj = new SumToZero();

		System.out.println(obj.threeSum(nums));
	}

}
