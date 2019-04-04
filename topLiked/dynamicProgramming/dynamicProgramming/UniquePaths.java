package dynamicProgramming;

public class UniquePaths {

	public int uniquePaths(int m, int n){
		
		int[][] dp = new int[m][n];
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				
				if(i==0 || j==0){
					dp[i][j] = 1;
				}else{
					dp[i][j] = dp[i][j-1] + dp[i-1][j];
				}
			}
		}
		
		return dp[m-1][n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int m = 7;
		int n = 3;
		
		
		UniquePaths obj = new UniquePaths();
		
		System.out.println(obj.uniquePaths(m, n));
	}

}
