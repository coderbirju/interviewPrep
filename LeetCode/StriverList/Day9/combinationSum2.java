class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        int n = candidates.length;
        recursiveCall(i, n, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
    
    void recursiveCall(int i, int n, int[] candidates, int remain, List<Integer> currArr, List<List<Integer>> ans){
        if(remain == 0){
            ans.add(new ArrayList(currArr));
            return;    
        }
        
        for(int j=i; j<n;j++){
            if(j>i && candidates[j] == candidates[j-1])
                continue;
            if(candidates[j] > remain)
                break;
            
            currArr.add(candidates[j]);
            recursiveCall(j+1,n,candidates,remain - candidates[j], currArr, ans);
            currArr.remove(currArr.size() -1);
        }
    }
}