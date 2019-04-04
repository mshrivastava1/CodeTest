package mix;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateNumber {

	public int findDuplicate(int[] nums) {

		if (nums == null || nums.length < 2) {
			return Integer.MAX_VALUE;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int num : nums){
			if(map.containsKey(num)){
				return num;
			}
			map.put(num, 1);
		}

		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,3,4,2,2};
		
		FindDuplicateNumber obj = new FindDuplicateNumber();
		
		System.out.println(obj.findDuplicate(nums));
	}

}
