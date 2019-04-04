package dynamicProg;

public class JumpGame {

	public boolean canJum(int[] nums){
		
		if(nums==null){
			return false;
		}
		
		if(nums.length==1){
			return true;
		}
		
		boolean[] dp = new boolean[nums.length];
		
		dp[0] = true;
		
		for(int i=0;i<nums.length;i++){
			if(dp[i]){
				for(int j=1;j<=nums[i];j++){
					if(i+j<nums.length){
						dp[i+j] = true;
					}
				}
			}
		}
		
		return dp[nums.length-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {3,2,1,0,4};
		
		JumpGame obj = new JumpGame();
		
		System.out.println(obj.canJum(nums));
	}

}
