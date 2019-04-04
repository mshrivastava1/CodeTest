package onsiteGoogle1;

public class LongestIncreasingPathInMatirx {

	int result = 0;
	public int longestIncreasingPath(int[][] matrix) {

		if(matrix==null || matrix.length==0){
			return 0;
		}
		
		
		//int result = 0;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				boolean[][] visited = new boolean[matrix.length][matrix[0].length];
				dfs(matrix,i,j,0,visited);
			}
		}
		
		return result;
	}

	public void dfs(int[][] matrix, int i, int j, int currentCount,boolean[][] visited){
		
		if(i<0 || j<0 || i>matrix.length-1 || j>matrix[0].length){
			return;
		}
		
		result = Math.max(result, currentCount);
		visited[i][j] = true;
		
		if(i+1<matrix.length && matrix[i][j]<matrix[i+1][j] && !visited[i+1][j]){
			currentCount++;
			dfs(matrix, i+1, j, currentCount,visited);
		}
		if(i-1>=0 && matrix[i][j]<matrix[i-1][j] && !visited[i-1][j]){
			currentCount++;
			dfs(matrix, i-1, j, currentCount,visited);
		}
		if(j+1<matrix[i].length && matrix[i][j]<matrix[i][j+1] && !visited[i][j+1]){
			currentCount++;
			dfs(matrix, i, j+1, currentCount,visited);
		}
		if(j-1>=0 && matrix[i][j]<matrix[i][j-1] && !visited[i][j-1]){
			currentCount++;
			dfs(matrix, i, j-1, currentCount,visited);
		}
		
		visited[i][j] = false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {{9,9,4},
				  {6,6,8},
				  {2,1,1}};
		
		LongestIncreasingPathInMatirx obj = new LongestIncreasingPathInMatirx();
		
		System.out.println(obj.longestIncreasingPath(matrix));
	}

}
