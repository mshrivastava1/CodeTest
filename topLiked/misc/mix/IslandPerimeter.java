package mix;

public class IslandPerimeter {

	public int islandPerimeter(int[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}
		int result = 0;

		for (int i = 0; i < grid.length; i++) {
			boolean[][] visited = new boolean[grid.length][grid[0].length];
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					result = dfs(grid, i, j, visited);
					return result;
				}
			}
		}
		return result;
	}

	private int dfs(int[][] grid, int i, int j, boolean[][] visited) {

		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j]==0) {
			return 0;
		}

		visited[i][j] = true;
		int thisPerimeter = 4;

		if (i + 1 < grid.length && grid[i + 1][j] == 1) {
			thisPerimeter--;
		}
		if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
			thisPerimeter--;
		}
		if (i - 1 >= 0 && grid[i - 1][j] == 1) {
			thisPerimeter--;
		}
		if (j - 1 >= 0 && grid[i][j - 1] == 1) {
			thisPerimeter--;
		}

		return thisPerimeter + dfs(grid, i + 1, j, visited) + dfs(grid, i - 1, j, visited)
				+ dfs(grid, i, j + 1, visited) + dfs(grid, i, j - 1, visited);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] grid = {{0,1,0,0},
				 {1,1,1,0},
				 {0,1,0,0},
				 {1,1,0,0}};
		
		IslandPerimeter obj = new IslandPerimeter();
		
		System.out.println(obj.islandPerimeter(grid));
	}

}
