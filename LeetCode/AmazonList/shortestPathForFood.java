class Solution {
    public int getFood(char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length; i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '*'){
                    q.add(new int[]{i,j});
                }
            }
        }
        return minDist(grid, q);
    }
    
    private int minDist(char[][] grid, Queue<int[]> q){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // if(q.isEmpty())
        //     return -1;
        int count =0;
         while(!q.isEmpty()){
             int size = q.size();
             count++;
             for(int i=0;i<size;i++){
                 int[] cur = q.poll();
                 int row = cur[0];
                 int col = cur[1];
                 visited[cur[0]][cur[1]] = true;
                   if(grid[cur[0]][cur[1]]=='#'){
                    return count-1;
                }
                
//                  for(int[] dir : directions){
//                      int nx = cur[0] + dir[0];
//                      int ny = cur[1] + dir[1];
                     
//                      if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && !visited[nx][ny] && grid[nx][ny] !='X'){
//                          if(grid[nx][ny] == '#')
//                          return count;
//                          q.add(new int[]{nx,ny});
//                      }
//                  }
                 if(row - 1 >= 0 && !visited[row - 1][col] && grid[row - 1][col] != 'X') {
                    visited[row - 1][col] = true;
                    q.add(new int[]{row - 1, col});
                }
                
                if(row + 1 < grid.length && !visited[row + 1][col] && grid[row + 1][col] != 'X') {
                    visited[row + 1][col] = true;
                    q.add(new int[]{row + 1, col});
                }
                
                if(col - 1 >= 0 && !visited[row][col - 1] && grid[row][col - 1] != 'X') {
                    visited[row][col - 1] = true;
                    q.add(new int[]{row, col - 1});
                }
                
                if(col + 1 < grid[0].length && !visited[row][col + 1] && grid[row][col + 1] != 'X') {
                    visited[row][col + 1] = true;
                    q.add(new int[]{row, col + 1});
                }
                 
             }
         }
        return -1;
    }
    
}