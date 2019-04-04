package mix;

public class WordSearch {

	public boolean exist(char[][] board, String word){
		
		if(word==null || word.isEmpty()){
			return false;
		}
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(dfsHelper(board, 0, i,j,word)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public boolean dfsHelper(char[][] board, int index, int i, int j, String word) {

		if(i<0 || j<0 || i>=board.length || j>=board[0].length){
			return false;
		}
		
		if(board[i][j]==word.charAt(index)){
			char temp = word.charAt(index);
			board[i][j] = '#';
			
			if(index == word.length()-1){
				return true;
			}else if(dfsHelper(board, index+1, i+1, j, word) || dfsHelper(board, index, i-1, j, word) || dfsHelper(board, index+1, i, j+1, word)||dfsHelper(board, index+1, i, j-1, word)){
				return true;
			}
			board[i][j] = temp;
		}
		return false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] board = {{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}};
		
		String word = "ABCCED";
		
		WordSearch obj = new WordSearch();
		
		System.out.println(obj.exist(board, word));
	}

}
