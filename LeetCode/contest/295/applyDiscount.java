/** 
A sentence is a string of single-space separated words where each word can contain digits, lowercase letters, and the dollar sign '$'. A word represents a price if it is a non-negative real number preceded by a dollar sign.

For example, "$100", "$23", and "$6.75" represent prices while "100", "$", and "2$3" do not.
You are given a string sentence representing a sentence and an integer discount. For each word representing a price, apply a discount of discount% on the price and update the word in the sentence. All updated prices should be represented with exactly two decimal places.

Return a string representing the modified sentence.

 

Example 1:

Input: sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
Output: "there are $0.50 $1.00 and 5$ candies in the shop"
Explanation: 
The words which represent prices are "$1" and "$2". 
- A 50% discount on "$1" yields "$0.50", so "$1" is replaced by "$0.50".
- A 50% discount on "$2" yields "$1". Since we need to have exactly 2 decimal places after a price, we replace "$2" with "$1.00".
Example 2:

Input: sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
Output: "1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
Explanation: 
Applying a 100% discount on any price will result in 0.
The words representing prices are "$3", "$5", "$6", and "$9".
Each of them is replaced by "$0.00".
 

Constraints:

1 <= sentence.length <= 105
sentence consists of lowercase English letters, digits, ' ', and '$'.
sentence does not have leading or trailing spaces.
All words in sentence are separated by a single space.
All prices will be positive integers without leading zeros.
All prices will have at most 10 digits.
0 <= discount <= 100







Not WORKING for  input 
"duew$11mengf $8 $1"
7

Output:
"duew$0.931mengf $7.44 $0.93"
Expected:
"duew$11mengf $7.44 $0.93"

*/

class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] arrOfWords = sentence.split(" ");
        String ans = sentence;
        for(String word: arrOfWords){
            if(word.charAt(0) == '$' && isNumeric(word.substring(1))){
                String rep = word;
                word = word.replace("$","");
                int num = Integer.parseInt(word);
                double disc = (double)discount/100;
                // System.out.println("disc " + disc);
                double discountedInt = (double)num * (1-disc);
                // System.out.println("discountedInt " + discountedInt);
                word = "$" + String.format("%.2f", discountedInt); // String.valueOf(discountedInt);
                ans = ans.replace(rep,word);
            }
        }
        return ans;
    }
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}