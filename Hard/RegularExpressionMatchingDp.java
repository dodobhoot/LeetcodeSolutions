class Solution {
    int [][] dp;
    public boolean isMatch(String s, String p) {
        dp = new int[s.length() + 1][p.length() + 1];
        for(int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        
        return solve(0, 0, s, p);
    }
    
    public boolean solve(int i, int j, String s, String p){
        if(dp[i][j] != -1)
            return dp[i][j] == 1;
        
        if(j == p.length()){
            dp[i][j] = (i == s.length()) ? 1 : 0;
            return dp[i][j] == 1;
        }
        
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            boolean ans = solve(i, j + 2, s, p) || (firstMatch && solve(i + 1, j, s, p));
            dp[i][j] = ans ? 1 : 0;
            return ans;
        }
        
        boolean ans = firstMatch && solve(i + 1, j + 1, s, p);
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}