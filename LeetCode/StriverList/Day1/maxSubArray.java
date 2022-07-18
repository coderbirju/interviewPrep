class Solution {
    public int maxSubArray(int[] nums) {
        int maxSofar = 0;
        int globalMax = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            maxSofar += nums[i];
            globalMax = Math.max(globalMax, maxSofar);
            if(maxSofar < 0){
                maxSofar = 0;
            }
        }
        return globalMax;
    }
}
