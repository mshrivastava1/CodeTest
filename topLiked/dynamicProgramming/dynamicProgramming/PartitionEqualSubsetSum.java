package dynamicProgramming;

/*
 Let isSubsetSum(arr, n, sum/2) be the function that returns true if 
there is a subset of arr[0..n-1] with sum equal to sum/2

The isSubsetSum problem can be divided into two subproblems
 a) isSubsetSum() without considering last element 
    (reducing n to n-1)
 b) isSubsetSum considering the last element 
    (reducing sum/2 by arr[n-1] and n to n-1)
If any of the above the above subproblems return true, then return true. 
isSubsetSum (arr, n, sum/2) = isSubsetSum (arr, n-1, sum/2) ||
                              isSubsetSum (arr, n-1, sum/2 - arr[n-1])
 */

public class PartitionEqualSubsetSum {

	 public boolean canPartition(int[] nums){
		 
		 if(nums==null || nums.length<2){
			 return false;
		 }
		 
		 int sum = 0;
		 
		 for(int i=0;i<nums.length;i++){
			 sum = sum + nums[i];
		 }
		 
		 if((sum%2)!=0){
			 return false;
		 }
		 
		 sum = sum/2;
		 
		 boolean[][] dp = new boolean[nums.length+1][sum+1];
		 
		 dp[0][0] = true;
		 for(int i=1 ; i<=nums.length;i++){
			 dp[i][0] = true;
		 }
		 
		 for(int i=1;i<=sum;i++){
			 dp[0][i] = false;
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

		//int[] nums = {1, 5, 11, 5};
		int[] nums = {1, 2, 3, 5};
		
		PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
		System.out.println(obj.canPartition(nums));
	}

}
