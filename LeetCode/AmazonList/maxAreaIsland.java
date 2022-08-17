class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    int curArea = dfs(i,j,n,m, grid);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int i, int j, int n, int m, int[][] grid){
        if(i<0 || j<0 || i >= n || j >= m || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        int left = dfs(i,j-1,n,m,grid);
        int right = dfs(i,j+1,n,m,grid);
        int top = dfs(i-1,j,n,m,grid);
        int down = dfs(i+1,j,n,m,grid);
        return 1 + (left + right + top + down);
    }
    
}