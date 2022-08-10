class Solution {
    // public HashSet<List<Integer>> visitedSubsets;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        int i=0;
        int n = nums.length;
        recursionSub(i,n,new ArrayList<>(), ans, nums, false);
        return ans;
    }
    
    void recursionSub(int i, int n, List<Integer> currentSelected, List<List<Integer>> powerSet, int[] nums, boolean choosePre){
        List<Integer> currentSub = currentSelected;
        if(i == n){
            powerSet.add(new ArrayList<>(currentSelected));
            return;
        }
        // System.out.println(nums[i]);
        recursionSub(i+1,n,currentSub, powerSet, nums, false);
        if(i>=1 && nums[i]==nums[i-1] && !choosePre) 
            return;
        currentSub.add(nums[i]);
        recursionSub(i+1,n,currentSub, powerSet, nums, true);
        currentSub.remove(currentSub.size()-1);
    }    
}