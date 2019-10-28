class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        
        List<int[]> result = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        
        for(int[] building : buildings){
            heights.add(new int[]{building[0], -building[2]});  // starting edge of building
            heights.add(new int[]{building[1], building[2]});   // ending edge of building
        }
        
        Collections.sort(heights, new Comparator<int[]>(){
            public int compare(int[] first, int[] second){
                if(first[0] == second[0])
                    return first[1] - second[1];
                return first[0] - second[0];
            }
        });
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int prev = 0;
        
        for(int[] height : heights){
            if(height[1] < 0)
                pq.add(-height[1]);
            else
                pq.remove(height[1]);
            
            int cur = pq.peek();
            if(cur != prev){
                result.add(new int[]{height[0], cur});
                prev = cur;
            }
        }
        
        return result;
    }
}