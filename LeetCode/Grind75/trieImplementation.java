/**
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.

https://www.youtube.com/watch?v=Br7Wt4V5o1c
 
 */

// using array 63 ms	67.2 MB	java
class TrieNode {
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
}

class Trie {

    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            if(cur.children[word.charAt(i) - 'a'] == null)
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            if(cur.children[word.charAt(i) - 'a'] == null)
                return false;
            cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0;i<prefix.length();i++){
            if(cur.children[prefix.charAt(i) - 'a'] == null)
                return false;
            cur = cur.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}


// using hashmap 51 ms	54 MB

class TrieNode {
    boolean isWord;
    HashMap<Integer,TrieNode> children = new HashMap<>();
    // TrieNode[] children = new TrieNode[26];
}

class Trie {

    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            if(cur.children.get(word.charAt(i) - 'a') == null)
                cur.children.put(word.charAt(i) - 'a', new TrieNode());
            cur = cur.children.get(word.charAt(i) - 'a');
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            if(cur.children.get(word.charAt(i) - 'a') == null)
                return false;
            cur = cur.children.get(word.charAt(i) - 'a');
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0;i<prefix.length();i++){
            if(cur.children.get(prefix.charAt(i) - 'a') == null)
                return false;
            cur = cur.children.get(prefix.charAt(i) - 'a');
        }
        return true;
    }
}