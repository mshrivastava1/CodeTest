package mix;

import java.util.ArrayList;
import java.util.List;

public class MoveZeros {

	public void moveZeroes(int[] nums) {

		if(nums.length==0){
			return;
		}
		
		int[] temp = new int[nums.length];

		int start =0;
		for(int i=0; i<nums.length;i++){
			if(nums[i]!=0){
				temp[start]=nums[i];
				start++;
			}
		}
		
		for(int i=0;i<nums.length;i++){
			nums[i] = temp[i];
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {0,1,0,3,12};
		
		MoveZeros obj = new MoveZeros();
		
		obj.moveZeroes(nums);
	}

}
