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
                
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                    // interval[1] >= newInterval[1] ? interval[1] : newInterval[1];
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