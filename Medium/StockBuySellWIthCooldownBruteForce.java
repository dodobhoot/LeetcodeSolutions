class Solution {
    
    int profit;
    
    public int maxProfit(int[] prices) {
        solve(0, false, 0, 0, prices);
        return profit;
    }
    
    public int solve(int idx, boolean bought, int remCooldown, int curProfit, int[] prices){
        
        if(idx == prices.length){
            profit = Math.max(profit, curProfit);
            return curProfit;
        }
        
        int newProfit = Integer.MIN_VALUE;
        if(!bought){
            if(remCooldown == 0)
                newProfit = solve(idx + 1, true, 0, curProfit - prices[idx], prices);
            else
                newProfit = solve(idx + 1, false, 0, curProfit, prices);
        }else{
            newProfit = solve(idx + 1, false, 1, curProfit + prices[idx], prices);
        }
        
        newProfit = Math.max(newProfit, solve(idx + 1, bought, remCooldown, curProfit, prices));
        return newProfit;
    }
}