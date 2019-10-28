// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)

class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length <= 1)
            return 0;
        
        int[] s0 = new int[prices.length];  // state reached when we are eligible to buy
        int[] s1 = new int[prices.length];  // state reached when we have bought
        int[] s2 = new int[prices.length];  // state reached when we have sold
        
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        
        for(int i = 1; i < prices.length; i++){
			s0[i] = Math.max(s0[i - 1], s2[i - 1]);
			s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
			s2[i] = s1[i - 1] + prices[i];
        }
        
        // max can be from rest or sell state
        // buying in the end can never yeild more profit
		return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
    }
}