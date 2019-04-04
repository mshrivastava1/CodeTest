package mix;

import java.util.ArrayList;
import java.util.List;

public class FirstAndLastPositionInSortedArray {

	public int[] searchRange(int[] nums, int target) {
		int s = find(nums, target);
		if (s == nums.length || nums[s] != target) {
			return new int[] { -1, -1 };
		}
		int e = find(nums, target + 1) - 1;
		if (e == nums.length || nums[e] != target) {
			return new int[] { -1, -1 };
		}
		return new int[] { s, e };
	}

	private int find(int[] nums, int target) {
		int s = 0, e = nums.length;
		while (s < e) {
			int m = (s + e) / 2;
			if (nums[m] >= target) {
				e = m;
			} else {
				s = m + 1;
			}
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[] nums = {5,7,7,8,8,10};
		int[] nums = { 3, 3, 3 };
		int target = 3;

		FirstAndLastPositionInSortedArray ob = new FirstAndLastPositionInSortedArray();

		System.out.println((ob.searchRange(nums, target))[0] + " " + (ob.searchRange(nums, target))[1]);
	}

}
