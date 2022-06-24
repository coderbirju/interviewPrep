/**
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 */


class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0 || t.length() > s.length())
            return "";
        
        HashMap<Character, Integer> countT = new HashMap();
        HashMap<Character, Integer> window = new HashMap();
        
        for(char c: t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int have = 0;
        int need = countT.size();
        int[] res = new int[2];
        int resLen = s.length()+1;
        int l=0;
        res[0] = -1;
        res[1] = -1;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            window.put(c, window.getOrDefault(c,0) + 1);
            
            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                have++;
            }
            while(have == need){
                int curLen = i - l + 1;
                if(curLen < resLen){
                    resLen = curLen;
                    res[0] = l;
                    res[1] = i;
                }
                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                if(countT.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < countT.get(s.charAt(l))){
                    have -= 1;
                }
                l+=1;
            }
        }
        String result = resLen != (s.length()+1) ? s.substring(res[0], res[0] + resLen) : "";
        return result;
        
    }
}