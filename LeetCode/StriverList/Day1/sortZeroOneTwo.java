/*
*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 */

class Solution {
    public void sortColors(int[] nums) {
     /* 2 pass - find no of 1's and 2's an 0's and fill the narray with that many in order
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for(int i : nums){
            if(i==0)
                zeros++;
            else if(i==1)
                ones++;
            else
                twos++;
        }
        for(int i=0;i<nums.length;i++){
            if(i<zeros){
                nums[i] = 0;
            } else if(i>=zeros && i< (zeros + ones)){
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
        */
        
        /* 1Pass keep swapping the 0's and 2's whenever we encounter them using 2 pointer method, 1 is automatically sorted
        */
        
        int start = 0;
        int n = nums.length -1;
        int end = n;
        int index =0;
        while (index <= end) {
            if (nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
                index--;
            }
            index++;
        }
    }   
}