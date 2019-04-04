package dynamicProgramming;

public class MinimumPathSum {
	
	 public int minPathSum(int[][] grid) {
		 
		 	if(grid.length<0){
		 		return -1;
		 	}
	        int[][] dp = new int[grid.length][grid[0].length];
	        
	        dp[0][0] = grid[0][0];
	        
	        if(grid.length>1){
	        	for(int i=1;i<grid.length;i++){
		        	dp[i][0] = dp[i-1][0] + grid[i][0];
		        }
	        }
	        
	        if(grid[0].length>1){
	        	for(int i=1;i<grid[0].length;i++){
		        	dp[0][i] = dp[0][i-1] + grid[0][i];
		        }
	        }
	        
	        
	        if(grid.length>1 && grid[0].length>1){
	        	for(int i=1;i<grid.length;i++){
		        	for(int j=1;j<grid[0].length;j++){
		        		dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
		        	}
		        }
		       
	        }
	        
	        return dp[grid.length-1][grid[0].length-1];
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] grid = { {1,2,5},
				  {3,2,1}};
		
		MinimumPathSum obj = new MinimumPathSum();
		
		System.out.println(obj.minPathSum(grid));
	}

}
