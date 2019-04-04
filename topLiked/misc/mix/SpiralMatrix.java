package mix;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Spring;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<Integer>();
		
		if(matrix==null || matrix.length==0){
			return result;
		}
		
		int rowIndex = 0;
		int columnIndex = 0;
		
		int rows = matrix.length;
		int columns = matrix[0].length;
		
		while(rowIndex<rows && columnIndex<columns){
			
			for(int i=columnIndex;i<columns;i++){
				result.add(matrix[rowIndex][i]);
			}
			
			rowIndex++;
			
			for(int i=rowIndex;i<rows;i++){
				result.add(matrix[i][columns-1]);
			}
			columns--;
			
			if(rowIndex<rows){
				for(int i=columns-1;i>=columnIndex;i--){
					result.add(matrix[rows-1][i]);
				}
				
				rows--;
			}
			
			if(columnIndex<columns){
				for(int i=rows-1;i>=rowIndex;i--){
					result.add(matrix[i][columnIndex]);
				}
				columnIndex++;
			}
		}
		
		return result;
	}

	public static void main(String[] arg) {

		int[][] matrix = {{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }};
		
		SpiralMatrix obj = new SpiralMatrix();
		
		obj.spiralOrder(matrix);
	}
}
