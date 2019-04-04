package others;


class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Ractangle{
	
	Point topLeft;
	Point bottonRight;
	
	Ractangle(Point left, Point right){
		this.topLeft = left;
		this.bottonRight = right;
	}
}
public class RactangleCollision {

	public Ractangle ractangle1;
	public Ractangle ractangle2;
	
	public RactangleCollision(Ractangle r1, Ractangle r2) {
		this.ractangle1 = r1;
		this.ractangle2 = r2;
	}
	
	public boolean isCollide(Ractangle r1, Ractangle r2){
		
		if(r1.topLeft.x>r2.bottonRight.x || r2.topLeft.x>r1.bottonRight.x || r1.bottonRight.y>r2.topLeft.y || r2.bottonRight.y>r1.topLeft.y){
			return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point topLeft1 = new Point(0, 10);
		Point bottomRight1 = new Point(10,0);
		Point topleft2 = new Point(5,5);
		Point bottomRight2 = new Point(15,0);
		
		Ractangle r1 = new Ractangle(topLeft1, bottomRight1);
		Ractangle r2 = new Ractangle(topleft2, bottomRight2);
		
		RactangleCollision obj = new RactangleCollision(r1, r2);
		
		System.out.println(obj.isCollide(r1, r2));
	}

}
