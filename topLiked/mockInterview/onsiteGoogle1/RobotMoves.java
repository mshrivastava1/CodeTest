package onsiteGoogle1;


class Position{
	int x;
	int y;
	
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class RobotMoves {

	public boolean judgeCircle(String moves) {

		if(moves==null || moves.isEmpty()){
			return true;
		}
		
		Position position = new Position(0, 0);
		
		for(char c:moves.toCharArray()){
			
			if(c=='L'){
				position.x = position.x-1;
			}else if(c=='R'){
				position.x = position.x+1;
			}else if(c=='U'){
				position.y = position.y+1;
			}else if(c=='D'){
				position.y = position.y-1;
			}
		}
		
		if(position.x==0 && position.y==0){
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String moves = "UL";
		
		RobotMoves obj = new RobotMoves();
		
		System.out.println(obj.judgeCircle(moves));
	}

}
