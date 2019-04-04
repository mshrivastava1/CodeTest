package dynamicProg;

public class SubsetSumProblem {

	public boolean checkSumSubset(int[] nums, int sum){
		
		if(nums==null){
			return false;
		}
		
		if(nums.length==1 && nums[0]!=sum){
			return false;
		}
		
		
		boolean[][] dp = new boolean[nums.length+1][sum+1];
		
		for(int i=0;i<=nums.length;i++){
			dp[i][0] = true;
		}
		
		for(int i=1;i<=nums.length;i++){
			for(int j=1;j<=sum;j++){
				dp[i][j] = dp[i-1][j];
				if(j>=nums[i-1]){
					dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
				}
			}
		}
		
		return dp[nums.length][sum];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {3,34,4,12,5,2};
		
		int sum = 9;
		
		SubsetSumProblem obj = new SubsetSumProblem();
		
		System.out.println(obj.checkSumSubset(nums, sum));
	}

}
