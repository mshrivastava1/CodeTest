package dynamicProgramming;

import java.util.Stack;

public class MaximumRactangle {

	public int maximalRectangle(char[][] matrix) {

		if(matrix==null || matrix.length==0){
			return 0;
		}
		
		int maxArea = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		
		for(int i=0;i<matrix[0].length;i++){
			if(matrix[0][i]=='1'){
				dp[0][i] = 1;
			}
		}
		
		/*for(int i=0;i<matrix[0].length;i++){
			if(matrix[0][i]=='1'){
				dp[0][i] = 1;
			}else{
				dp[0][i] = 0;
			}
		}*/
		
		maxArea = findAreaInHistogram(dp[0]);
		for(int i=1;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]=='1'){
					//System.out.println(matrix[i][j]-'0');
					dp[i][j] = matrix[i][j] -'0' +dp[i-1][j];
				}
			}
			
			maxArea = Math.max(maxArea, findAreaInHistogram(dp[i]));
		}
		
		return maxArea;
	}
	
	
	public int findAreaInHistogram(int[] array){
		
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while(i<array.length){
			if(stack.isEmpty() ||(!stack.isEmpty() && array[stack.peek()]<=array[i])){
				stack.push(i++);
			}else{
				int top = array[stack.peek()];
				stack.pop();
				int area = top*i;
				if(!stack.isEmpty()){
					area = top * (i-stack.peek()-1);
				}
				maxArea = Math.max(area, maxArea);
			}
		}
		
		while(!stack.isEmpty()){
			int top = array[stack.peek()];
			stack.pop();
			int area = top*i;
			if(!stack.isEmpty()){
				area = top * (i-stack.peek()-1);
			}
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] matrix = {{'1','0','1','0','0'},
				  {'1','0','1','1','1'},
				  {'1','1','1','1','1'},
				  {'1','0','0','1','0'}};
		
		MaximumRactangle obj = new MaximumRactangle();
		int[] heights = {3,1,3,2,2};
		System.out.println(obj.findAreaInHistogram(heights));
	}

}
