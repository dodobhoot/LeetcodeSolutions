class NumArray {

    int[] prefixSum;
    public NumArray(int[] nums) {
        
        prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        
        for(int i = 0; i < nums.length; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];    
    }
    
    public int sumRange(int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }
}