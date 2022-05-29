
/*
*   409. Longest Palindrome
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Example 3:

Input: s = "bb"
Output: 2
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.

*/


class Solution {
    public int longestPalindrome(String s) {
        int[] alpha = new int[128]; // use this for case insensitive questions
        int odd = 0; // to count odd number of characters
        for(char c : s.toCharArray())
            alpha[c]++;
        for(int i : alpha){
            if(i%2 != 0)
                odd++;
        }
        // we can take all the even numbered characters but only one odd numbered character to build the longest palindrome
        // 
        int len = s.length();
        return odd == 0 ? len : len - odd + 1;
        
    }
}