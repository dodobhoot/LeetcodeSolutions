/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval first, Interval second){
                if(first.start == second.start){
                    return first.end - second.end;
                }
                return first.start - second.start;
            }
        });
        
        LinkedList<Interval> merged = new LinkedList<>();
        for(Interval interval : intervals){
            if(merged.isEmpty() || merged.getLast().end < interval.start){
                merged.add(interval);
                continue;
            }
            merged.getLast().end = Math.max(interval.end, merged.getLast().end);
        }
        return merged;
    }
}