package test;

public class P121 {

    class Solution {
        public int maxProfit(int[] prices) {
            int minProfit = 0;
            int minPrice = Integer.MAX_VALUE;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                } else if (minProfit < prices[i] - minPrice) {
                    minProfit = prices[i] - minPrice;
                }
            }
            return minProfit;
        }
    }
}
