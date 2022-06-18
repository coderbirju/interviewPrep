



/*
* Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

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

// one pass

class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int n = nums.length -1;
        int end = n;
        int index =0;
        // int p1 = 0, p2 = nums.length - 1, index = 0;
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



// two pass
class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            switch(nums[i]){
                case 0: zeros++;
                    break;
                case 1: ones++;
                    break;
                case 2: twos++;
                    break;
                default: break;
            }
        }
        for(int i=0;i<n;i++){
            if(i<zeros){
                nums[i] = 0;
            }else if(i>=(zeros+ones)){
                nums[i] = 2;
            }else{
                nums[i] = 1;
            }
        }
        return;
    }
}