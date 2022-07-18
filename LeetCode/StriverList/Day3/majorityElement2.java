
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        int count1 = 0,count2 = 0;
        int cand1 = -1, cand2 = -1;
        for(int i : nums){
            if(i == cand1){
                count1++;
            } else if(i == cand2){
                count2++;
            } else if(count1 == 0){
                cand1 = i;
                count1++;
            } else if(count2 == 0){
                cand2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        int len = nums.length;
        
        count1 = 0;
        count2 = 0;
        for(int i : nums){
            if(i == cand1){
                count1++;
            } else if(i == cand2){
                count2++;
            }
        }
        if(count1 > len/3)
            res.add(cand1);
        if(count2 > len/3)
            res.add(cand2);
        
        return res;
        
    }
}