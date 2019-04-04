package allPossibleSubSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllPossibleSubset {

	public List<List<Integer>> subsets(int[] nums){
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(nums.length==0){
			return result;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		finSubset(nums, stack, result, 0);
		
		return result;
	}
	
	public void finSubset(int[] nums, Stack<Integer> stack, List<List<Integer>> result, int startIndex){
		
		result.add(new ArrayList<>(stack));
		
		for(int i=startIndex; i<nums.length ;i++){
			stack.push(nums[i]);
			finSubset(nums, stack, result, i+1);
			stack.pop();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,3};
		
		AllPossibleSubset obj = new AllPossibleSubset();
		
		System.out.println(obj.subsets(nums));
	}

}
