package dynamicProg;

public class KnapsackProblem {

	public int findMaximumProfit(int[] weights, int[] values, int target){
		
		int count = 0;
		
		if(target==0){
			return 1;
		}
		
		if(weights==null || values==null){
			return count;
		}
		
		int[][] dp = new int[weights.length+1][target+1];
		
		for(int i=1;i<=weights.length;i++){
			
			for(int j=1;j<=target;j++){
				if(j>=weights[i-1]){
					dp[i][j] = values[i-1] + dp[i-1][j-weights[i-1]];
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
				}
				
			}
		}
		
		return dp[weights.length][target];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*int[] weights = {10,20,30};
		int[] values = {60,100,120};*/
		
		int[] weights = {4,2,3};
		int[] values = {10,4,7};
		
		int target = 5;
		
		KnapsackProblem obj = new KnapsackProblem();
		
		System.out.println(obj.findMaximumProfit(weights, values, target));
	}

}
