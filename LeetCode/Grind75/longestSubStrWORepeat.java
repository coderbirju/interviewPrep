
/**
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

*/

/**
i-j+1 is the window size, and we try to find the largest size
if map.get(s.charAt(i))+1 < j, that means the last time we saw this char was outside of the window, so we don't count it.
"abbbba" is an example. 
At index 5, we saw 'a', the last time 'a' appeared at index 0. 
The valid window should be 'ba', i.e i=5 and j=4
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] characs = new int[256];
        int result = 0;
        for(int i=0, j=0;i<s.length();i++){
            j = (characs[s.charAt(i)] > 0) ? Math.max(j, characs[s.charAt(i)]) : j;
            characs[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}