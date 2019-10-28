class Solution {
    public String shortestPalindrome(String s) {
        int reqLength = 0;
        for(int i = 0; i < s.length(); i++){
            if(isPalindrome(s.substring(0, s.length() - i))){
                reqLength = i;
                break;
            }
        }
        
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i < reqLength; i++){
            ans.append(s.charAt(s.length() - i - 1));
        }
        
        ans.append(s);
        return ans.toString();
    }
    
    public boolean isPalindrome(String s){
        int len = s.length();
        for(int i = 0; i < len/2; i++){
            if(s.charAt(i) != s.charAt(len - i - 1))
                return false;
        }
        return true;
    }
}