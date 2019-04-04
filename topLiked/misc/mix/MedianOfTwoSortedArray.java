package mix;

public class MedianOfTwoSortedArray {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if(nums1==null && nums2==null || (nums1.length==0 && nums2.length==0)){
			return 0.0;
		}
		
		if(nums1.length==0){
			int mid = nums2.length/2;
			if(nums2.length%2==0){
				return (nums2[mid-1]+nums2[mid])/2;
			}else{
				return nums2[mid];
			}
		}
		

		if(nums2.length==0){
			int mid = nums1.length/2;
			if(nums1.length%2==0){
				return (nums1[mid-1]+nums1[mid])/2;
			}else{
				return nums1[mid];
			}
		}
		
		if(nums1.length>nums2.length){
			return findMedianSortedArrays(nums2, nums1);
			
		}
		
		int x = nums1.length;
		int y = nums2.length;
		int low = 0;
		int high = x;
		
	
		while(low<=high){
			
			int partitionX = (low+high)/2;
			int partitionY = (x+y+1)/2 - partitionX;
			
			int maxLeftX = (partitionX==0)?Integer.MIN_VALUE:nums1[partitionX-1];
			int minRightX = (partitionX==x)?Integer.MAX_VALUE:nums1[partitionX];
			
			int maxLeftY = (partitionY==0)?Integer.MIN_VALUE:nums2[partitionY-1];
			int minRightY = (partitionY==y)?Integer.MAX_VALUE:nums2[partitionY];
			
			if(maxLeftX<=minRightY && maxLeftY<=minRightX){
				
				if((x+y)%2==0){
					return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				}else{
					return (double)(Math.max(maxLeftX,maxLeftY));
				}
			}
			else if(maxLeftX>minRightY){
				high = partitionX-1;
			}else{
				low = partitionX+1;
			}
			
		}
		
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		
		MedianOfTwoSortedArray obj = new MedianOfTwoSortedArray();
		
		System.out.println(obj.findMedianSortedArrays(nums1, nums2));
	}

}
