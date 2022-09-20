class TrieNode {
    List<String> matchedWords;
    HashMap<Integer, TrieNode> children;
    TrieNode() {
            matchedWords = new ArrayList();
            children = new HashMap();
        }
}

class Solution {
    TrieNode root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new TrieNode();
        List<List<String>> ans = new ArrayList();
        Arrays.sort(products); // sort list so that we get the string in lexicographical order
        for(String product : products){
            // for each string start from the root of the trie and check for prefix
            TrieNode cur = root;
            for(int i=0;i<product.length();i++){
                // if the prefix has never been seen before then create a new trie node in that index
                if(cur.children.get(product.charAt(i) - 'a' ) == null){
                    cur.children.put(product.charAt(i) - 'a',new TrieNode());
                }
                // move into that node
                cur = cur.children.get(product.charAt(i) - 'a');
                // if for that prefix if the number of words stored is less than 3 add the current word into the matched
                if(cur.matchedWords.size() < 3){
                    cur.matchedWords.add(product);
                }
            }       
        }
        int i =0;  
        TrieNode itr = root;
        for(char ch : searchWord.toCharArray()){
            // for each character in the search key word, get the node at the position if it exisits
            int index = ch - 'a';
            if(itr.children.get(index) == null){
                // if it doesn't exisits then the searched word is not present, so for all characters in the searched word from that position simply return an empty array, because there is nothing to predict
                for(int j=0;j<searchWord.length() - i;j++){
                    ans.add(new ArrayList());
                }
                return ans;
            }x
            // otherwise move into the next trieNode and append the precomputed words at that node into the final answer
            itr = itr.children.get(index);
            ans.add(itr.matchedWords);
            i++; // not required
        }        
        return ans;
    }
    
//     private void buildTrie(String[] products, TrieNode root){
//         TrieNode cur = root;
//         for(String product : products){
//             for(int i=0;i<product.length();i++){
//                 if(cur.children.get(product.charAt(i) - 'a' ) == null){
//                     cur.children.put(product.charAt(i) - 'a',new TrieNode());
//                 }
//                 cur = cur.children.get(product.charAt(i) - 'a');
//                 if(cur.matchedWords.size() < 3){
//                     cur.matchedWords.add(product);
//                     System.out.println(" product -->" + product + cur.matchedWords.toString());
//                 }
                
//             }       
//         }
//     }
    
//     private void getSuggestionsRecursive(List<List<String>> ans, String searchWord, TrieNode root){
//         Character cur = searchWord.charAt(0);
//         int index = cur - 'a';
//         if(root.children.get(index) == null){
//             ans.add(new ArrayList());
//             return;
//         }
//         ans.add(root.matchedWords);
//         if(searchWord.length() == 1)
//             return;
//         getSuggestionsRecursive(ans, searchWord.substring(1,searchWord.length()), root.children.get(index));
//     }
}