class Solution {
    public int trap(int[] height) {
        /*
            * 
        */
        int n = height.length;
        int totalRainWater = 0; 
        int[] leftBoundary = new int[n];
        int[] rightBoundary = new int[n];
        for(int i=1,j=n-2; i<n && j>=0 ;i++,j--){
            leftBoundary[i] =  Math.max(height[i-1], leftBoundary[i-1]);
            rightBoundary[j] = Math.max(height[j+1], rightBoundary[j+1]);
        }
        for(int i=0;i<n;i++){
            int limiter = Math.min(leftBoundary[i],rightBoundary[i]);
            totalRainWater += limiter - height[i] > 0 ? limiter - height[i] : 0;
        }
        
        return totalRainWater;
    }
}