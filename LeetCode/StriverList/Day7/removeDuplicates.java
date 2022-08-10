class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 1;
        int k = 1;
        int curElem = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] != curElem){
                nums[start] = nums[i];
                start++;
                curElem = nums[i];
                k++;
            }
        }
        return k;
    }
}