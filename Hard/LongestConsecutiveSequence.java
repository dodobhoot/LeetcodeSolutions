class Solution {
    public int longestConsecutive(int[] nums) {
        
        int ans = 0;
        Set<Integer> values = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++)
            values.add(nums[i]);
        
        for(int value : values){
            if(values.contains(value - 1))
                continue;
            
            int curValue = value;
            int curAns = 1;
            while(values.contains(curValue + 1)){
                curValue++;
                curAns++;
            }
            ans = Math.max(ans, curAns);
        }
        return ans;
    }
}