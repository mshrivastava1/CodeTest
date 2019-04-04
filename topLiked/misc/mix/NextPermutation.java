package mix;

import java.util.Arrays;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		
		if(nums.length<=1){
			return;
		}
		
		int i = nums.length-1;
		
		for(;i>=0;i++){
			if(nums[i-1]<nums[i]){
				break;
			}
		}
		
		if(i!=0){
			swap(nums,i-1);
		}
		
		reverse(nums,i);
		
		for(int num:nums){
			System.out.print(num+" ");
		}
	}
	
	
	public void swap(int[] nums, int i){
		
		for(int j=nums.length-1;j>i;j--){
			if(nums[j]>nums[i]){
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				return;
			}
		}
	}

	public void reverse(int[] nums, int i){
		
		int start = i;
		int end = nums.length-1;
		
		while(start<end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			
			start++;
			end--;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 1, 1, 5 };

		NextPermutation obj = new NextPermutation();

		obj.nextPermutation(nums);
	}

}
