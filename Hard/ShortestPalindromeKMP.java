class Solution {

    public String shortestPalindrome(String s) {
        StringBuilder rev = new StringBuilder(s);
        rev = rev.reverse();
        String newString = s + "#" + rev.toString();
        
        int[] lookup = KMPLookUp(newString);
        return rev.substring(0, s.length() - lookup[newString.length() - 1]) + s;
    }
    
    public int[] KMPLookUp(String str){
        int[] f = new int[str.length()];
        f[0] = 0;
        for(int i = 1; i < str.length(); i++){
            int temp = f[i - 1];
            while(temp > 0 && str.charAt(i) != str.charAt(temp))
                temp = f[temp - 1];
            if(str.charAt(i) == str.charAt(temp))
                temp++;
            f[i] = temp;
        }
        return f;
    }
}