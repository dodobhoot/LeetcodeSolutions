class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        
        long[] prefixSum = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        
        return mergeSort(prefixSum, 0, nums.length, lower, upper);
    }
    
    public int mergeSort(long[] arr, int low, int high, int lower, int upper){
        
        if(low >= high) 
             return 0;
        
        int mid = (low + high) / 2;
        int count = mergeSort(arr, low, mid, lower, upper) + mergeSort(arr, mid + 1, high, lower, upper);
        return count + merge(arr, low, mid, high, lower, upper);
    }
    
    public int merge(long[] arr, int low, int mid, int high, int lower, int upper){
        
        int j = mid + 1, k = mid + 1, t = mid + 1;
        int count = 0;
        long[] cache = new long[high - low + 1];
        
        for(int i = low, r = 0; i <= mid; ++i, ++r){
            while(k <= high && arr[k] - arr[i] < lower) 
                k++;
            while(j <= high && arr[j] - arr[i] <= upper) 
                j++;
            while(t <= high && arr[t] < arr[i])
                cache[r++] = arr[t++];
            
            cache[r] = arr[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, arr, low, t - low);
        return count;
    }
}