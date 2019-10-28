class Solution {
    
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        int m = nums2.length;
        int[] res = new int[k];
        
        for(int i = Math.max(0, k - m); i <= k && i <= n; i++){
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i));
                
            if(greater(candidate, 0, res, 0))
                res = candidate;
        }
        return res;
    }
    
    // Given two array of length m and n
    // Create maximum number of length k = m + n
    // Order of elements should be maintained
    public int[] merge(int[] nums1, int nums2[]){
        
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m + n];
        
        for(int i = 0, j = 0, r = 0; r < m + n; r++){
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }
    
    public boolean greater(int[] nums1, int i, int[] nums2, int j){
        while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]){
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    
    // Given one array of length n, create the maximum number of length k.
    // Order of elements should be maintained
    public int[] maxArray(int[] nums, int k){
        
        int n = nums.length;
        int[] res = new int[k];
        
        for (int i = 0, j = 0; i < n; i++){
            while (n - i + j > k && j > 0 && res[j - 1] < nums[i]) 
                j--;
            if (j < k)
                res[j++] = nums[i];
        }
        return res;
    }
    public int[] maxArraySlow(int[] nums, int k){
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < nums.length; i++){
            
            while((st.size() + nums.length - i) > k && !st.isEmpty() && st.peek() < nums[i])
                st.pop();
            
            if(st.size() < k)
                st.push(nums[i]);
        }
        
        // pushing values of stack to int[]
        int[] res = new int[k];
        int r = k - 1;
        while(!st.isEmpty())
            res[r--] = st.pop();
        return res;
    }
}