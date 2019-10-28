class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> ans = new HashMap<>();
        int[] ret = new int[nums.length];
        
        int[] doublenums = new int[nums.length * 2];
        System.arraycopy(nums, 0, doublenums, 0, nums.length);
        System.arraycopy(nums, 0, doublenums, nums.length, nums.length);
        
        for(int i = 0; i < doublenums.length; i++){
            while(!st.isEmpty() && doublenums[st.peek()] < doublenums[i]){
                ans.put(st.pop(), doublenums[i]);
            }
            st.push(i);
        }
        
        for(int i = 0; i < nums.length; i++){
            ret[i] = ans.getOrDefault(i, -1);
        }
        
        return ret;
    }
}

// without extra space for double array
/*class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> ans = new HashMap<>();
        int n = nums.length;
        int[] ret = new int[n];
        
        for(int i = 0; i < 2 * n; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i % n]){
                ans.put(st.pop(), nums[i % n]);
            }
            st.push(i % n);
        }
        
        for(int i = 0; i < nums.length; i++){
            ret[i] = ans.getOrDefault(i, -1);
        }
        
        return ret;
    }
}*/