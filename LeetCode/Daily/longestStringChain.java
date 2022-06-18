/**
You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.

 

Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
Example 2:

Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
Example 3:

Input: words = ["abcd","dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of lowercase English letters.
 */

class Solution {
    
    /*
        sort based on string length
        
    */
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a, b)->Integer.compare(a.length(), b.length()));
        HashMap<String,Integer> map = new HashMap<>();
        map.put(words[0],1);
        int maxChain = 0;
        for(String word : words){
            int len = word.length();
            map.put(word,1);
            for(int i=0;i<len;i++){
                StringBuilder current = new StringBuilder(word);
                String prev = current.deleteCharAt(i).toString();
                int maxPrev = map.getOrDefault(prev,0);
                map.put(word, Math.max(map.get(word),maxPrev +1));
                
            }
            maxChain = Math.max(maxChain,map.get(word));
            // while(i<len){
            //     String substr = word.substring(0,i) + word.substring(i+1,len);
            //     int curSize = map.findOrDefault(substr,0);
            // }
        }
        return maxChain;
    }
}