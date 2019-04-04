package dynamicProg;

public class MaximumSqaure {
	
	public int getMaximumSizeOfSqaure(int[][] M){
		
		if(M==null){
			return 0;
		}
		
		int[][] dp = new int[M.length+1][M[0].length+1];
		int maxSize = 0;
		for(int i=1;i<=M.length;i++){
			for(int j=1;j<=M[0].length;j++){
				if(M[i-1][j-1]==1){
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
					
					maxSize = Math.max(maxSize, dp[i][j]);
				}
			}
		}
		
		return maxSize;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] M = {{0, 1, 1, 0, 1},  
                {1, 1, 0, 1, 0},  
                {0, 1, 1, 1, 0}, 
                {1, 1, 1, 1, 0}, 
                {1, 1, 1, 1, 1}, 
                {0, 0, 0, 0, 0}};
		
		MaximumSqaure obj = new MaximumSqaure();
		
		System.out.println(obj.getMaximumSizeOfSqaure(M));
	}

}
