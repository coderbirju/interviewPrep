/**
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hp.containsKey(nums[i])){
                return true;
            }
            hp.put(nums[i],1);
        }
        return false;
    }
}