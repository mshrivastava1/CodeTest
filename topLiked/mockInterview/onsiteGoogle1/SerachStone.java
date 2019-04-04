package onsiteGoogle1;

public class SerachStone {

	public int removeStones(int[][] stones) {

		if(stones==null || stones.length==0){
			return 0;
		}
		
		int count = 0;
		for(int i=0;i<stones.length-1;i++){
			
			if(stones[i][0]!=0 &&(stones[i+1][0]==stones[i][0] || stones[i+1][1]==stones[i][0])){
				count++;
			}
			if(stones[i][1]!=0 &&(stones[i+1][0]==stones[i][1] || stones[i+1][1]==stones[i][1])){
				count ++;
			}
			if(stones[i][0]!=0 && stones[i][0]==stones[i][1]){
				count++;
			}
		}
		
		if(stones[stones.length-1][0]!=0 && stones[stones.length-1][0]==stones[stones.length-1][1]){
			count++;
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] stones = {{0,0},{0,2},{1,1},{2,0},{2,2}};
		
		SerachStone obj = new SerachStone();
		
		System.out.println(obj.removeStones(stones));
	}

}
