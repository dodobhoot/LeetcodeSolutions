class Solution {
    
    int[][] dp;
    
    public int maxCoins(int[] nums) {
        
        int[] paddedNums = new int[nums.length + 2];
        int n = 1;
        for(int val : nums) 
            paddedNums[n++] = val;
        paddedNums[0] = paddedNums[n] = 1;
        
        dp = new int[paddedNums.length][paddedNums.length];
        for(int i = 0; i < paddedNums.length; i++)
            Arrays.fill(dp[i], -1);
        
        return solve(paddedNums, 0, paddedNums.length - 1);
    }
    
    public int solve(int[] nums, int low, int high){
        
        if(dp[low][high] != -1)
            return dp[low][high];
        
        int coins = 0;
        for(int i = low + 1; i < high; i++){
            int curCoins = nums[low] * nums[i] * nums[high] 
                + solve(nums, low, i) 
                + solve(nums, i, high);
            coins = Math.max(coins, curCoins);
        }
        return dp[low][high] = coins;
    }
}