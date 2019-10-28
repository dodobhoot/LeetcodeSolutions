class Solution {
    
    public boolean isPowerOfTwo(int n) {
        /*if(n > 0)
            return (n & n - 1) == 0 ? true : false;
        return false;*/
        return isPowerOfTwo2(n);
    }
    
    private boolean isPowerOfTwo2(int n){
        
        // n & -n keeps only righmost 1 set and resets rest
        // say n = 5, then -n = -5
        // n & -n = 0101 & 1011 = 0001
        // only the rightmost set bit of 5 remains in 0001
        
        if(n > 0)
            return (n & -n) == n ? true : false;
        return false;
    }
}