class Solution {
	//One Pass O(n) O(1)
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;//0
        for(int i = 0; i<prices.length; i++){
            if(minPrice>prices[i]){
                minPrice = prices[i];                
            }else{
                maxProfit = Math.max(maxProfit,prices[i]-minPrice);
            }
        }
        return maxProfit;
    }
}
//Brute Force O(n^2) O(1)
/*
public class Solution {
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }
}
*/