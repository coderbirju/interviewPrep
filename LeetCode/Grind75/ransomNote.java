/*
* Given two strings ransomNote and magazine, 
return true if ransomNote can be constructed from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.


*/




class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphaB = new int[26];
        int len1 = magazine.length();
        int len2 = ransomNote.length();
        if(len2 > len1){
            return false;
        }
        
        for(int i=0; i<26;i++){
            alphaB[i] = 0;
        }
        
        
        for(int i=0; i<len1;i++){
            int index = magazine.charAt(i) - 'a';
            alphaB[index]++;
        }
        
        for(int i=0; i<len2;i++){
            int index = ransomNote.charAt(i) - 'a';
            if(alphaB[index] == 0){
                return false;
            } else{
                alphaB[index]--;
            }
        }
        return true;
        
    }
}