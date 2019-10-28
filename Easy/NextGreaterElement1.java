class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> ans = new HashMap<>();
        
        for(int i = 0; i < nums2.length; i++){
            while(!st.isEmpty() && st.peek() < nums2[i]){
                ans.put(st.pop(), nums2[i]);
            }
            st.push(nums2[i]);
        }
        
        int[] ret = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            ret[i] = ans.getOrDefault(nums1[i], -1);
        }
        
        return ret;
    }
}