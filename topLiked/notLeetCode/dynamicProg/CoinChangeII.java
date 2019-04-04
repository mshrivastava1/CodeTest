package dynamicProg;

//Find ways to get amount from the coins
public class CoinChangeII {

	public int findWays(int[] coins, int amount) {

		int count = 0;
		if (coins == null) {
			return count;
		}
		if (amount < 1) {
			return count;
		}

		int dp[] = new int[amount + 1];
		dp[0] = 1;

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] <= j) {
					dp[j] = dp[j] + dp[j - coins[i - 1]];
				}
			}
		}
		return dp[amount];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*int[] coins = { 1, 2, 3 };
		int amount = 4;*/
		
		/*int[] coins = {41,34, 46, 9, 37, 32, 42, 21, 7, 13, 1, 24, 3, 43, 2, 23, 8, 45, 19, 30, 29, 18, 35, 11};
		int amount = 250;*/
		
		int[] coins = {2,3,6,7};
		int amount = 7;

		CoinChangeII obj = new CoinChangeII();
		System.out.println(obj.findWays(coins, amount));
	}

}
