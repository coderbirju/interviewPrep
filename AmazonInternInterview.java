Question

You are given a potentially large list of words. Some of these are compounds, 
where all parts are also in the list. Identify all combinations where one words can 
be composed of two or more words of the same list and print or return them.

Sample Input: [rockstar, rock, star, rocks, tar, stars, rockstars, super, highway, high, way, superhighway]

Sample output print:

rockstar -> rock + star
rockstar -> rocks + tar
superhighway -> super + highway
superhighway -> super + high + way

rockstar

[
   rockstar, 
   rock, 
   star, 
   rocks, 
   tar, 
   stars, 
   rockstars, 
   super, 
   highway, 
   high, 
   way, 
   superhighway 
]

String[] check(String[] words){
    int n = words.length;
    Set<Srtring> set = new HashSet<String>();
    for(String word : words){
        set.add(word);
    }
    
    for(int i=0;i<words.length;i++){
        for(int j=0;j<words.length;j++){
            if(words[i].equals(words[j])
                continue;
            else{
                String substr = words[j];
                String Word = words[i];
                int len = substr.length();
                if(Word.substr(0,len).equals(words[j]) &&  Set.contains(Word.substr(len, Word.lengt()-1)))
                    return true; // add word to final answer
            }
        }
    }
    
}

Boolean checkIfPossible(String word, int position, String[] words){
    if(position == 0) return true;
    for(int i=0; i<words.length;i++){
        String sunStr = words[i];
        if(word.substring(position - sunStr.length()) == <any word in the remaining array of string>){
            
        }
    }
}