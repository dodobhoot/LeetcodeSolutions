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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> merged = new LinkedList<>();
        int i = 0;

        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            merged.add(intervals.get(i++));

        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        merged.add(newInterval); // add the union of intervals we got

        // add all the rest
        while (i < intervals.size())
            merged.add(intervals.get(i++)); 
        
        return merged;
    }
}