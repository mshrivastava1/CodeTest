package sorting;

public class SortColosQucikSort {

	 public void sortColors(int[] nums){
		 
		 quickSort(nums, 0, nums.length-1);
		 
	 }
	 
	 public void quickSort(int[] nums, int startIndex, int endIndex){
		 
		 if(startIndex<endIndex){
			 int pivot  = findPivot(nums, startIndex, endIndex);
			 
			 quickSort(nums, startIndex, pivot);
			 quickSort(nums, pivot+1, endIndex);
		 }
		
	 }
	 
	 public int findPivot(int[] nums, int start, int end){
		 
		 int pivot = (start + end)/2;
		 
		 swap(nums,pivot, end);
		// int startPoint = 0;
		 for(int i=start;i<=end;i++){
			 if(nums[i]<nums[end]){
				 swap(nums, start, i);
				 start++;
			 }
		 }
		 
		 swap(nums,start,end);
		 
		 return start;
	 }
	 
	 public void swap(int[] nums, int i, int j){
		 
		 int temp = nums[i];
		 nums[i] = nums[j];
		 nums[j] = temp;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,0,2,1,1,0};
		
		SortColosQucikSort obj = new SortColosQucikSort();
		
		obj.sortColors(nums);
		
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
	}

}
