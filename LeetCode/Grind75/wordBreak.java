/*
* Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
*/


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
            Back tracking solution, as it needs the permutations of the string to be found
            
            Maintain a dp array of size = size of string
            the dp[size]th value is set as true, this signifies that the whole string can be broken into parts
            start from position len-1;
            now for each word in wordDict
                check if position + word.length - 1 is within range and if they are equal
                    if yes then set dp[pos] = dp[pos + word.length]
                    this checks if the word can be broken correctly after the current break
                    if(dp[pos] == true) we found atleast one solution till pos so break and check from next position

                when we reach pos = 0 end the loop
                return dp[0]
                
                
                "leetcode", wordDict = ["leet","code"]
        */
        
        int n = s.length();
        
        boolean[] dp = new boolean[n+1];
        Arrays.fill(dp,false);
        dp[n] = true;
        int pos = n-1;
        int min = n+1;
        for(int i=n-1; i>=0; i--){
            for(String word : wordDict){
                int wordLen = word.length();
                // min = Math.min(wordLen,min);
                if(i+wordLen <= n){
                    String broken = s.substring(i, i+wordLen);
                    if(broken.equals(word))
                        dp[i] = dp[i+wordLen];
                    if(dp[i])
                        break;
                } 
            }
            // pos = pos-min;
        }
        return dp[0];
        
    }
}