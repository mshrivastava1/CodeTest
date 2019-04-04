package mix;

public class GameOfLife {

	//Future postions i.e. die - in future it will die but currently it is alive
	private int die = 2;
	private int live = 3;

	public void gameOfLife(int[][] board) {

		if(board==null || board.length==0){
			return;
		}
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				int liveNeighbours = findLiveNeighbours(board,i,j);
				
				if(board[i][j]==0 && liveNeighbours==3){
					board[i][j] = live;
				}else if(board[i][j]==1){
					if(liveNeighbours==2 || liveNeighbours==3){
						continue;
					}
					if(liveNeighbours<2 || liveNeighbours>3){
						board[i][j] = die;
					}
				}
			}
		}
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]==live){
					board[i][j] = 1;
				}
				if(board[i][j]==die){
					board[i][j] = 0;
				}
			}
		}
	}

	private int findLiveNeighbours(int[][] board, int i, int j) {

		int count = 0;
		int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
		
		for(int[] dir:dirs){
			int x = i + dir[0];
			int y = j + dir[1];
			
			if(x>=0 && y>=0 && x<board.length && y<board[i].length){
				if(board[x][y]==1 || board[x][y]==die){
					count++;
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

		GameOfLife obj = new GameOfLife();

		obj.gameOfLife(board);
	}

}
