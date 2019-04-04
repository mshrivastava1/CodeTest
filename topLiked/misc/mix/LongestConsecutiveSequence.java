package mix;

import java.util.Arrays;

public class LongestConsecutiveSequence {
	
	public int longestConsecutive(int[] nums) {
		
		if(nums==null || nums.length==0){
			return 0;
		}
		
		if(nums.length==1){
			return 1;
		}
		
		Arrays.sort(nums);
		
		int[] dp = new int[nums.length];
		
		Arrays.fill(dp, 1);
		int longestSequence = 1;
		for(int i=0;i<nums.length-1;i++){
			/*int sequence = 1;
			for(int j=i;j<nums.length-1;j++){
				if(nums[j+1]==nums[j]+1){
					sequence ++;
					longestSequence = Math.max(sequence, longestSequence);
				}else{
					break;
				}
			}*/
			
			if(nums[i]==nums[i+1]){
				dp[i+1] = dp[i];
				longestSequence = Math.max(longestSequence, dp[i+1]);
			}else{
				if(nums[i]+1==nums[i+1]){
					dp[i+1] = dp[i]+1;
					longestSequence = Math.max(longestSequence, dp[i+1]);
				}
			}
			
		}
		return longestSequence;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {100, 4, 200, 1, 3, 2};
		
		//int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
		//int[] nums = {1,2,0,1};
		
		
		LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
		
		System.out.println(obj.longestConsecutive(nums));
	}

}
