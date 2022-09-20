class Solution {
    public int threeSumClosest(int[] nums, int target) {
    int diff = Integer.MAX_VALUE;
    int sz = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < sz && diff != 0; ++i) {
        int lo = i + 1;
        int hi = sz - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (Math.abs(target - sum) < Math.abs(diff)) {
                diff = target - sum;
            }
            if (sum < target) {
                ++lo;
            } else {
                --hi;
            }
        }
    }a
    return target - diff;
    }
}