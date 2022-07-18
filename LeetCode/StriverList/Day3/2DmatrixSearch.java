class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i=0;
        for(i=0;i<n;i++){
            if(matrix[i][0] > target){
                break;
            }
        }
        int row = i==0 ? i : i-1;
        return binarySearch(matrix[row], target, 0, matrix[row].length-1);
    }
    
    public boolean binarySearch(int[] arr, int target, int start, int end){
         if(start <= end){
            int n = arr.length;
            int mid = start + (end-start)/2;
            if(arr[mid] == target)
                return true;
            else if(arr[mid] < target)
                return binarySearch(arr,target,mid + 1,end);
            else 
                return binarySearch(arr, target, start, mid-1);   
        }
        return false;
    }
}