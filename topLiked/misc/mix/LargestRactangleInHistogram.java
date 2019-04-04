package mix;

import java.util.Stack;

public class LargestRactangleInHistogram {

	 public int largestRectangleArea(int[] heights) {
	        
		 if(heights==null || heights.length==0){
			 return 0;
		 }
	        int i = 0;
	        
	        Stack<Integer> stack = new Stack<Integer>();
	        
	        int maxArea = 0;
	        
	        while(i<heights.length){
	        	if(stack.isEmpty() || (heights[stack.peek()]<=heights[i])){
	        		stack.push(i++);
	        	}else{
	        		
	        		int top = stack.peek();
	        		stack.pop();
	        		int area = heights[top] * i;
	        		
	        		if(!stack.isEmpty()){
	        			area = heights[top] * (i-stack.peek()-1);
	        		}
	        		maxArea = Math.max(maxArea, area);
	        	}
	        }
	        
	        while(!stack.isEmpty()){
	        	int top = stack.peek();
	        	stack.pop();
	        	int area = heights[top] * i;
        		
        		if(!stack.isEmpty()){
        			area = heights[top] * (i-stack.peek()-1);
        		}
        		maxArea = Math.max(maxArea, area);
	        }
	        
	        return maxArea;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] heights = {2,1,5,6,2,3};
		
		LargestRactangleInHistogram obj = new LargestRactangleInHistogram();
		
		System.out.println(obj.largestRectangleArea(heights));
	}

}
