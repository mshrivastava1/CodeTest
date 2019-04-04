package dynamicProgramming;

public class CoinChange {

	public int coinChange(int[] coins, int amount){
		
		if(coins == null || coins.length<1){
			return -1;
		}
		
		int[] dp = new int[amount+1];
		
		for(int i=0;i<dp.length;i++){
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		
		for(int i=1;i<=amount;i++){
			for(int j=0;j<coins.length;j++){
				if(coins[j]<=i){
					int rem = dp[i-coins[j]];
					 if(rem!=Integer.MAX_VALUE && rem+1<dp[i]){
						 dp[i] = rem +1;
					 }
				}
			}
		}
		
		if(dp[amount]!=Integer.MAX_VALUE){
			return dp[amount];
		}
		
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] coins = {2};
		int amount = 3;
		
		CoinChange obj = new CoinChange();
		
		System.out.println(obj.coinChange(coins, amount));
	}

}
