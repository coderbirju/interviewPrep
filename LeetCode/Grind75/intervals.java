/*
* Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        /*
            - Sort the Array based on start times
            - initalize the first interval as the newInterval
            - for each interval 
                - check if the end time of newInterval is greater than the start time of the current interval
                - if true
                    - check that the end time of current interval is greater than the end time of newInterval
                    this ensures that incase the newInterval completely overlaps the current intefval we include 
                    it inside the new interval itself
                    - change the end time of newInterval accordingly
                - if false
                    - we have a seperated interval, current newInterval can be added to the result, so add it and now the next
                    interval to be check is from the current interval so set newInterval = current interval
            - once the loop is done we need to add the last newInterval, because we would'nt have added it in the loop
            - return the result array
        */
        
        Arrays.sort(intervals, (a1,a2) -> Integer.compare(a1[0], a2[0]));
        int[] newInterval = intervals[0];
        List<int[]> result = new ArrayList<>();
        int[][] finResult;
        for(int[] interval : intervals){
            if(interval[0] <= newInterval[1])
            {
                // check if the whole interval is inside this interval
                
                newInterval[1] = interval[1] >= newInterval[1] ? interval[1] : newInterval[1];
            } else {
                result.add(newInterval);
                newInterval = interval;
            }
        }
        result.add(newInterval);
        finResult = result.toArray(new int[result.size()][]);
        return finResult;
    }
}