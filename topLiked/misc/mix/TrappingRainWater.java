package mix;

public class TrappingRainWater {

	public int trap(int[] height) {

		if(height==null || height.length<3){
			return 0;
		}
		
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		
		left[0] = height[0];
		
		for(int i=1;i<height.length;i++){
			left[i] = Math.max(left[i-1], height[i]);
		}
		
	/*	for(int i =0 ; i<height.length;i++){
			System.out.print(left[i]+" ");
		}*/
		right[height.length-1] = height[height.length-1];
		
		for(int i=height.length-2;i>=0;i--){
			right[i] = Math.max(right[i+1], height[i]);
		}
		
	/*	System.out.println("");
		for(int i =0 ; i<height.length;i++){
			System.out.print(right[i]+" ");
		}*/
		//System.out.println(right);
		
		int water = 0;
		
		for(int i=0;i<height.length;i++){
			water +=Math.min(left[i], right[i])-height[i];
			//System.out.println(water);
		}
		
		return water;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		TrappingRainWater water = new TrappingRainWater();
		
		System.out.println(water.trap(height));
	}

}
