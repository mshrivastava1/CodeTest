package mix;

public class BuyAndSellStocks {

	public int maxProfit(int[] prices) {

		if(prices.length==0 || prices.length==1){
			return 0;
		}
		
		int maxDiff = 0;
		int soFarMin = prices[0];
		
		for(int i=1;i<prices.length;i++){
			if(prices[i]>soFarMin){
				maxDiff = Math.max(maxDiff, prices[i]-soFarMin);
			}else{
				soFarMin = prices[i];
			}
		}
		
		return maxDiff;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] prices = {7,1,5,3,6,4};
		int[] prices = {3,2,6,5,0,3};
		//int[] prices = {7,6,4,3,1};
		BuyAndSellStocks obj = new BuyAndSellStocks();
		
		System.out.println(obj.maxProfit(prices));
	}

}
