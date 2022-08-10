class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int globalMax = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 1){
                globalMax = Math.max(count, globalMax);
                count = 0;
            } else {
                ++count;
            }
        }
        globalMax = Math.max(count, globalMax);
        return globalMax;
    }
}