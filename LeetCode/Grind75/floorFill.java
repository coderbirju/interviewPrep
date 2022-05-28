/* 
733. Flood Fill
Easy

4182

394

Add to List

Share
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]
 

Constraints:
m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], newColor < 216
0 <= sr < m
0 <= sc < n

*/




class Solution {
    public int[][] Directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        /* 
            BFS Algo:
            1.add the sr,sc to queue. Mark the position as visited
            2. while queue is not empty
                dequeue the element, check its 4-directionally adjacent pixels
                if already visited, ignore
                else add them to the queue
                change the color of the current element
                repeat step 2 till the queue is empty
            3. return the new matrix
        */
        
        /*
            DFS Algo:
            1. create a visited matrix, set every point as not visited
            2. Call dfs on sr,sc position
                set sr,sc as visited
                call dfs(sr,sc)
                    for each 4-directionally adjacent pixels i,j and validPixel i,j and image[i][j] is same as sr,sc
                    call dfs(i,j)
                image[sr][sc] = newColor
            3. return image
                
        */
        
        if(image == null){
            return null;
        }
        int n = image.length;
        int m = image[0].length;
        int[][] visited = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m;j++){
                visited[i][j] = 0;
            }
        }
        
        changeColour(image, sr, sc, newColor, visited);
        return image;
    }
    
    public void changeColour(int[][] image, int sr, int sc, int newColor, int[][] visited){
        visited[sr][sc] = 1;
        for(int[] nextMove: Directions){
            int i = sr + nextMove[0];
            int j = sc + nextMove[1];
            if(isValid(i,j,image) && visited[i][j] == 0 && image[i][j] == image[sr][sc]){
                changeColour(image,i,j,newColor,visited);
            }
        }
        image[sr][sc] = newColor;
    }
    
    public boolean isValid(int row, int col, int[][] image){
        int n = image.length;
        int m = image[0].length;
        boolean rowValid = row >=0 && row <n;
        boolean colValid = col >=0 && col < m;
        return rowValid && colValid;
    }
}