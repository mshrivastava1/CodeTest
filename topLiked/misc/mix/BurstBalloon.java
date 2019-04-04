package mix;

public class BurstBalloon {

	int result = 0;
	public int maxCoins(int[] nums) {

		
		if(nums==null || nums.length==0){
			return result;
		}
		
		int[][] dp = new int[nums.length][nums.length];
		return findMaxCoin(nums, 0, nums.length-1, dp);
		
		//return result;
	}
	
	
	private int findMaxCoin(int[] nums, int start, int end, int[][] dp) {
		
		if(start>end){
			return 0;
		}
		
		if(dp[start][end]!=0){
			return dp[start][end];
		}
		
		int max = dp[start][end];
		for(int i=start;i<=end;i++){
			int current = findMaxCoin(nums, start, i-1, dp) + get(nums,start-1)*get(nums,i)*get(nums,end+1) + findMaxCoin(nums, i+1, end, dp);
			
			max = Math.max(current, max);
		}
		
		dp[start][end] = max;
		
		return max;
	}

	public int get(int[] nums, int i){
		
		 if (i == -1 || i == nums.length) {
		        return 1;
		    }
		
		return nums[i];
	}

	public static void main(String[] arg){
		
		int[] nums = {3,1,5,8};
		
		BurstBalloon obj  = new BurstBalloon();
		
		System.out.println(obj.maxCoins(nums));
	}
}
