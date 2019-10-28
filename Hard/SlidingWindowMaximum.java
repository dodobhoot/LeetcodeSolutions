class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums == null || nums.length == 0 || k > nums.length) 
            return new int[0];
        
        int[] res = new int[nums.length - k + 1];
        
        int ctr = 0;
        Deque<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < k; i++){
            
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.removeLast();
            
            q.addLast(i);
        }
        
        for(int i = k; i < nums.length; i++){
            
            res[ctr++] = nums[q.peekFirst()];
            
            while(!q.isEmpty() && q.peekFirst() <= i - k)
                q.removeFirst();
            
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.removeLast();
            
            q.addLast(i);
        }
        
        res[ctr] = nums[q.peekFirst()];
        return res;
    }
}