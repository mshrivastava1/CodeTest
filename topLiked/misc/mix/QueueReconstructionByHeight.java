package mix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class QueueReconstructionByHeight {

	 public int[][] reconstructQueue(int[][] people){
		 
		 if(people==null){
			 return (new int[1][1]);
		 }
		 
		 PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			 public int compare(int[] p1, int[] p2){
				 if(p1[0]!=p2[0]){
					 return p2[0]-p1[0];
				 }
				 
				 return p1[1] - p2[1];
			 }
		});
		 
		 
		 for(int i=0;i<people.length;i++){
			 queue.offer(people[i]);
		 }
		 
		 List<int[]> result = new ArrayList<int[]>();
		 
		while(!queue.isEmpty()){
			int[] person = queue.poll();
	
			//add element at a particular index and shift the element which is already in the index 
			result.add(person[1],person);
		}
		
		return result.toArray(new int[][]{});
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		
		QueueReconstructionByHeight obj = new QueueReconstructionByHeight();
		
		int[][] result = obj.reconstructQueue(people);
		
		/*for(int i=0;i<result.length;i++){
			for(int j=0;j<result[0].length;j++){
				System.out.print(result[i][j]);
			}
			System.out.print(" ");
		}
*/	}

}
