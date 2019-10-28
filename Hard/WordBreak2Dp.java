class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<Integer>[] prevIndex = new List[s.length() + 1];
        for(int i = 0; i < prevIndex.length; i++)
            prevIndex[i] = new ArrayList<Integer>();
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    prevIndex[i].add(j);
                    dp[i] = true;
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        generateResult(s.length(), s, "", res, prevIndex);
        return res;
    }
    
    public void generateResult(int pos, String s, String inter, List<String> res, List<Integer>[] prevIndex){
        
        if(pos == 0){
            res.add(inter.substring(1));
            return;
        }
        
        for(int i = 0; i < prevIndex[pos].size(); i++){
            int j = prevIndex[pos].get(i);
            String newInter = " " + s.substring(j, pos) + inter;
            generateResult(j, s, newInter, res, prevIndex);
        }
    }
}