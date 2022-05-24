/* 

*/

class Solution {
    public boolean isAnagram(String s, String t) {
       int[] alphabets = new int[26]; // set of all lowercase alphabets
        for(int i=0; i<26; i++){
            alphabets[i] = 0;
        } // set number of alphabets to 0
        int sLen = s.length();
        int tLen = t.length();
        if(sLen != tLen){
            return false;
        } // if lengths don't match then they're not anagrams
        
        for(int i=0;i<sLen;i++){
            int index = s.charAt(i) - 'a';
            alphabets[index]++;
        } // count frequency of each alphabet in the first string
        
        for(int i=0; i<tLen; i++){
            int index = t.charAt(i) - 'a';
            if(alphabets[index] == 0){ 
                /* 
                    if the alphabet in the second string
                    has never been visited or if the number of same 
                    alhpabets in both strings are different then \
                    they're not anagrams
                */
                return false;
            } else {
                alphabets[index]--;
            }
            
        }
        return true;
            
    }
}