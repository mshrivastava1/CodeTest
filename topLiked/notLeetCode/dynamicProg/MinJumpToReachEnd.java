package dynamicProg;

import java.util.Arrays;

public class MinJumpToReachEnd {

	public int minimumJump(int[] nums){
		
		if(nums==null){
			return Integer.MAX_VALUE;
		}
		
		
		int[] dp = new int[nums.length];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=0;i<nums.length;i++){
			if(dp[i]!=Integer.MAX_VALUE){
				for(int j=1;j<=nums[i];j++){
					if(j+i<nums.length && dp[i]+1<dp[i+j]){
						dp[i+j] = Math.min(dp[i+j], dp[i]+1);
					}
				}
			}
		}
		
		return dp[nums.length-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] nums = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		
		int[] nums = {3,2,1,0,4};
		
		MinJumpToReachEnd obj = new MinJumpToReachEnd();
		
		System.out.println(obj.minimumJump(nums));
	}

}
