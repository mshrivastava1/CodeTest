package mix;

public class MaximumSumSubArray {
	
	public int maxSubArray(int[] nums) {
		
		if(nums.length<1){
			return -1;
		}
		
		int maxSum = Integer.MIN_VALUE;
		
		if(nums.length<2){
			return nums[0];
		}
		
		for(int i=0;i<nums.length;i++){
			int currentSum = nums[i];
			maxSum = Math.max(currentSum, maxSum);
			for(int j=i+1;j<nums.length;j++){
				currentSum +=nums[j];
				maxSum = Math.max(maxSum, currentSum);
			}
		}
		
		return maxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		
		MaximumSumSubArray obj = new MaximumSumSubArray();
		
		System.out.println(obj.maxSubArray(nums));
	}

}
