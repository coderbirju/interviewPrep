class Solution {

public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    // if(remain < 0) return;
    // if(remain == 0) {
    //     list.add(new ArrayList<>(tempList));
    //     return;
    // }
    if (start == nums.length) {
        if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        }
        return;
    }
    
    if(nums[start] <= remain){
        tempList.add(nums[start]);
        backtrack(list, tempList, nums, remain - nums[start], start);
        tempList.remove(tempList.size() - 1);
    }
    backtrack(list, tempList, nums, remain, start+1);
    
    
    // else{ 
    //     for(int i = start; i < nums.length; i++){
    //         tempList.add(nums[i]);
    //         backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
    //         tempList.remove(tempList.size() - 1);
    //     }
    // }
}

}