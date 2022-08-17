class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> wordMap = new HashMap();
        for(String s:  strs){
            String sortedWord = getSortedString(s);
            if(!wordMap.containsKey(sortedWord)){
                List<String> arr = new ArrayList();
                arr.add(s);
                wordMap.put(sortedWord,arr);
            } else {
                List<String> temp = wordMap.get(sortedWord);
                temp.add(s);
                wordMap.put(sortedWord, temp);
            }
        }
        
        List<List<String>> ans = new ArrayList();
        for(String key : wordMap.keySet()){
            ans.add(wordMap.get(key));
        }
        return ans;
        
    }
    private String getSortedString(String word){
        // if(word.equals("")){
        //     return "";
        // }
        if(word.length() <= 1){
            return word;
        }
        char[] charArr = word.toCharArray();
        Arrays.sort(charArr);
        String sortedWord = new String(charArr);
        return sortedWord;
    }
}
