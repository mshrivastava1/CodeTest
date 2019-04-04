package depthFirstSearch;

public class NumberOfIslands {

	public int numIslands(char[][] grid) {
    
		if(grid.length == 0){
			return -1;
		}
		int[][] visited = new int[grid.length][grid[0].length];
		
		int numOfIslands = 0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				
				if(grid[i][j] == '1' && visited[i][j]!=1){
					
					checkNeighbours(grid, visited, i,j);
					numOfIslands +=1; 
				}
			}
		}
		
		return numOfIslands;
    }
	public void checkNeighbours(char[][] grid, int[][] visited, int rowIndex, int columnIndex) {

		int[] rows = {-1,0,0,1};
		int[] columns = {0,1,-1,0};
		
		visited[rowIndex][columnIndex] = 1;
		
		for(int i=0;i<4;i++){
			if(checkIfPartOfIsland(grid, visited, rowIndex + rows[i], columnIndex + columns[i])){
				checkNeighbours(grid, visited, rowIndex + rows[i], columnIndex + columns[i]);
			}
		}
		
	}
	public boolean checkIfPartOfIsland(char[][] grid, int[][] visited, int i, int j) {
	
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0' || visited[i][j]==1){
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] grid =  new char[][]	{{'1', '1', '1', '1', '0'},
			{'1', '1', '0', '1', '0'},
			{'0', '1', '1', '1', '0'},
			{'1', '1', '0', '0', '0'},
			{'0', '0', '0', '0', '0'}};
			
			NumberOfIslands obj = new NumberOfIslands();
			
			System.out.println(obj.numIslands(grid));
			
	}

}
