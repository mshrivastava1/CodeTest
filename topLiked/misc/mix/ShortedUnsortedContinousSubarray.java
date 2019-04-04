package mix;

import java.util.Arrays;

public class ShortedUnsortedContinousSubarray {
	
	
	public int findUnsortedSubarray(int[] nums) {
		
		if(nums.length==0){
			return 0;
		}
		int n = nums.length;
		int[] temp = nums.clone();
		Arrays.sort(temp);

		int start =0;
		int end = nums.length-1;
		
		while(start<n && nums[start]==temp[start]){
			start++;
		}
		
		while(end>start && nums[end]==temp[end]){
			end--;
		}
		
		return end-start+1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 1, 2, 3, 4, 5 };

		ShortedUnsortedContinousSubarray obj = new ShortedUnsortedContinousSubarray();

		System.out.println(obj.findUnsortedSubarray(nums));
	}

}
