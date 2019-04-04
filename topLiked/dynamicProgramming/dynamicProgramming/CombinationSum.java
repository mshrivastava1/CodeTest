package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Stack<Integer> stack = new Stack<Integer>();
		findCombinationSum(candidates,0,stack,target, result);
		return result;
	}

	private void findCombinationSum(int[] candidates, int index, Stack<Integer> stack,int target,List<List<Integer>> result ) {
		
		if(target<1){
			if(target==0){
				List<Integer> temp = new ArrayList<Integer>(stack);
				result.add(temp);	
			}
			return;
		}
		
		
		if(index == candidates.length){
			return;
		}
		
		for(int i = index;i<candidates.length;i++){
			stack.push(candidates[i]);
			findCombinationSum(candidates, i, stack, target - candidates[i], result);
			stack.pop();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] candidates = {2,3,6,7};
		int target = 7;
		
		CombinationSum obj = new CombinationSum();
		
		System.out.println(obj.combinationSum(candidates, target));

	}

}
