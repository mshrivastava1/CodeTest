package mockInterview;



public class FlowerProblem {

	public int kEmptySlots(int[] flowers, int k) {

		if (flowers == null || flowers.length == 0) {
			return -1;
		}
		
		int[] dp = new int[flowers.length];
		
		int numberOfFlower = 1;
		
		int result = -1;
		for(int i =1; i<flowers.length;i++){
			
			if(flowers[i]-flowers[i-1]==k+1){
				result =i;
				break;
			}
		}
		
		if(result == -1){
			return -1;
		}
		return result+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] flowers = {1,2,3,4,5,7,6};
		//int[] flowers = {1,2,3};
		int k = 1;
		
		FlowerProblem obj = new FlowerProblem();
		
		System.out.println(obj.kEmptySlots(flowers, k));
	}

}
