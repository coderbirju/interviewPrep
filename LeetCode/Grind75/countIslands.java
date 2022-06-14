/*
* Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), 
return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

 
Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'

*/




// Dfs is similar.. just make all the visited positions as water.. called drowning
class Solution {
    int n;
    int m;

    public void sink(char[][] grid, int adRow, int adCol){
        if(adRow < 0 || adRow >= n || adCol < 0 || adCol >= m || grid[adRow][adCol] == '0' )
            return;
        grid[adRow][adCol] = '0';
        sink(grid, adRow+1,adCol);
        sink(grid, adRow-1,adCol);
        sink(grid, adRow,adCol+1);
        sink(grid, adRow,adCol-1);
        return;
    }
    
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        // boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    System.out.println("row: "+ i + " col :"+j);
                    count++;
                    sink(grid,i,j);
                }
            }
        }
        return count;
       
    }
}







// BFS solution 
class Solution {
    int n;
    int m;
    public void bfs(char[][] grid, int row, int col, boolean[][] visited){
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair(row,col));
        visited[row][col] = true;
        while(!q.isEmpty()){
            Pair<Integer,Integer> pos = q.poll();
            for(int[] move: direction){
                int adRow = pos.getKey() + move[0];
                int adCol = pos.getValue() + move[1];
                if(adRow >= 0 && adRow < n && adCol >= 0 && adCol < m && grid[adRow][adCol] == '1' && !visited[adRow][adCol]){
                    q.add(new Pair(adRow,adCol));
                    visited[adRow][adCol] = true;
                }
            }
        }
        
    }
    
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    System.out.println("row: "+ i + " col :"+j);
                    count++;
                    bfs(grid,i,j, visited);
                }
            }
        }
        return count;
       
    }
}


