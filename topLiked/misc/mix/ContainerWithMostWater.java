package mix;

public class ContainerWithMostWater {

	public int maxArea(int[] height){
		
		if(height == null || height.length<1){
			return -1;
		}
		
		int left =0;
		int right = height.length-1;
		
		int maxArea = Integer.MIN_VALUE;
		
		while(left<right){
			
			int width = right - left;
			int area = 0;
			if(height[left]>height[right]){
				area = height[right]*width;
				right--;
			}else{
				area = height[left] * width;
				left++;
			}
			
			maxArea = Math.max(area, maxArea);
		}
		
		return maxArea;
	}
	public static void main(String[] args) {
		
		int[] height = {1,8,6,2,5,4,8,3,7};
		ContainerWithMostWater obj = new ContainerWithMostWater();
		
		System.out.println(obj.maxArea(height));
	}

}
