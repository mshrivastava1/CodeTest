package mix;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {

		if(nums==null || nums.length<k){
			return new int[0];
		}
		
		Deque<Integer> queue = new LinkedList<Integer>();
		
		List<Integer> resultList = new ArrayList<Integer>();
		
		int i;
		
		for(i=0;i<k;i++){
			
			while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]){
				queue.removeLast();
			}
			
			queue.addLast(i);
		}
		for(;i<nums.length;i++){
			resultList.add(nums[queue.peek()]);
			
			while(!queue.isEmpty() && queue.peek()<=i-k){
				queue.removeFirst();
			}
			
			while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]){
				queue.removeLast();
			}
			
			queue.addLast(i);
		}
		
		if(!queue.isEmpty()){
			resultList.add(nums[queue.peek()]);
		}
		int[] result = new int[resultList.size()];

		for(int j=0;j<resultList.size();j++){
			System.out.println(resultList.get(j));
			result[j] = resultList.get(j);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] nums = {1,3,-1,-3,5,3,6,7};
		
		//int[] nums = {1,3,-1,-3,5,3,6,7};
		//int k = 3;
		
		//int[] nums = {1};
		//int k =1;
		
		int[] nums = {1,3,1,2,0,5};
		int k = 3;
		
		SlidingWindowMaximum obj = new SlidingWindowMaximum();
		
	obj.maxSlidingWindow(nums, k);
	}

}
