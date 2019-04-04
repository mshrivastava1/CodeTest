package mix;

public class MaximumProductSubArray {

	public int maxProduct(int[] nums){
		
		int maxProduct = Integer.MIN_VALUE;
		
		for(int i=0;i<nums.length-1;i++){
			int currentProduct = nums[i];
			maxProduct = Math.max(maxProduct, currentProduct);
			
			for(int j=i+1;j<nums.length;j++){
				
				currentProduct = currentProduct * nums[j];
				maxProduct = Math.max(maxProduct, currentProduct);
			}
		}
		return maxProduct;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[] = {};
	}

}
