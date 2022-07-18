class Solution {
    public void nextPermutation(int[] nums) {
        
        if(nums==null|| nums.length <= 0)
            return;
        int len = nums.length;
        int i = len - 2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        if(i>=0){
            int index = len - 1;
           while(nums[index] <= nums[i]){
                index--;
            }
            swap(index,i,nums);
        }
        reverse(i+1,len-1,nums);
    }
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int start, int end, int[] nums){
        while(start<end){
            swap(start++,end--,nums);
        }
    }
}