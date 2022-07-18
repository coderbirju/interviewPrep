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