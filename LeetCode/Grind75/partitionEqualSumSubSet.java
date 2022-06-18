/* https://leetcode.com/problems/partition-equal-subset-sum/discuss/90592/01-knapsack-detailed-explanation


Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100

*/
class Solution {
    
    HashMap<String,Boolean> map;
    
    /*
    [1,5,11,5]
    [1,5,5,11]
    [1,6,11,22]
    
    0/1 knapsack problem : we have a target (total/number of sets) and we have an array of weights, 
    so it becomes a knapsack problem, where we have a choice to include or exclude a given element
    if atlease 1 solution exists return true.
    
    since number of sets = 2 the sum will have to be even and if the sum is odd partition cannot be made
    
    */
    
    public boolean knapSack(int[] nums, int pos, int sum, int target){
        String currentKey = pos + "" + sum;
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        if(target == sum)
            return true;
        if(sum > target || pos > nums.length-1){
            // System.out.println("pos "+pos+" sum "+sum+" target "+target);
            return false;
        }
        boolean result = knapSack(nums, pos+1, sum, target) || knapSack(nums, pos+1, sum + nums[pos], target);
        map.put(currentKey,result);
        return result;
    }
    
    public boolean canPartition(int[] nums) {
        map = new HashMap<>();
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum = sum + nums[i];
        }
        
        if((sum % 2) != 0){
            // System.out.println("Line 34");
            return false;
        }
            
        
        int target = sum/2;
        return knapSack(nums, 0, 0, target);
        
    }
}


//         Arrays.sort(nums);
//         int s = 0;
//         int e = nums.length -1;
//         int n = nums.length;
//         int[] leftArray = new int[n];
//         int[] rightArray = new int[n];
        
//         rightArray[e] = nums[e];
//         leftArray[0] = nums[0];
        
//         for(int i=1;i<n;i++){
//             leftArray[i] = leftArray[i-1] + nums[i];
//         }
//         if(leftArray[n-1]%2 == 1)
//             return false;
//         for(int i=n-2;i>=0;i--){
//             rightArray[i] = rightArray[i+1] + nums[i];
//         }
        
//         while(s<e){
//             if(leftArray[s] < rightArray[e])
//                 s++;
//             if(rightArray[e] < leftArray[s])
//                 e--;
//             if(rightArray[e]==leftArray[s])
//                 return true;
//         }
        
//         return false;