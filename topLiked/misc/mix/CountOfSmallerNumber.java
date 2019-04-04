package mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumber {

	public List<Integer> countSmaller(int[] nums) {

		List<Integer> result = new ArrayList<Integer>();
		
		if(nums==null || nums.length==0){
			return result;
		}
		
		for(int i=0;i<nums.length;i++){
			int count = 0;
			
			for(int j=i+1;j<nums.length;j++){
				if(nums[j]<nums[i]){
					count++;
				}
			}
			
			result.add(count);
		}
		
		for(int i:result){
			System.out.print(i+" ");
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {5,2,6,1};
		
		CountOfSmallerNumber obj = new CountOfSmallerNumber();
		
		obj.countSmaller(nums);
		
	}

}
