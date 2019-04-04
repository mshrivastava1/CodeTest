package mix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FindKFrequentElements {
	
	public List<Integer> topKFrequent(int[] nums, int k){
		
		List<Integer> result = new ArrayList<Integer>();
		
		if(nums.length == 0 || k==0){
			return result;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0;i<nums.length;i++){
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->map.get(o2) - map.get(o1));
		
		for(int num: map.keySet()){
			queue.add(num);
		}
		
		for(int i=0;i<k;i++){
			result.add(queue.poll());
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,1,1,2,2,3,3,3,3};
		int k = 2;
		
		FindKFrequentElements obj = new FindKFrequentElements();
		
		System.out.println(obj.topKFrequent(nums, k));

	}

}
