package mix;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {

		List<String> result = new ArrayList<String>();
		
		if(nums==null || nums.length==0){
			return result;
		} 
		int i = 0;
		while(i<nums.length){
			
			int j = i;
			while((j+1)<nums.length && nums[j+1]==nums[j]+1){
				j++;
			}
			if(j!=i){
				result.add(nums[i]+"->"+nums[j]);
				i=j+1;
			}else{
				result.add(String.valueOf(nums[i]));
				i++;
			}
		}
		
		for(String s:result){
			System.out.print(s+" ");
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {0,1,2,4,5,7};
		
		SummaryRanges obj = new SummaryRanges();
		
		obj.summaryRanges(nums);
		
	}

}
