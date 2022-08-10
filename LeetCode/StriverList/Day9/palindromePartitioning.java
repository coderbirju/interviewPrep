class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        int n = s.length();
        int i = 0;
        recursiveCall(i, n, s,new ArrayList<>(),ans);
        return ans;
    }
    
    void recursiveCall(int i, int n, String s, List<String> currArr, List<List<String>> ans){
        if(i == n){
            ans.add(new ArrayList(currArr));
            return;
        }
        
        for(int index = i; index<n;index++){
            if(isPalindrome(s,i,index)){
                String leftSub = s.substring(i, index+1);
                currArr.add(leftSub);
                recursiveCall(index+1,n,s, currArr, ans);
                currArr.remove(currArr.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}