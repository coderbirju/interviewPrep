class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        // transpose the matrix;
        for(int i=0;i<m;i++){
            for(int j=i;j<m;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // reverse each row
        for(int i=0;i<m;i++){
            int end = m-1;
            int start = 0;
            while(start<end){
                int temp = matrix[i][start];
                matrix[i][start++] = matrix[i][end];
                matrix[i][end--] = temp;
            }
        }
    }
}