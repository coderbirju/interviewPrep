class Solution {
    public int reversePairs(int[] nums) {
        return enhancedMergeSort(nums, 0, nums.length - 1);
    }
    
    public int enhancedMergeSort(int[] nums, int start, int end){
        if(start >= end)
            return 0;
        int mid = start + (end - start)/2;
        int inv = enhancedMergeSort(nums, start, mid);
        inv += enhancedMergeSort(nums, mid+1, end);
        inv += merge(nums,start,mid,end);
        return inv;
    }
    
    public int merge(int[] nums, int low, int mid, int high){
        // this is where the count happens
        int count = 0;
        // start the j pointer to the left side tree
        int j = mid + 1;
        // move j to the right till nums[i] > (2*(long)nums[j]) is true or till j is over limits
        for(int i = low; i<= mid; i++){
            // i is tracing the left sub tree
            while(j<= high && nums[i] > (2*(long)nums[j]))
                j++;
            count += (j-(mid + 1));
            // adds count of all the elements satisfying the condition
        }
        // actual sorting happens here for the upper sub tree
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while(left<=mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else {
                temp.add(nums[right]);
                right++;
            }   
        }
        while(left<=mid)
            temp.add(nums[left++]);
        
        while(right <= high)
            temp.add(nums[right++]);
        
        for(int i=low; i<=high;i++){
            nums[i] = temp.get(i-low);
        }
        return count;
    }
}