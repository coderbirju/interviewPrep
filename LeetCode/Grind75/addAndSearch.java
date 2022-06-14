/**
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 3 dots in word for search queries.
At most 104 calls will be made to addWord and search.

video ex: https://www.youtube.com/watch?v=BTf05gs_8iU
written Ex: https://leetcode.com/problems/design-add-and-search-words-data-structure/discuss/1725327/JavaC%2B%2BPython-A-very-well-detailed-EXPLANATION!

*/

class TrieNode {
    boolean isWord;
    HashMap<Integer,TrieNode> children = new HashMap<>();
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public boolean dfs(TrieNode prev, String word){
        TrieNode cur = prev;
        for(int j=0;j<word.length();j++){
            char letter = word.charAt(j);
            if(letter == '.'){
                for(TrieNode node : cur.children.values()){
                    if(dfs(node,word.substring(j+1)))
                        return true;
                }
                return false;
            } else {
                if(cur.children.get(letter - 'a') == null)
                    return false;
                cur = cur.children.get(letter - 'a');
            }
        }
        return cur.isWord;
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            if(cur.children.get(word.charAt(i) - 'a') == null)
                cur.children.put(word.charAt(i) - 'a', new TrieNode());
            cur = cur.children.get(word.charAt(i) - 'a');
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(root, word);
    }
}
