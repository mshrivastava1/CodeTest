package dynamicProgramming;

/*

Problem - Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (i.e., cooldown 1 day)

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]

Solution - This problem will be solved by using dynamic programming

On any i-th day, we can buy, sell or cooldown

Maintain two arrays buy[] and sell[]

buy[i] - Maximum profit if we made decision to either Buy or Cooldown.
 If we cooldown then the profit will be the same as of previous day i.e. buy[i-1] 
 If we buy the stock then the profit will be sell[i-2] + price(price of the stock)
 
 Decision of buying or cooling down will be made based on the maximum value of cooldown or buy profit
 buy[i] = max(buy[i-1],sell[i-2] - price) -> sell[i-2] = we can not buy if we sold on the previous day.
 
sell[i] - Maximum profit if we made decision to sell the stock or cooldown
if we cooldown then the profit will be the same of the previous day i.e. sell[i-1]
if we sell the stock then the profit will be , the profit on the day we had previous day + price of the sell i.e. buy[i-1]+price
 
 Decision of selling or cooldown depends on the maximum profit we can make
 sell[i] = max(buy[i-1]+price,sell[i-1])
 
 keeping in mind we will only make the profit if sell or cool down on the last day so return last day profit from sell array.

*/
public class BestTimeToBuySellStock {

	public int maxProfit(int[] prices) {

		if(prices == null || prices.length<2){
			return 0;
		}
		
		int[] buy = new int[prices.length+1];
		int[] sell = new int[prices.length+1];
		
		buy[1] = -prices[0];
		
		for(int i=2;i<buy.length;i++){
			int price = prices[i-1];
			
			buy[i] = Math.max(buy[i-1], sell[i-2]-price);
			sell[i] = Math.max(sell[i-1], buy[i-1]+price);
		}
		
		return sell[prices.length];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices = {1,2,3,0,2};
		
		BestTimeToBuySellStock obj = new BestTimeToBuySellStock();
		
		System.out.println(obj.maxProfit(prices));
	}

}
