/*
*Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

 */


class Solution {
    
    public void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int[] nums){
        result.add(new ArrayList(tempList));
        for(int i=start; i<nums.length;i++){
            tempList.add(nums[i]);
            backtrack(result,tempList,i+1,nums);
            tempList.remove(tempList.size()-1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(result,tempList,0,nums);
        return result;
    }
}