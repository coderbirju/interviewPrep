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

/*
* Idea: Check for palindrome on either sides considering current element as the center of the palindrome
    
    for odd sized elements left and right is same initially
    for even sized elements right is one more than ther left initialy
    update the current substring when the distance b/w left and right > previous palindromes length
 
*/

class Solution {
    public String longestPalindrome(String s) {
        int curMax = 0;
        String palSub = "";
        int len = s.length();
        int left = 0;
        int right = 0;
        for(int i=0;i<len;i++){
                 left = i;
                 right = i;
                while(left >= 0 && right< len && s.charAt(left) == s.charAt(right)){
                    int curLen = right - left + 1;
                    if(curLen > curMax){
                        palSub = s.substring(left,right+1);
                        curMax = curLen;
                    }
                    left--;
                    right++;
                }

                 left = i;
                 right = i+1;
                while(left >= 0 && right< len && s.charAt(left) == s.charAt(right)){
                    int curLen = right - left + 1;
                    if(curLen > curMax){
                        palSub = s.substring(left,right+1);
                        curMax = curLen;
                    }
                    left--;
                    right++;
                }
        }
        
        return palSub;
    }
}