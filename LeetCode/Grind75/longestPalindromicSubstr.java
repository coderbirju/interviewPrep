/*
*
Given a string s, return the longest palindromic substring in s.
Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */

/**
    for each element
    - consider it the center element
    - if left of it and right of it is same increase the length
    - do it for both odd and even sized elements
 */

class Solution {
    public String longestPalindrome(String s) {
        String lps = "";
        int left;
        int right;
        if(s.length() == 0)
            return lps;
        for(int i=0;i<s.length();i++){
                left = i;
                right = i;
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    int curSize = right - left + 1;
                    if(lps.length()<curSize){
                        lps = s.substring(left,right+1);
                    }
                    left--;
                    right++;
                }
                left = i;
                right = i+1;
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    int curSize = right - left + 1;
                    if(lps.length()<curSize){
                        lps = s.substring(left,right+1);
                    }
                    left--;
                    right++;
                }
        }
        return lps;

    }
}