/*
* Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, 
where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?
 */


class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == word.charAt(0) && dfs(i,j,board,0, word))
                    return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, char[][] board, int curLen, String word) {
        if(curLen == word.length())
            return true;
        if(i<0 || i >= board.length || j < 0 || j>= board[0].length || board[i][j] != word.charAt(curLen))
            return false;
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(i,j+1,board,curLen + 1,word) || dfs(i,j-1,board,curLen + 1,word) 
            || dfs(i-1,j,board,curLen + 1,word) || dfs(i+1,j,board,curLen + 1,word);
        board[i][j] = temp;
        return found;
    }
    
}