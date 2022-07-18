/**
Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

 

Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.

 */

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() > typed.length())
            return false;
        if(name.equals(typed))
            return true;
        /*
        if name length is greater than typed then obviously typed is wrong
        if they're equal then true
        */
        int p1=0,p2=0; // pointers for each string
        int n = name.length();
        int m = typed.length();
        
        while(p1 < n && p2 < m){
            char c1 = name.charAt(p1);
            char c2 = typed.charAt(p2);
            if(c1 != c2)
                return false; // each comparision is according to the correct order of characters
            int count1=0, count2=0; // count repeated charaters
           while(p1 <n && name.charAt(p1) == c1){
               p1++;
               count1++;
           }
            while(p2<m && typed.charAt(p2) == c2){
                p2++;
                count2++;
            }
           
            if(count2<count1)
                return false;
            // if the typed number of repeated character is less than the name then it's false
        }
        // check to see if both the strings have reached their end
        return p1==n && p2==m;
       
    }
}