package dynamicProgramming;

public class ClimbStairs {

	public int climbStairs(int n) {

		int[] ways = new int[n + 1];

		ways[0] = 1;

		ways[1] = 1;

		for (int i = 2; i <= n; i++) {
			ways[i] = 0;
			for (int j = 1; j <= 2; j++) {
				ways[i] += ways[i - j];
			}
		}

		return ways[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 4;
		
		ClimbStairs obj = new ClimbStairs();
		System.out.println(obj.climbStairs(n));

	}

}
