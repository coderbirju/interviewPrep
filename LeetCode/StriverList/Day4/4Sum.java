
/**
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.


 */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target1) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;
        int n = nums.length;
        Arrays.sort(nums);
        long target = (long)target1;
        int max = nums[n - 1];
        
        for(int i=0;i<n;i++){
            long threeSumTarget = target - nums[i];
            for(int j=i+1;j<n;j++){
                long twoSumTarget = threeSumTarget - nums[j];
                int front = j+1;
                int back = n-1;
                while(front < back){
                    long sum = nums[front] + nums[back];
                    if(sum < twoSumTarget)
                        front++;
                    else if(sum > twoSumTarget)
                        back--;
                    else {
                        List<Integer> quad = new ArrayList();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        ans.add(quad);
                        // now make sure that ducplicates are skipped for front and back
                        while(front < back && nums[front] == quad.get(2))
                            front++;
                        while(front < back && nums[back] == quad.get(3))
                            back--;
                    }
                }
                // make sure the duplicates are skipped for j
                while(j<n-1 && nums[j+1] == nums[j])
                    ++j;
            }
            // make sure duplicates are skipped for i
            while(i<n-1 && nums[i+1] == nums[i])
                ++i;
        }
        return ans;
    }
}