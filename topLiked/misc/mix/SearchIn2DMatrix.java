package mix;

public class SearchIn2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {

		if(matrix==null || matrix.length==0 || matrix[0].length==0){
			return false;
		}
		
		int i = 0;
		int j = matrix[0].length-1;
		
		return dfsUtil(matrix, target, i, j);
	}
	
	public boolean dfsUtil(int[][] matrix, int target, int row, int column){
		
		if(row>=matrix.length||column>=matrix[0].length || row<0||column<0){
			return false;
		}
		
		boolean result1 = false;
		boolean result2 = false;
		if(matrix[row][column]==target){
			return true;
		}else{
			if(matrix[row][column]>target){
				result1 = dfsUtil(matrix, target, row, column-1);
			}else{
				result2 = dfsUtil(matrix,target,row+1,column);
			}
		}
		
		return result1||result2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}};
		
		//int[][] matrix = {{-5}};
		
		int target = 5;
		
		SearchIn2DMatrix obj = new SearchIn2DMatrix();
		
		System.out.println(obj.searchMatrix(matrix, target));
	}

}
