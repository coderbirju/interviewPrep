/*
* Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109

*/


class Solution {
    public int majorityElement(int[] nums) {
        //Hash solution
        // Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        // //Hashtable<Integer, Integer> myMap = new Hashtable<Integer, Integer>();
        // int ret=0;
        // for (int num: nums) {
        //     if (!myMap.containsKey(num))
        //         myMap.put(num, 1);
        //     else
        //         myMap.put(num, myMap.get(num)+1);
        //     if (myMap.get(num)>nums.length/2) {
        //         ret = num;
        //         break;
        //     }
        // }
        // return ret;
        
        // Moore's Algorithm
        int count = 0;
        int ret = 0;
        for(int i=0; i<nums.length;i++){
            if(count == 0){
                ret = nums[i];
            }
            if(nums[i] == ret){
                count++;
            } else {
                count--;
            }
        }
        return ret;
    }
}