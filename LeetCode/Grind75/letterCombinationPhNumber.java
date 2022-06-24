/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

 */

class Solution {
    HashMap<Integer,String> numAlphaMap;
    List<String> stringList;
    public List<String> letterCombinations(String digits) {
        numAlphaMap = new HashMap<>();
        stringList = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return stringList;
        // Create a hashmap of all the digits to corresponding characters
        numAlphaMap.put(2,"abc");
        numAlphaMap.put(3,"def");
        numAlphaMap.put(4,"ghi");
        numAlphaMap.put(5,"jkl");
        numAlphaMap.put(6,"mno");
        numAlphaMap.put(7,"pqrs");
        numAlphaMap.put(8,"tuv");
        numAlphaMap.put(9,"wxyz");
        
        /*
            number of characters allowed in a valid string = size of digits string
            each position in a valid string can be taken up by any one of the characters in the
            corresponding number map
            backTrack method recursively fills the ith position and calls itself for the next 
            position
            Base case is when we reach the last fillable position i.e
            size of curString == digits.length
        */
        backTrack("", 0,digits);
        return stringList;
    }
    
    public void backTrack(String curString, int curIndex, String digits){
        if(curIndex == digits.length()){
            stringList.add(curString);
            return;
        }
        int index = Character.getNumericValue(digits.charAt(curIndex));
        String mappedString = numAlphaMap.get(index);
        for(char c : mappedString.toCharArray()){
            backTrack(curString + c,curIndex+1,digits);
        }
    }
}