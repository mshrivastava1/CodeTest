package mix;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {

	/*	if(nums==null || nums.length<1){
			return null;
		}
		
		int product = 1;
		for(int i=0;i<nums.length;i++){
			product = product*nums[i];
		}
		
		
		int[] result = new int[nums.length];
		
		for(int i=0;i<nums.length;i++){
			result[i] = product/nums[i];
		}
		
		return result;*/
		
		
		int[] result = new int[nums.length];
		
		int temp = 1;
		
		for(int i=0;i<nums.length;i++){
			result[i] = temp;
			temp *=nums[i];
		}
		
		temp = 1;
		
		for(int i=nums.length-1;i>=0;i--){
			result[i] *=temp;
			temp*= nums[i];
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,3,4};
		
		ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
		
		int[] result = obj.productExceptSelf(nums);
		
		for(int num: result){
			System.out.print(num + " ");
		}
	}

}
