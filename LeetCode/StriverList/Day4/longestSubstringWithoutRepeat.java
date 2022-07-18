class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0 || s == null)
            return 0;
        HashMap<Character,Integer> char_pos = new HashMap();
        int left = 0, right = 0;
        int maxSubString = 0;
        while(right < n){
            if(char_pos.get(s.charAt(right)) != null){
                // check wether the found position is in the range [left,right] only update left if it is, otherwise no need to update left
                left = Math.max(char_pos.get(s.charAt(right)) + 1, left);
            }
            char_pos.put(s.charAt(right),right);
            maxSubString = Math.max(maxSubString, (right - left) + 1);
            right++;
        }
        return maxSubString;
        
    }
}