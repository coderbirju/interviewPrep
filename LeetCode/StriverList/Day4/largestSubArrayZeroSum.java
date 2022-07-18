`/**
Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
-1000 <= A[i] <= 1000, for each valid i


 */


int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int lsum = 0;
        int maxLen = 0;
        for(int i=0;i<n;i++){
            lsum += arr[i];
            if(lsum == 0){
                maxLen = i+1;
            } else {
                if(map.get(lsum) != null){
                    int prevIndex = map.get(lsum);
                    maxLen = Math.max(maxLen, i - prevIndex);
                } else {
                    map.put(lsum,i);
                }
            }
        }
        return maxLen;
    }