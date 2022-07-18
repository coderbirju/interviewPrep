class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        int n = nums.length;
        int globalMax = 1;
        int curMax = 1;
        if(nums.length < 1 || nums == null)
            return 0;
        
        for(int i: nums)
            set.add(i);
        
        for(int i=0;i<n;i++){
            int curValue = nums[i];
            if(!set.contains(curValue - 1)) {
                curMax = 1;
                while(set.contains(curValue+1)){
                    curValue = curValue + 1;
                    curMax++;
                }
                globalMax = Math.max(globalMax, curMax);
            }
        }
        return globalMax;
    }
}


/*
    Brute force
    int globalMax = 1;
        int localMax = 1;
        if(nums.length < 1 || nums == null)
            return 0;
        Arrays.sort(nums);
        int prev = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] == prev+1){
                localMax++;
            }else if(nums[i] != prev) {
                localMax = 1;
            }
            prev = nums[i];
            globalMax = Math.max(localMax,globalMax);
        }
        return globalMax;
*/