package mix;

public class SearchInRotatedArray {

	public int search(int[] nums, int target){
		
		int rotationPoint = findRotationPoint(nums,0,nums.length-1);
		
		if(target>=nums[0] && target<=nums[rotationPoint-1]){
			return binarySearch(nums, 0, rotationPoint-1, target);
		}else{
			return binarySearch(nums, rotationPoint, nums.length-1, target);
		}
		
		
	}
	
	public int binarySearch(int[] nums, int start, int end, int target){
		
		if(start>end){
			return -1;
		}
			int mid = (start+end)/2;
			
			if(nums[mid]==target){
				return mid;
			}
			
			if(target<=nums[mid]){
				return binarySearch(nums, start, mid, target);
			}else{
				return binarySearch(nums, mid+1, end, target);
			}

	}
	
	public int findRotationPoint(int[] nums, int start, int end){
		
		if(start<=end){
			
			if(nums[start]<=nums[end]){
				return start;
			}
			
			int mid = (start+end)/2;
			if(nums[mid]<nums[start]){
				return findRotationPoint(nums, start, mid);
			}else{
				return findRotationPoint(nums, mid+1, end);
			}
		}
		
		return start;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {4,5,6,7,0,1,2};
		
		int target = 6;
		
		SearchInRotatedArray obj = new SearchInRotatedArray();
		
		System.out.println(obj.search(nums, target));
	}

}
