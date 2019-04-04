package dynamicProgramming;

public class TargetSum {

	public int findTargetSum(int[] nums, int S){
		
		if(nums == null || nums.length<1){
			return -1;
		}
		
		int count = waysToGetTargetSum(nums,0,0,S);
		
		return count;
	}
	private int waysToGetTargetSum(int[] nums, int currentSum, int index, int S) {
		
		if(index == nums.length){
			return currentSum == S ? 1:0;
		}
		
		int positiveNumberCount = waysToGetTargetSum(nums, currentSum + nums[index], index+1, S);
		int negativeNumberCount = waysToGetTargetSum(nums, currentSum - nums[index], index+1, S);
		return positiveNumberCount + negativeNumberCount;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1, 1, 1, 1, 1};
		int S = 3;
		
		TargetSum obj = new TargetSum();
		
		System.out.println(obj.findTargetSum(nums, S));
	}

}
