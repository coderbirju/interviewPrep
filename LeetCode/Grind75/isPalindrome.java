/* 

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.


*/



class Solution {
    public boolean isPalindrome(String s) {
        s = removeSymbols(s);
        s = s.toLowerCase();
        
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        
        return s.equals(reversed);
    }
    
    public String removeSymbols(String input) {
        String formatted = "";
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetterOrDigit(input.charAt(i))) {
                 formatted += input.charAt(i);  
            }
        }

        return formatted;
    }
}