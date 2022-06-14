class Solution {
    public int[] productExceptSelf(int[] nums) {
       /*
       build lefts and rights array 
       Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array 
       except 4 is 2*3*5 which consists of two              
       parts: left 2*3 and right 5. The product is left*right. 
       We can get lefts and rights:

        Numbers:     2    3    4     5
        Lefts:            2  2*3 2*3*4
        Rights:  3*4*5  4*5    5      
        Let’s fill the empty with 1:

        Numbers:     2    3    4     5
        Lefts:       1    2  2*3 2*3*4
        Rights:  3*4*5  4*5    5     1
        We can calculate lefts and rights in 2 loops. The time complexity is O(n).

        We store lefts in result array. If we allocate a new array for rights. 
        The space complexity is O(n). To make it O(1), we just need to store it in a 
        variable which is right.
       */
        
        int n= nums.length;
        int[] pdt = new int[n];
        
        pdt[0] = 1;
        int left = 1;
        for(int i=0;i<n;i++){
            if(i>0){
                left = left*nums[i-1];
            }
            pdt[i] = left;
        }
        int right = 1;
        for(int i = n-1;i>=0;i--){
            if(i<n-1){
                right = right*nums[i+1];
            }
            pdt[i] *= right;
        }
        return pdt;
    }
}

/*
Brute force
 int[] pdt = new int[nums.length];
        int tpdt = 1;
        for(int i: nums)
            tpdt *= i;
        for(int i=0;i<nums.length;i++){
            pdt[i] = tpdt/nums[i];
        }
        return pdt;
*/