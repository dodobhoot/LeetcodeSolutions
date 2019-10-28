class Solution {
    
    static final int[] dx = new int[]{1, 0, -1, 0};
    static final int[] dy = new int[]{0, -1, 0, 1};
    
    int dp[][];
    
    public int longestIncreasingPath(int[][] matrix) {
        
        if(matrix.length == 0)
            return 0;
        
        int res = 0;
        dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
            Arrays.fill(dp[i], -1);
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                res = Math.max(res, solve(matrix, i, j));
            }
        }
        return res;
    }
    
    public int solve(int[][] matrix, int i, int j){
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int ans = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int d = 0; d < dx.length; d++){
            int newi = i + dx[d];
            int newj = j + dy[d];
            
            if(newi >= 0 && newi < n && newj >= 0 && newj < m){
                if(matrix[newi][newj] > matrix[i][j]){
                    int oldVal = matrix[i][j];
                    matrix[i][j] = Integer.MIN_VALUE;
                    ans = Math.max(ans, 1 + solve(matrix, newi, newj));
                    matrix[i][j] = oldVal;
                }
            }
        }
        return dp[i][j] = ans;
    }
}