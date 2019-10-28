class Solution {
    public List<String> generateParenthesis(int n){
        List<String> ans = new ArrayList<>();
        solve(0, 0, 2*n, "", ans);
        return ans;
    }
    
    public void solve(int openBraces, int closeBraces, int n, String braces, List<String> ans) {
        if(openBraces + closeBraces == n){
            if(openBraces == closeBraces)
                ans.add(braces);
            return;
        }
        
        if(openBraces < n){
            String nBraces = braces + "(";
            solve(openBraces + 1, closeBraces, n, nBraces, ans);
        }
        
        if(closeBraces < openBraces){
            String nBraces = braces + ")";
            solve(openBraces, closeBraces + 1, n, nBraces, ans);
        }
    }
}